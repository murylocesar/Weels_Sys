/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ModeloCompras;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Murylo César Souza
 */
public class ControleCompras {

    ConectaBanco controle = new ConectaBanco();
    ConectaBanco conCliente = new ConectaBanco();
    ConectaBanco conFuncionarios = new ConectaBanco();
    ConectaBanco conVeiculos = new ConectaBanco();
    cadastro obj_config = new cadastro();

    public ControleCompras() {
        obj_config.carregaconfig();
        controle.Conexao(obj_config._url);
    }

    int codCliente, codFuncionarios;
    String nomeCidade;

    public void GravarCompra(ModeloCompras mod) {
        buscaCodigoCliente(mod.getId_fornecedor());// buscar codigo da cidade
        buscaCodigoFuncionario(mod.getId_funcionario());
        try {
            PreparedStatement pst = controle.conn.prepareStatement("insert into tb_compras (id_compra ,id_veiculo, datacad ,id_fornecedor , id_funcionario,nulo,valor) values (?,?,?,?,?,?,?)");

            pst.setInt(1, mod.getId_compra());
            pst.setInt(2, mod.getId_veiculo());
            pst.setDate(3, mod.getDatacad());
            pst.setInt(4, codCliente);
            pst.setInt(5, codFuncionarios);
            pst.setString(6, "F");
            pst.setDouble(7, mod.getValor());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível inserir o registro!" + ex);

        }
        controle.Desconecta();
    }

    public void AlterarCompra(int id_compra, int id_veiculo) {
        try {
            controle.executaSQL("select V.id_veiculo from tb_veiculos V ,tb_vendas Ve ,tb_troca T where V.id_veiculo = '" + id_veiculo + "' and (T.id_veiculo = V.id_veiculo or Ve.id_veiculo=V.id_veiculo )");
            if (!controle.rs.first()) {

                PreparedStatement pst = controle.conn.prepareStatement("update tb_veiculos set status = ? where id_veiculo = ? ");
                pst.setString(1, "A");
                pst.setInt(2, id_veiculo);
                pst.execute();
                pst = controle.conn.prepareStatement("update tb_compras set  nulo = ? where id_compra = ?");
                pst.setString(1, "T");
                pst.setInt(2, id_compra);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Registro anulado com sucesso!");

            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível anula a compra\n"
                        + "Por que o veiculo já foi vendido ou trocado!\n\n", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível anula a compra!\n\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void ExcluirCompra(int id_compras) {

        conVeiculos.Conexao(obj_config._url);
        try {
            conVeiculos.executaSQL("select V.id_veiculo from tb_veiculos V ,tb_compras C  where V.id_veiculo = C.id_compra and C.id_compra = '" + id_compras + "'");
            conVeiculos.rs.first();
            PreparedStatement pst = controle.conn.prepareStatement("delete from tb_compras where id_compra = ? ");
            pst.setInt(1, id_compras);
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
        conCliente.executaSQL("select id_cliente_fornecedor from tb_clientes_fornecedores where nome = '" + nome + "'");
        try {
            conCliente.rs.first();
            codCliente = conCliente.rs.getInt("id_cliente_fornecedor");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar o código do cliente cadastro com este nome!");
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
            JOptionPane.showMessageDialog(null, "Não foi possível localizar o código do funcionario cadastro com este nome!");
        }
        conFuncionarios.Desconecta();
    }

}
