/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ModeloModelos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Murylo César Souza
 */
public class ControleModelos {

    ConectaBanco control = new ConectaBanco();
    ModeloModelos modelo = new ModeloModelos();
    cadastro obj_config = new cadastro();

    public ControleModelos() {
        obj_config.carregaconfig();
    }

    public void GravareModelos(ModeloModelos mod) {
        try {
            control.Conexao(obj_config._url);
            PreparedStatement pst = control.conn.prepareStatement("insert into tb_modelos(id_modelo,veiculo,marca,descricao)values (?,?,?,?)");
            pst.setInt(1, mod.getId_modelo());
            pst.setString(2, mod.getVeiculo());
            pst.setString(3, mod.getMarca());
            pst.setString(4, mod.getDescricao());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi possível inserir o registro!\n\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            control.Desconecta();
        }
    }

    public void AlterarModelos(ModeloModelos mod) {
        control.Conexao(obj_config._url);
        try {
            PreparedStatement pst = control.conn.prepareStatement("update tb_modelos set veiculo = ? , marca = ? , descricao = ? where id_modelo = ? ");

            pst.setString(1, mod.getVeiculo());
            pst.setString(2, mod.getMarca());
            pst.setString(3, mod.getDescricao());
            pst.setInt(4, mod.getId_modelo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel alterar o registro!\n\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ExcluirModelo(int id_modelo) {

        control.Conexao(obj_config._url);
        try {
            PreparedStatement pst = control.conn.prepareStatement("delete from tb_modelos where id_modelo = ?");
            pst.setInt(1, id_modelo);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel excluir o registro!\n\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ModeloModelos Primeiro() {
        control.Conexao(obj_config._url);

        try {
            control.executaSQL("select * from tb_modelos order by id_modelo");
            control.rs.first();
            modelo.setId_modelo(control.rs.getInt("id_modelo"));
            modelo.setVeiculo(control.rs.getString("veiculo"));
            modelo.setMarca(control.rs.getString("marca"));
            modelo.setDescricao(control.rs.getString("descricao"));
        } catch (SQLException ex) {

        }

        return modelo;
    }

    public ModeloModelos Proximo() {

        control.Conexao(obj_config._url);

        try {
            control.rs.next();
            modelo.setId_modelo(control.rs.getInt("id_modelo"));
            modelo.setVeiculo(control.rs.getString("veiculo"));
            modelo.setMarca(control.rs.getString("marca"));
            modelo.setDescricao(control.rs.getString("descricao"));
        } catch (SQLException ex) {

        }

        return modelo;
    }

    public ModeloModelos Anterior() {
        control.Conexao(obj_config._url);

        try {

            control.rs.previous();
            modelo.setId_modelo(control.rs.getInt("id_modelo"));
            modelo.setVeiculo(control.rs.getString("veiculo"));
            modelo.setMarca(control.rs.getString("marca"));
            modelo.setDescricao(control.rs.getString("descricao"));
        } catch (SQLException ex) {
        }
        return modelo;
    }

    public ModeloModelos Ultimo() {
        control.Conexao(obj_config._url);

        try {
            control.executaSQL("select * from tb_modelos order by id_modelo");
            control.rs.last();
            modelo.setId_modelo(control.rs.getInt("id_modelo"));
            modelo.setVeiculo(control.rs.getString("veiculo"));;
            modelo.setMarca(control.rs.getString("marca"));
            modelo.setDescricao(control.rs.getString("descricao"));
        } catch (SQLException ex) {

        }

        return modelo;
    }

}
