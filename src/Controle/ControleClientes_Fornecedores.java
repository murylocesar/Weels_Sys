/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ModeloClientes_Fornecedores;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Murylo César Souza
 */
public class ControleClientes_Fornecedores {

    ConectaBanco conCliente = new ConectaBanco();
    ConectaBanco conCidade = new ConectaBanco();
    cadastro obj_config = new cadastro();

    public ControleClientes_Fornecedores() {
        obj_config.carregaconfig();
        conCliente.Conexao(obj_config._url);
    }

    public void GravarCliente_Fornecedor(ModeloClientes_Fornecedores mod) {
        conCidade.Conexao(obj_config._url);
        buscaCodigoCidade(mod.getId_cidade());
        try {
            conCliente.Conexao(obj_config._url);
            PreparedStatement pst = conCliente.conn.prepareStatement("insert into tb_clientes_fornecedores (id_cliente_fornecedor ,fisica_juridica, nome , cpf_cnpj,endereco,bairro,numero,cep ,id_cidade ,estado_civil,datanasc , datacad ,sexo,fone1 ,fone2,email) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            pst.setInt(1, mod.getId_cliente_fornecedor());
            pst.setString(2, mod.getCliente_fornecedor());
            pst.setString(3, mod.getNome());
            pst.setString(4, mod.getCpf());
            pst.setString(5, mod.getEndereco());
            pst.setString(6, mod.getBairro());
            pst.setString(7, mod.getNumero());
            pst.setString(8, mod.getCep());
            pst.setInt(9, buscaCodigoCidade(mod.getId_cidade()));// buscar código da cidade
            pst.setString(10, mod.getEstado_civil());
            pst.setDate(11, mod.getDatanasc());
            pst.setDate(12, mod.getDatacad());
            pst.setString(13, mod.getSexo());
            pst.setString(14, mod.getTelefone1());
            pst.setString(15, mod.getTelefone2());
            pst.setString(16, mod.getEmail());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível inserir o registro!" + ex);

        }
        conCliente.Desconecta();
        conCidade.Desconecta();
    }

    public void AlterarCliente_Fornecedor(ModeloClientes_Fornecedores mod) {
        try {
            conCliente.Conexao(obj_config._url);
            PreparedStatement pst = conCliente.conn.prepareStatement("update tb_clientes_fornecedores set fisica_juridica = ? , nome = ?, cpf_cnpj = ? ,endereco = ? , bairro = ? , numero = ? ,cep = ? , id_cidade = ? ,estado_civil = ? ,datanasc = ?, datacad = ?,sexo = ? , fone1 = ? ,fone2 = ?, email = ? where id_cliente_fornecedor = ?");

            pst.setString(1, mod.getCliente_fornecedor());
            pst.setString(2, mod.getNome());
            pst.setString(3, mod.getCpf());
            pst.setString(4, mod.getEndereco());
            pst.setString(5, mod.getBairro());
            pst.setString(6, mod.getNumero());
            pst.setString(7, mod.getCep());
            pst.setInt(8, buscaCodigoCidade(mod.getId_cidade()));// buscar código da cidade
            pst.setString(9, mod.getEstado_civil());
            pst.setDate(10, mod.getDatanasc());
            pst.setDate(11, mod.getDatacad());
            pst.setString(12, mod.getSexo());
            pst.setString(13, mod.getTelefone1());
            pst.setString(14, mod.getTelefone2());
            pst.setString(15, mod.getEmail());
            pst.setInt(16, mod.getId_cliente_fornecedor());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível alterado o registro!\n\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        conCliente.Desconecta();
        conCidade.Desconecta();
    }

    public void ExcluirCliente_Fornecedor(int id_cliente) {
        try {
            PreparedStatement pst = conCliente.conn.prepareStatement("delete from tb_clientes_fornecedores where id_cliente_fornecedor = ? ");
            pst.setInt(1, id_cliente);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel excluir o registro!\n\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int buscaCodigoCidade(String nome) {
        conCidade.Conexao(obj_config._url);
        conCidade.executaSQL("select * from tb_cidades where nome = '" + nome + "'");
        try {
            conCidade.rs.first();
            return conCidade.rs.getInt("id_cidade");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar o código da cidade com esse nome '" + nome + "'!\n\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return -1;

    }
}
