/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Visao.JIFDados_Empresa;
import Visao.Tela;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author Murylo
 */
public class Dados_empresa implements Serializable {

    public String nome, uf, cidade, bairro, endereco, fone, fone2, e_mail;// recebe os dados
    public String _nome, _uf, _cidade, _bairro, _endereco, _fone, _fone2, _e_mail;//traz os dados

    public boolean carregaconfig(boolean x) {
        try {
            FileInputStream arquivo = new FileInputStream("Dados_Empresa.ini");
            ObjectInputStream obj_leitura = new ObjectInputStream(arquivo);
            Dados_empresa obj_config = (Dados_empresa) obj_leitura.readObject();
            this._nome = obj_config.nome;// recebe os dados
            this._uf = obj_config.uf;
            this._cidade = obj_config.cidade;
            this._bairro = obj_config.bairro;
            this._endereco = obj_config.endereco;
            this._fone = obj_config.fone;
            this._fone2 = obj_config.fone2;
            this._e_mail = obj_config.e_mail;
            return true;
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar as configuracão do Banco de Dados!\n\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            if (!x) {
                JIFDados_Empresa janela = new JIFDados_Empresa();
                Tela.jDesktop.add(janela);
                Tela.centralizaForm(janela);
                janela.setVisible(true);
            }
        }
        return false;
    }
}
