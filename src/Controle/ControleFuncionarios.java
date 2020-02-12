/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ModeloFuncionarios;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Murylo César Souza
 */
public class ControleFuncionarios {

    ConectaBanco conFun = new ConectaBanco();
    ConectaBanco conCidade = new ConectaBanco();
    cadastro obj_config = new cadastro();

    public ControleFuncionarios() {
        obj_config.carregaconfig();
           conFun.Conexao(obj_config._url);
    }
    int codCidade;
    String nomeCidade;

    public void GravarFuncionarios(ModeloFuncionarios mod) {
     
        buscaCodigoCidade(mod.getId_cidade());// buscar codigo da cidade
        try {
//            conFun.Conexao(obj_config._url);
            PreparedStatement pst = conFun.conn.prepareStatement("insert into tb_funcionarios (id_funcionario ,datacad , nome , sexo , datanasc , estado_civil , endereco,bairro,numero,cep ,id_cidade ,fone1 , fone2, email , salario ,setor,data_pagamento,status) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            pst.setInt(1, mod.getId_funcionario());
            pst.setDate(2, mod.getDatacad());
            pst.setString(3, mod.getNome());
            pst.setString(4, mod.getSexo());
            pst.setDate(5, mod.getDatanasc());
            pst.setString(6, mod.getEstado_civil());
            pst.setString(7, mod.getEndereco());
            pst.setString(8, mod.getBairro());
            pst.setString(9, mod.getNumero());
            pst.setString(10, mod.getCep());
            pst.setInt(11, codCidade);
            pst.setString(12, mod.getTelefone1());
            pst.setString(13, mod.getTelefone2());
            pst.setString(14, mod.getEmail());
            pst.setDouble(15, mod.getSalario());
            pst.setString(16, mod.getSetor());
            pst.setInt(17, mod.getData_pagamento());
            pst.setString(18, mod.getStatus());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível inserir o registro!\n\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            conFun.Desconecta();
        }
    }

    public void AlterarFuncionarios(ModeloFuncionarios mod) {
//        conFun.Conexao(obj_config._url);
        buscaCodigoCidade(mod.getId_cidade());
        try {

            PreparedStatement pst = conFun.conn.prepareStatement("update tb_funcionarios set datacad = ? , nome = ? , sexo = ? , datanasc = ? , estado_civil = ? , endereco = ? , bairro = ? , numero = ? , cep = ? , id_cidade = ? , fone1 = ? , fone2 = ? , email = ? , salario = ? , setor = ? , data_pagamento = ? ,status = ? where id_funcionario = ?");

            pst.setDate(1, mod.getDatacad());
            pst.setString(2, mod.getNome());
            pst.setString(3, mod.getSexo());
            pst.setDate(4, mod.getDatanasc());
            pst.setString(5, mod.getEstado_civil());
            pst.setString(6, mod.getEndereco());
            pst.setString(7, mod.getBairro());
            pst.setString(8, mod.getNumero());
            pst.setString(9, mod.getCep());
            pst.setInt(10, codCidade);
            pst.setString(11, mod.getTelefone1());
            pst.setString(12, mod.getTelefone2());
            pst.setString(13, mod.getEmail());
            pst.setDouble(14, mod.getSalario());
            pst.setString(15, mod.getSetor());
            pst.setInt(16, mod.getData_pagamento());
            pst.setString(17, mod.getStatus());
            pst.setInt(18, mod.getId_funcionario());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível alterado o registro!\n\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void ExcluirFuncionarios(ModeloFuncionarios mod) {

//        conFun.Conexao(obj_config._url);
        try {
            PreparedStatement pst = conFun.conn.prepareStatement("delete from tb_funcionarios where id_funcionario = ? ");
            pst.setInt(1, mod.getId_funcionario());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel excluir o registro!");
        }
    }

    public void buscaCodigoCidade(String nome) {
        conCidade.Conexao(obj_config._url);
        conCidade.executaSQL("select id_cidade from tb_cidades where nome = '" + nome + "'");
        try {
            conCidade.rs.first();
            codCidade = conCidade.rs.getInt("id_cidade");
            conCidade.Desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar a cidade cadastro com este código!");

        }

    }

}
