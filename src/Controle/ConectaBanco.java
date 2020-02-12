package Controle;

import Visao.Tela;
import Visao.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConectaBanco {

    public Statement stm;// responsável por preparar e realizar pesquiza no banco da dado
    public ResultSet rs; //responsável por armazenar o resultado e uma pesquiza passada o Statement
    public Connection conn; // responsável por reslizar a conexão do bando de dado
    private final String driver = "org.firebirdsql.jdbc.FBDriver";
    private final String user = "SYSDBA";
    private final String pswd = "masterkey";

    public boolean Conexao(String URL) {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection("jdbc:firebirdsql:127.0.0.1/3050:" + URL, user, pswd);
            return true;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema falta o Driver!\n\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema ao tentar conectar!\n\nPor favor configure a URL do base de dados\n\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
//            URL janela = new URL(false);
//            Tela.jDesktop.add(janela);
//            Tela.centralizaForm(janela);
//            janela.setVisible(true);
        }
        return false;
    }

    public void Desconecta() {
        try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistem ao tentar desconectar" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void executaSQL(String sql) {
        try {
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar comando SQL!\n\n" + sqlex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
