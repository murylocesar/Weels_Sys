package Controle;

import Visao.JIFBackup;
import Visao.Tela;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author Murylo César Souza
 */
public class Backup implements Serializable {

    public int Nº_Execucao_total;
    public int Nº_execucao;
    public int _Nº_Execucao_total;
    public int _Nº_execucao;
    public String URL_banco, URL_destino, _URL_banco, _URL_destino;

    public boolean carregaconfig(boolean detector) {
        try {
            FileInputStream arquivo = new FileInputStream("Backup.ini");
            ObjectInputStream obj_leitura = new ObjectInputStream(arquivo);
            Backup obj_Backup = (Backup) obj_leitura.readObject();
            this._Nº_Execucao_total = obj_Backup.Nº_Execucao_total;
            this._Nº_execucao = obj_Backup.Nº_execucao;
            this._URL_banco = obj_Backup.URL_banco;
            this._URL_destino = obj_Backup.URL_destino;
            return true;
        } catch (IOException | ClassNotFoundException erro) {
            if (!detector) {
                JOptionPane.showMessageDialog(null, "Erro ao carregar as configura��es do Banco de Dados!", "Erro", JOptionPane.ERROR_MESSAGE);
                JIFBackup janela = new JIFBackup();
                Tela.jDesktop.add(janela);
                Tela.centralizaForm(janela);
                janela.setVisible(true);

            }
        }
        return false;

    }

}
