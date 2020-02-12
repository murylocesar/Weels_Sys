/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ModeloTroca;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Murylo César Souza
 */
public class ControleTroca {

    ConectaBanco controle = new ConectaBanco();
    ConectaBanco conCliente = new ConectaBanco();
    ConectaBanco conFuncionarios = new ConectaBanco();
    ConectaBanco conVeiculos = new ConectaBanco();
    cadastro obj_config = new cadastro();

    public ControleTroca() {
        obj_config.carregaconfig();
    }
    int codCliente, codFuncionarios;
    String nomeCidade;

    public void GravarTroca(ModeloTroca mod) {
        controle.Conexao(obj_config._url);
        buscaCodigoCliente(mod.getCliente());// buscar codigo da cidade
        buscaCodigoFuncionario(mod.getFuncionario());
        try {

            PreparedStatement pst = controle.conn.prepareStatement("update tb_veiculos set status = ? where id_veiculo = ? ");
            pst.setString(1, "F");
            pst.setInt(2, mod.getId_veiculo());
            pst.execute();
            pst = controle.conn.prepareStatement("insert into tb_troca (id_troca , datacad , id_cliente , id_funcionario , id_veiculo , id_veiculo_entrada ,valor_troca , forma_pagamento , tempo_garantia , tipo_garantia , banco, valor_financiado,nulo) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");

            pst.setInt(1, mod.getId_troca());
            pst.setDate(2, mod.getDatacad());
            pst.setInt(3, codCliente);
            pst.setInt(4, codFuncionarios);
            pst.setInt(5, mod.getId_veiculo());
            pst.setInt(6, mod.getId_veiculo_entrada());
            pst.setDouble(7, mod.getValor_troca());
            pst.setString(8, mod.getForma_pagamento());
            pst.setInt(9, mod.getTempo_garantia());
            pst.setString(10, mod.getTipo_garantia());
            pst.setString(11, mod.getBanco());
            pst.setDouble(12, mod.getValor_financiado());
            pst.setString(13, mod.getNulo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível inserir o registro!\n\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        controle.Desconecta();
    }

    public void AlterarTroca(int id_compra, int id_veiculo, int id_veiculo_entrada) {
        controle.Conexao(obj_config._url);
        try {
            controle.executaSQL("select status from tb_veiculos where status = 'T' and id_veiculo = '" + id_veiculo + "'");
            
            if (controle.rs.first()) {

                PreparedStatement pst = controle.conn.prepareStatement("update tb_veiculos set status = ? where id_veiculo = ? ");
                pst.setString(1, "T");
                pst.setInt(2, id_veiculo);
                pst.execute();
                pst = controle.conn.prepareStatement("update tb_veiculos set status = ? where id_veiculo = ? ");
                pst.setString(1, "A");
                pst.setInt(2, id_veiculo_entrada);
                pst.execute();
                pst = controle.conn.prepareStatement("update tb_troca set  nulo = ? where id_troca = ?");
                pst.setString(1, "T");
                pst.setInt(2, id_compra);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Registro anulado com sucesso!");

            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível anula a troca\n"
                        + "Por que o veiculo já foi vendido ou trocado!\n\n", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível anula a compra!\n\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ExcluirTroca(int id_troca) {

        controle.Conexao(obj_config._url);
        conVeiculos.Conexao(obj_config._url);
        try {
            conVeiculos.executaSQL("select V.id_veiculo from tb_veiculos V ,tb_troca T  where V.id_veiculo = T.id_compra and T.id_troca = '" + id_troca + "'");
            conVeiculos.rs.first();
            PreparedStatement pst = controle.conn.prepareStatement("delete from tb_troca where id_troca = ? ");
            pst.setInt(1, id_troca);
            pst.execute();
            pst = controle.conn.prepareStatement("delete from tb_veiculos where id_veiculo = ?");
            pst.setInt(1, conVeiculos.rs.getInt("id_veiculo"));
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel excluir o registro!\n\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void buscaCodigoCliente(String nome) {
        conCliente.Conexao(obj_config._url);
        conCliente.executaSQL("select * from tb_clientes_fornecedores where nome = '" + nome + "'");
        try {
            conCliente.rs.first();
            codCliente = conCliente.rs.getInt("id_cliente_fornecedor");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar a o código do cliente cadastro com este nome '" + nome + "'!\n\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        conCliente.Desconecta();
    }

    public void buscaCodigoFuncionario(String nome) {
        conFuncionarios.Conexao(obj_config._url);
        conFuncionarios.executaSQL("select * from tb_funcionarios where nome = '" + nome + "'");
        try {
            conFuncionarios.rs.first();
            codFuncionarios = conFuncionarios.rs.getInt("id_funcionario");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar a o código do funcionário cadastro com este nome '" + nome + "'!\n\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        conFuncionarios.Desconecta();
    }

}
