/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ModeloCidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Aparecida dos Reis
 */
public class ControleCidade {

    ConectaBanco conCid = new ConectaBanco();
    ModeloCidade modelo = new ModeloCidade();
    cadastro obj_config = new cadastro();

    public ControleCidade() {
        obj_config.carregaconfig();
        conCid.Conexao(obj_config._url);
    }

    public void GravarCidade(ModeloCidade mod) {

        try {
            PreparedStatement pst = conCid.conn.prepareStatement("insert into tb_cidades(id_cidade,nome,uf)values (?,?,?)");
            pst.setInt(1, mod.getCodigo());
            pst.setString(2, mod.getNome());
            pst.setString(3, mod.getUf());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível inserir o registro!");
        }
        conCid.Desconecta();
    }

    public void AlterarCidade(ModeloCidade mod) {
        try {
            PreparedStatement pst = conCid.conn.prepareStatement("update tb_cidades set nome = ?, uf = ? where id_cidade = ? ");

            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getUf());
            pst.setInt(3, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel alterar o registro!");
        }
    }

    public void ExcluirCidade(int Id_cidade) {
        try {
            PreparedStatement pst = conCid.conn.prepareStatement("delete from tb_cidades where id_cidade = ?");
            pst.setInt(1, Id_cidade);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel excluir o registro!");
        }
    }

    public ModeloCidade Primeiro() {
        conCid.Conexao(obj_config._url);

        try {
            conCid.executaSQL("select * from tb_cidades order by id_cidade");
            conCid.rs.first();
            modelo.setCodigo(conCid.rs.getInt("id_cidade"));
            modelo.setNome(conCid.rs.getString("nome"));
            modelo.setUf(conCid.rs.getString("uf"));
        } catch (SQLException ex) {

        }

        return modelo;
    }

    public ModeloCidade Proximo() {

        conCid.Conexao(obj_config._url);
        try {
            conCid.rs.next();
            modelo.setCodigo(conCid.rs.getInt("id_cidade"));
            modelo.setNome(conCid.rs.getString("nome"));
            modelo.setUf(conCid.rs.getString("uf"));
        } catch (SQLException ex) {

        }

        return modelo;
    }

    public ModeloCidade Anterior() {
        conCid.Conexao(obj_config._url);

        try {

            conCid.rs.previous();
            modelo.setCodigo(conCid.rs.getInt("id_cidade"));
            modelo.setNome(conCid.rs.getString("nome"));
            modelo.setUf(conCid.rs.getString("uf"));
        } catch (SQLException ex) {

        }

        return modelo;
    }

    public ModeloCidade Ultimo() {
        conCid.Conexao(obj_config._url);

        try {
            conCid.executaSQL("select * from tb_cidades order by id_cidade");
            conCid.rs.last();
            modelo.setCodigo(conCid.rs.getInt("id_cidade"));
            modelo.setNome(conCid.rs.getString("nome"));
            modelo.setUf(conCid.rs.getString("uf"));
        } catch (SQLException ex) {

        }
        return modelo;
    }

}
