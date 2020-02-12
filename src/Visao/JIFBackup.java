/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.Backup;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Murylo César Souza
 */
public class JIFBackup extends javax.swing.JInternalFrame {

    Backup obj_Backup = new Backup();

    /**
     * Creates new form Backup
     */
    public JIFBackup() {
        initComponents();
        if (obj_Backup.carregaconfig(true)) {
            jTxt_URL_FDB.setText(obj_Backup._URL_banco);
            jTxt_URL_Destino.setText(obj_Backup._URL_destino);
            jCbx_NºExecucao.setSelectedItem("" + obj_Backup._Nº_Execucao_total);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTxt_URL_FDB = new javax.swing.JTextField();
        jTxt_URL_Destino = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        backup_agora = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jCbx_NºExecucao = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        backup_manual = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        salvar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        Recomendado = new javax.swing.JButton();

        jTextField3.setText("jTextField3");

        jButton7.setText("jButton7");

        setClosable(true);
        setTitle("Cópia da Base de Dados");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/server_go.png"))); // NOI18N

        jLabel2.setText("Arquivo .FDB");

        jLabel3.setText("Pasta destino");

        jTxt_URL_FDB.setEditable(false);
        jTxt_URL_FDB.setBackground(new java.awt.Color(204, 255, 204));

        jTxt_URL_Destino.setEditable(false);
        jTxt_URL_Destino.setBackground(new java.awt.Color(204, 255, 204));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Consulta_arquivo.png"))); // NOI18N
        jButton1.setText("Arquivo");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Consulta_arquivo.png"))); // NOI18N
        jButton2.setText("Pasta");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        backup_agora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Backup.png"))); // NOI18N
        backup_agora.setText("Backup");
        backup_agora.setEnabled(false);
        backup_agora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backup_agoraActionPerformed(evt);
            }
        });

        jLabel1.setText(" A cada quantas execuções deseja fazer backup");

        jCbx_NºExecucao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "5", "10", "15", "30" }));
        jCbx_NºExecucao.setEnabled(false);

        backup_manual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Backup_munual.png"))); // NOI18N
        backup_manual.setText("Manual");
        backup_manual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backup_manualActionPerformed(evt);
            }
        });

        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/color_line.png"))); // NOI18N
        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/save.png"))); // NOI18N
        salvar.setText("Salvar");
        salvar.setEnabled(false);
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancela.png"))); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.setEnabled(false);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        Recomendado.setText("Recomendado");
        Recomendado.setEnabled(false);
        Recomendado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecomendadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(jCbx_NºExecucao, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Recomendado, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(salvar)
                            .addGap(18, 18, 18)
                            .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(backup_manual)
                            .addGap(18, 18, 18)
                            .addComponent(backup_agora)
                            .addGap(18, 18, 18)
                            .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTxt_URL_FDB, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                            .addComponent(jTxt_URL_Destino))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {backup_agora, backup_manual, cancelar, editar, salvar});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Recomendado, jButton1, jButton2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxt_URL_FDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxt_URL_Destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(21, 21, 21)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCbx_NºExecucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Recomendado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editar)
                    .addComponent(salvar)
                    .addComponent(backup_manual)
                    .addComponent(backup_agora)
                    .addComponent(cancelar))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Recomendado, jButton1, jButton2});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {backup_agora, backup_manual, cancelar, editar, salvar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backup_agoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backup_agoraActionPerformed

        try {
            java.util.Date datahoje = new java.util.Date();
            SimpleDateFormat df = new SimpleDateFormat("dd.MM.yy");//Data

            Calendar now = Calendar.getInstance();//Hora

            FileOutputStream destino;
            FileInputStream origem = new FileInputStream(jTxt_URL_FDB.getText());//arquivo que você quer copiar
            destino = new FileOutputStream(jTxt_URL_Destino.getText() + String.format("\\Hora_%1$tH.%1tM.%1$tS Data_", now) + df.format(datahoje) + ".FDB"); //onde irá ficar a copia do aquivo

            FileChannel fcOrigem = origem.getChannel();
            FileChannel fcDestino = destino.getChannel();
            fcOrigem.transferTo(0, fcOrigem.size(), fcDestino);//copiando o arquivo e salvando no diretório que você escolheu  
            destino.close();
            JOptionPane.showMessageDialog(null, "Backup realizado com susseso");
        } catch (IOException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer backup\n\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        salvar.setEnabled(!true);
        editar.setEnabled(true);
        backup_manual.setEnabled(true);
        backup_agora.setEnabled(!true);
        jButton1.setEnabled(!true);
        jButton2.setEnabled(!true);
        cancelar.setEnabled(!true);
    }//GEN-LAST:event_backup_agoraActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            JFileChooser caminhoBD = new JFileChooser();
            caminhoBD.setCurrentDirectory(new File("BaseDados\\"));//caminho que vai abrir quando chama a tela
            caminhoBD.setDialogTitle("Backup da base de dados");//TITULO
            caminhoBD.showOpenDialog(caminhoBD);

            String formato = "????";
            char[] alt = caminhoBD.getSelectedFile().getName().toCharArray();
            char[] alt1 = formato.toCharArray();
            alt1[0] = alt[caminhoBD.getSelectedFile().getName().length() - 4];
            alt1[1] = alt[caminhoBD.getSelectedFile().getName().length() - 3];
            alt1[2] = alt[caminhoBD.getSelectedFile().getName().length() - 2];
            alt1[3] = alt[caminhoBD.getSelectedFile().getName().length() - 1];
            formato = String.valueOf(alt1);

            char[] upper = formato.toCharArray();
            for (int i = 0; i < upper.length; i++) {
                upper[i] = Character.toUpperCase(upper[i]);
            }

            if (!".FDB".equals(formato = String.valueOf(upper))) {
                JOptionPane.showMessageDialog(null, "Erro no formato do banco de dados");

            } else {
                jTxt_URL_FDB.setText("" + caminhoBD.getSelectedFile());
            }

        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir o seletor de arquivo\n\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void backup_manualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backup_manualActionPerformed
        Recomendado.setEnabled(!true);
        salvar.setEnabled(!true);
        editar.setEnabled(!true);
        backup_manual.setEnabled(!true);
        backup_agora.setEnabled(true);
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
//        jCbx_NºExecucao.setEnabled(true);
        cancelar.setEnabled(true);
    }//GEN-LAST:event_backup_manualActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            JFileChooser caminhoBD = new JFileChooser();
            caminhoBD.setCurrentDirectory(new File("BaseDados\\"));//caminho que vai abrir quando chama a tela
            caminhoBD.setDialogTitle("Pasta do destino do backup");//TITULO
            caminhoBD.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//selecionar apenas pasta
            caminhoBD.showOpenDialog(caminhoBD);

            jTxt_URL_Destino.setText("" + caminhoBD.getSelectedFile());

        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir o seletor de arquivo\n\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro\n\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed

        obj_Backup.URL_banco = jTxt_URL_FDB.getText();
        obj_Backup.URL_destino = jTxt_URL_Destino.getText();
        String numero = (String) jCbx_NºExecucao.getSelectedItem();
        obj_Backup.Nº_Execucao_total = Integer.parseInt(numero);
        obj_Backup.Nº_execucao = Integer.parseInt(numero);

        try {
            FileOutputStream arquivo = new FileOutputStream("Backup.ini");
            ObjectOutputStream obj_gravacao = new ObjectOutputStream(arquivo);
            obj_gravacao.writeObject(obj_Backup);
            obj_gravacao.flush();
            JOptionPane.showMessageDialog(null, "Arquivo de configuracão gerado com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar o arquivo de Confirmação!\n\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        Recomendado.setEnabled(!true);
        salvar.setEnabled(!true);
        editar.setEnabled(true);
        backup_manual.setEnabled(true);
        backup_agora.setEnabled(!true);
        jButton1.setEnabled(!true);
        jButton2.setEnabled(!true);
        jCbx_NºExecucao.setEnabled(!true);
        cancelar.setEnabled(!true);
        obj_Backup.carregaconfig(true);
        jTxt_URL_FDB.setText(obj_Backup._URL_banco);
        jTxt_URL_Destino.setText(obj_Backup._URL_destino);
        jCbx_NºExecucao.setSelectedItem("" + obj_Backup._Nº_Execucao_total);
    }//GEN-LAST:event_salvarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        Recomendado.setEnabled(!true);
        salvar.setEnabled(!true);
        editar.setEnabled(true);
        backup_manual.setEnabled(true);
        backup_agora.setEnabled(!true);
        jButton1.setEnabled(!true);
        jButton2.setEnabled(!true);
        jCbx_NºExecucao.setEnabled(!true);
        cancelar.setEnabled(!true);
        jTxt_URL_FDB.setText(obj_Backup._URL_banco);
        jTxt_URL_Destino.setText(obj_Backup._URL_destino);
        jCbx_NºExecucao.setSelectedItem("" + obj_Backup._Nº_Execucao_total);
    }//GEN-LAST:event_cancelarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        Recomendado.setEnabled(true);
        salvar.setEnabled(true);
        editar.setEnabled(!true);
        backup_manual.setEnabled(!true);
        backup_agora.setEnabled(!true);
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        jCbx_NºExecucao.setEnabled(true);
        cancelar.setEnabled(true);
    }//GEN-LAST:event_editarActionPerformed

    private void RecomendadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecomendadoActionPerformed
        jCbx_NºExecucao.setSelectedItem("1");
    }//GEN-LAST:event_RecomendadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Recomendado;
    private javax.swing.JButton backup_agora;
    private javax.swing.JButton backup_manual;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton editar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox jCbx_NºExecucao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTxt_URL_Destino;
    private javax.swing.JTextField jTxt_URL_FDB;
    private javax.swing.JButton salvar;
    // End of variables declaration//GEN-END:variables
}