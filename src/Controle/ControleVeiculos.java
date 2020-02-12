/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ModeloVeiculos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Murylo César Souza
 */
public class ControleVeiculos {

    ConectaBanco conVei = new ConectaBanco();
    ConectaBanco conModelo = new ConectaBanco();
    ModeloVeiculos model = new ModeloVeiculos();

    cadastro obj_config = new cadastro();

    public ControleVeiculos() {
        obj_config.carregaconfig();
    }

    public boolean GravarVeiculos(ModeloVeiculos mod) {
        try {
            conVei.Conexao(obj_config._url);
            PreparedStatement pst = conVei.conn.prepareStatement("insert into tb_veiculos(id_veiculo , datacad , compra_troca , veiculo , condicao , quilomentragem , datafab ,anomodelo , porte , marca ,modelo ,versao, chassi ,placa , cor ,  porta , flex ,direcao_hidraulica ,ar_condicionado , obs ,valor_pago ,valor_venda ,status ,foto)values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, mod.getId_veiculo());
            pst.setDate(2, mod.getDataCad());
            pst.setString(3, mod.getCompra_venda());
            pst.setString(4, mod.getVeiculo());
            pst.setString(5, mod.getCondicao());
            pst.setInt(6, mod.getQuilomentragem());
            pst.setDate(7, mod.getDataFab());
            pst.setString(8, mod.getAnoModelo());
            pst.setString(9, mod.getPorte());
            pst.setString(10, mod.getMarca());
            pst.setInt(11, buscaCodigoModelo(mod.getModelo()));// buscar código da modelo
            pst.setString(12, mod.getVersao());
            pst.setString(13, mod.getChassi());
            pst.setString(14, mod.getPlaca());
            pst.setString(15, mod.getCor());
            pst.setInt(16, mod.getPorta());
            pst.setString(17, mod.getFlex());
            pst.setString(18, mod.getDirecao_hidraulica());
            pst.setString(19, mod.getAr_condicionado());
            pst.setString(20, mod.getObs());
            pst.setDouble(21, mod.getValor_pago());
            pst.setDouble(22, mod.getValor_venda());
            pst.setString(23, mod.getSituacao());
            pst.setString(24, mod.getFoto());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");
            conVei.Desconecta();
            conModelo.Desconecta();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível inserir o registro!" + ex);
        }
        conVei.Desconecta();
        conModelo.Desconecta();
        return false;
    }

    public boolean AlterarVeiculos(ModeloVeiculos mod) {

        conVei.Conexao(obj_config._url);
        try {
            PreparedStatement pst = conVei.conn.prepareStatement("update tb_veiculos set datacad = ? , compra_troca = ? , veiculo = ? , condicao = ? , quilomentragem = ? , datafab = ? , anomodelo = ? , porte = ? , marca = ? , modelo = ? , versao = ? , chassi = ? , placa = ? , cor = ? ,  porta = ? , flex = ? , direcao_hidraulica = ? , ar_condicionado = ? , obs = ? , valor_pago = ? , valor_venda = ? , status = ? ,foto = ?  where id_veiculo = ? ");
            pst.setDate(1, mod.getDataCad());
            pst.setString(2, mod.getCompra_venda());
            pst.setString(3, mod.getVeiculo());
            pst.setString(4, mod.getCondicao());
            pst.setInt(5, mod.getQuilomentragem());
            pst.setDate(6, mod.getDataFab());
            pst.setString(7, mod.getAnoModelo());
            pst.setString(8, mod.getPorte());
            pst.setString(9, mod.getMarca());
            pst.setInt(10, buscaCodigoModelo(mod.getModelo()));// buscar código da modelo
            pst.setString(11, mod.getVersao());
            pst.setString(12, mod.getChassi());
            pst.setString(13, mod.getPlaca());
            pst.setString(14, mod.getCor());
            pst.setInt(15, mod.getPorta());
            pst.setString(16, mod.getFlex());
            pst.setString(17, mod.getDirecao_hidraulica());
            pst.setString(18, mod.getAr_condicionado());
            pst.setString(19, mod.getObs());
            pst.setDouble(20, mod.getValor_pago());
            pst.setDouble(21, mod.getValor_venda());
            pst.setString(22, mod.getSituacao());
            pst.setString(23, mod.getFoto());
            pst.setInt(24, mod.getId_veiculo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!");
            conVei.Desconecta();
            conModelo.Desconecta();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel alterar o registro!" + ex);
        }
        conVei.Desconecta();
        conModelo.Desconecta();
        return false;
    }

    public Boolean ExcluirVeiculos(int id_veiculo) {
        conVei.Conexao(obj_config._url);
        try {
            PreparedStatement pst = conVei.conn.prepareStatement("delete from tb_veiculos where id_veiculo = ?");
            pst.setInt(1, id_veiculo);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel excluir o registro!");
            return false;
        }
    }

    public int buscaCodigoModelo(String nome) {
        conModelo.Conexao(obj_config._url);
        conModelo.executaSQL("select * from tb_modelos where descricao = '" + nome + "'");
        try {
            conModelo.rs.first();
            return conModelo.rs.getInt("id_modelo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar a modelo cadastro com este código!" + nome);
        }
        return -1;
    }
}
