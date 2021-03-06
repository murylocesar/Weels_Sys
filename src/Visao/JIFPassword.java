/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.ConectaBanco;
import Controle.Maiuscula;
import Controle.Validacoes;
import Controle.cadastro;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Murylo
 */
public class JIFPassword extends javax.swing.JInternalFrame {

    ConectaBanco conecta = new ConectaBanco();
    cadastro obj_config = new cadastro();
    Validacoes validar = new Validacoes();

    int Login, logando = 0;
    String nome = "", senha = "";
    boolean novo = true;

    /**
     * Creates new form JIFPassword
     */
    public JIFPassword() {
        initComponents();
        obj_config.carregaconfig();
        conecta.Conexao(obj_config._url);
        conecta.executaSQL("select * from tb_usuarios order by id_usuario");
        try {
            if (conecta.rs.first()) {

                nome = conecta.rs.getString("username");
                senha = conecta.rs.getString("key");
                novo = false;
            } else {
                novo = true;
                jTxt_nome.setEnabled(false);
                password.setEnabled(false);
            }

        } catch (SQLException ex) {
        }
        jTxt_nome.setDocument(new Maiuscula(20));
        password.setDocument(new Maiuscula(32));
        jTxt_novo_nome.setDocument(new Maiuscula(20));
        novo_password.setDocument(new Maiuscula(32));
        passwordCon.setDocument(new Maiuscula(32));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTxt_nome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTxt_novo_nome = new javax.swing.JTextField();
        passwordCon = new javax.swing.JPasswordField();
        novo_password = new javax.swing.JPasswordField();
        password = new javax.swing.JPasswordField();

        jTextField4.setText("jTextField4");

        setClosable(true);
        setTitle("Alteração de Senha");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/key_preferences.png"))); // NOI18N

        jLabel3.setText("Senha Atual");

        jLabel4.setText("Nova Senha");

        jLabel5.setText("Confirma Senha");

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Destranca.png"))); // NOI18N
        jToggleButton1.setText("Confirmar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancela.png"))); // NOI18N
        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome atual");

        jLabel2.setText("Novo Nome");

        passwordCon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordConKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToggleButton1)
                        .addGap(27, 27, 27)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordCon)
                            .addComponent(novo_password, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jTxt_novo_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxt_nome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(password, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTxt_nome, jTxt_novo_nome, novo_password, password, passwordCon});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxt_novo_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(novo_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(passwordCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTxt_nome, jTxt_novo_nome, novo_password, password, passwordCon});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        password();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void passwordConKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordConKeyPressed
        if ((evt.getKeyCode() == KeyEvent.VK_ENTER)) {
            password();
        }
    }//GEN-LAST:event_passwordConKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField jTxt_nome;
    private javax.swing.JTextField jTxt_novo_nome;
    private javax.swing.JPasswordField novo_password;
    private javax.swing.JPasswordField password;
    private javax.swing.JPasswordField passwordCon;
    // End of variables declaration//GEN-END:variables

    public void password() {
        if ((novo_password.getText().equals(passwordCon.getText())) && ((jTxt_nome.getText().equals(nome)) && ((Validacoes.Criptografia(password.getText()).equals(senha)) || (novo)))) {
            conecta.Conexao(obj_config._url);
            try {
                PreparedStatement pst;
                if (("".equals(jTxt_novo_nome.getText())) && ("".equals(novo_password.getText()))) {

                    pst = conecta.conn.prepareStatement("delete  from tb_usuarios where  id_usuario = ? ");

                    pst.setInt(1, 1);
                } else if (novo) {
                    pst = conecta.conn.prepareStatement("insert into tb_usuarios(id_usuario,username,key)values (?,?,?)");
                    pst.setInt(1, 1);
                    pst.setString(2, jTxt_novo_nome.getText());
                    pst.setString(3, Validacoes.Criptografia(novo_password.getText()));
                } else {
                    pst = conecta.conn.prepareStatement("update tb_usuarios set username = ?, key = ? where id_usuario = ? ");

                    pst.setString(1, jTxt_novo_nome.getText());
                    pst.setString(2, Validacoes.Criptografia(novo_password.getText()));
                    pst.setInt(3, 1);
                }
                pst.execute();
                JOptionPane.showMessageDialog(null, "Senha salva com sucesso!");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível inserir o registro!\n\n" + ex);
            }
            conecta.Desconecta();
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Senha errada!");
        }
    }
}
