/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ModeloVendas;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Murylo César Souza
 */
public class ControleVenda {

    ConectaBanco controle = new ConectaBanco();
    ConectaBanco conCliente = new ConectaBanco();
    ConectaBanco conFuncionarios = new ConectaBanco();
    ConectaBanco conVeiculos = new ConectaBanco();

    cadastro obj_config = new cadastro();

    public ControleVenda() {
        obj_config.carregaconfig();
    }

    int codCliente, codFuncionarios;
    String nomeCidade;

    public void GravarVenda(ModeloVendas mod) {
        controle.Conexao(obj_config._url);
        buscaCodigoCliente(mod.getCliente());// buscar codigo da cidade
        buscaCodigoFuncionario(mod.getFuncionario());
        try {

            PreparedStatement pst = controle.conn.prepareStatement("update tb_veiculos set status = ? where id_veiculo = ? ");
            pst.setString(1, "F");
            pst.setInt(2,  mod.getId_veiculo());
            pst.execute();

            pst = controle.conn.prepareStatement("insert into tb_vendas (id_venda , datacad ,id_cliente , id_funcionario, id_veiculo ,forma_pagamento ,valor_total ,tempo_garantia , tipo_garantia , banco, valor_financiado ,nulo) values (?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, mod.getId_venda());
            pst.setDate(2, mod.getDatacad());
            pst.setInt(3, codCliente);
            pst.setInt(4, codFuncionarios);
            pst.setInt(5, mod.getId_veiculo());
            pst.setString(6, mod.getForma_pagamento());
            pst.setDouble(7, mod.getValor_total());
            pst.setInt(8, mod.getTempo_garantia());
            pst.setString(9, mod.getTipo_garantia());
            pst.setString(10, mod.getBanco());
            pst.setDouble(11, mod.getValor_financiado());
            pst.setString(12, "F");
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível inserir o registro!" + ex);

        }
        controle.Desconecta();
    }

    public void AlterarVenda(int id_venda, int id_veiculo) {
        controle.Conexao(obj_config._url);
        try {

            PreparedStatement pst = controle.conn.prepareStatement("update tb_veiculos set status = ? where id_veiculo = ? ");
            pst.setString(1, "T");
            pst.setInt(2, id_veiculo);
            pst.execute();
            pst = controle.conn.prepareStatement("update tb_vendas set  nulo = ? where id_venda = ?");
            pst.setString(1, "T");
            pst.setInt(2, id_venda);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro anulado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível anulado o registro!" + ex);
        }

    }

    public void ExcluirVenda(int id_venda) {

        controle.Conexao(obj_config._url);
        try {
            PreparedStatement pst = controle.conn.prepareStatement("delete from tb_vendas where id_venda = ? ");
            pst.setInt(1, id_venda);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel excluir o registro!" + ex);
        }
    }

    public void buscaCodigoCliente(String nome) {
        conCliente.Conexao(obj_config._url);
        conCliente.executaSQL("select id_cliente_fornecedor from tb_clientes_fornecedores where nome = '" + nome + "'");
        try {
            conCliente.rs.first();
            codCliente = conCliente.rs.getInt("id_cliente_fornecedor");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar a cidade cadastro com este código!");
        }
        conCliente.Desconecta();
    }

    public void buscaCodigoFuncionario(String nome) {
        conFuncionarios.Conexao(obj_config._url);
        conFuncionarios.executaSQL("select id_funcionario from tb_funcionarios where nome = '" + nome + "'");
        try {
            conFuncionarios.rs.first();
            codFuncionarios = conFuncionarios.rs.getInt("id_funcionario");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar a cidade cadastro com este código!");
        }
        conFuncionarios.Desconecta();
    }

}
