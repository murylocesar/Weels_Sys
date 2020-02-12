/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ModeloTaxa;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Murylo César Souza
 */
public class ControleTaxas {

    ConectaBanco control = new ConectaBanco();
cadastro obj_config = new cadastro();

    public ControleTaxas() {
        obj_config.carregaconfig();
    }
    public void GravarTaxa(ModeloTaxa mod) {

        try {
            control.Conexao(obj_config._url);
            PreparedStatement pst = control.conn.prepareStatement("insert into tb_taxas (id_taxa , tipo , datacad , descricao , parcela , entrada, valor , coeficiente , ano_modelo) values (?,?,?,?,?,?,?,?,?)");

            pst.setInt(1, mod.getId_taxa());
            pst.setString(2, mod.getTipo());
            pst.setDate(3, mod.getDatacad());
            pst.setString(4, mod.getDescricao());
            pst.setInt(5, mod.getParcela());
            pst.setInt(6, mod.getEntrada());
            pst.setDouble(7, mod.getValor());
            pst.setFloat(8, mod.getCoeficiente());
            pst.setString(9, mod.getAno_modelo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível inserir o registro!" + ex);
            control.Desconecta();
        }
    }

    public void AlterarTaxa(ModeloTaxa mod) {
        control.Conexao(obj_config._url);
        try {

            PreparedStatement pst = control.conn.prepareStatement("update tb_taxas set  tipo = ? , datacad = ? , descricao = ? , parcela = ? ,entrada = ? , valor = ? , ano_modelo = ? , coeficiente = ?  where id_taxa = ?");

            pst.setString(1, mod.getTipo());
            pst.setDate(2, mod.getDatacad());
            pst.setString(3, mod.getDescricao());
            pst.setInt(4, mod.getParcela());
            pst.setInt(5, mod.getEntrada());
            pst.setDouble(6, mod.getValor());
            pst.setString(7, mod.getAno_modelo());
            pst.setFloat(8, mod.getCoeficiente());
            pst.setInt(9, mod.getId_taxa());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível alterado o registro!");
        }

    }

    public void ExcluirTaxa(ModeloTaxa mod) {

        control.Conexao(obj_config._url);
        try {
            PreparedStatement pst = control.conn.prepareStatement("delete from tb_taxas where id_taxa = ? ");
            pst.setInt(1, mod.getId_taxa());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel excluir o registro!");
        }
    }

}
