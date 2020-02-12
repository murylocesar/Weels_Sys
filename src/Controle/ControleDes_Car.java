/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ModeloDes_Car;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Murylo César Souza
 */
public class ControleDes_Car {

    ConectaBanco conecta = new ConectaBanco();
    ConectaBanco ConVei = new ConectaBanco();

    ModeloDes_Car modelo = new ModeloDes_Car();

    cadastro obj_config = new cadastro();

    public ControleDes_Car() {
        obj_config.carregaconfig();
    }

    public void GravarDesp_car(ModeloDes_Car mod) {

        if (buscaValorVeiculo(mod.getId_veiculo(), mod.getValor(), true)) {
            try {
                conecta.Conexao(obj_config._url);

                PreparedStatement pst = conecta.conn.prepareStatement("insert into tb_car_desp(id_car,id_veiculo,data ,descricao,valor)values (?,?,?,?,?)");
                pst.setInt(1, mod.getId_codigo());
                pst.setInt(2, mod.getId_veiculo());
                pst.setDate(3, mod.getData());
                pst.setString(4, mod.getDescricao());
                pst.setDouble(5, mod.getValor());
                pst.execute();
                JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, "Não foi possível inserir o registro!" + ex);
            }
        }
        conecta.Desconecta();
    }

    public void AlterarDesp_car(ModeloDes_Car mod) {

        if (buscaValorVeiculo(mod.getId_veiculo(), mod.getValor(), true)) {
            conecta.Conexao(obj_config._url);
            JOptionPane.showMessageDialog(null, mod.getValor());
            try {
                PreparedStatement pst = conecta.conn.prepareStatement("update tb_car_desp set descricao = ? ,valor = ?  where id_car = ? ");

                pst.setString(1, mod.getDescricao());
                pst.setDouble(2, mod.getValor());
                pst.setInt(3, mod.getId_codigo());
                pst.execute();
                JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possivel alterar o registro!" + ex);
            }
            conecta.Desconecta();
        }

    }

    public void ExcluirDesp_car(ModeloDes_Car mod) {

        if (buscaValorVeiculo(mod.getId_veiculo(), mod.getValor(), false)) {
            conecta.Conexao(obj_config._url);
            try {
                PreparedStatement pst = conecta.conn.prepareStatement("delete from tb_car_desp where id_car = ?");
                pst.setInt(1, mod.getId_codigo());
                pst.execute();
                JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possivel excluir o registro!");
            }
            conecta.Desconecta();
        }
    }

    public boolean buscaValorVeiculo(int id_veiculo, Double valor, boolean alterar) {

        conecta.Conexao(obj_config._url);
        conecta.executaSQL("select * from tb_veiculos where id_veiculo = " + id_veiculo + "order by id_veiculo");
        try {

            conecta.rs.first();

            ConVei.Conexao(obj_config._url);
            PreparedStatement pst = ConVei.conn.prepareStatement("update tb_veiculos set valor_pago = ? , valor_venda = ? where id_veiculo = ? ");

            pst.setDouble(1, conecta.rs.getDouble("valor_pago") + valor);
            pst.setDouble(2, conecta.rs.getDouble("valor_venda") + valor);
            pst.setInt(3, id_veiculo);
            pst.execute();
            ConVei.Desconecta();
            conecta.Desconecta();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível adicionar a despesa no veiculo!" + ex);
            ConVei.Desconecta();
            conecta.Desconecta();
            return false;
        }

    }

}
