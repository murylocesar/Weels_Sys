 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Visao.Tela;
import Visao.URL;
import Visao.URL;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author Murylo César Souza
 */
public class cadastro implements Serializable {

    public String url;
    public String _url;
    public float LucroVeiculoEntrada;
    public float _LucroVeiculoEntrada;

    public boolean carregaconfig() {

        try {
            FileInputStream arquivo = new FileInputStream("Config.ini");
            ObjectInputStream obj_leitura = new ObjectInputStream(arquivo);
            cadastro obj_config = (cadastro) obj_leitura.readObject();
            this._url = obj_config.url;
            this._LucroVeiculoEntrada = obj_config.LucroVeiculoEntrada;
            if (!new ConectaBanco().Conexao(_url)) {
                JOptionPane.showMessageDialog(null, "Não foi possível estabelecer uma conexão com o servidor.\n\n"
                        + "Verifique se o banco de dados NÂO estar danificado.", "Atenção", JOptionPane.WARNING_MESSAGE);
                new URL(null, true, false).setVisible(true);
                carregaconfig();
            }
            return true;
        } catch (IOException | ClassNotFoundException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível estabelecer uma conexão com o servidor.\n\n"
                    + "Verifique se existe o arquivo de parâmetros definidos para o banco de dados.\n\n"
                    + "Antes de prosseguir, verifique-se que nenhum sistema esteja aberto.\n\n" + erro, "Atenção", JOptionPane.WARNING_MESSAGE);

            new URL(null, true, false).setVisible(true);
            carregaconfig();
        }
        return false;
    }
}
