/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.ConectaBanco;
import Controle.cadastro;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Murylo
 */
public class URL extends javax.swing.JDialog {

    ConectaBanco conecta = new ConectaBanco();
    cadastro obj_config = new cadastro();

    Boolean Recovery;

    /**
     * Creates new form URL
     *
     * @param recovery
     */
    /**
     * Creates new form URLbd
     *
     * @param parent
     * @param modal
     * @param recovery
     */
    public URL(java.awt.Frame parent, boolean modal, boolean recovery) {
        super(parent, modal);
        initComponents();
        Recovery = recovery;
        if (recovery) {
            obj_config.carregaconfig();
            jTxt_URL.setText(obj_config._url);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTxt_URL = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jBtt_Gravar = new javax.swing.JButton();
        jBtt_Validar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setIconImage(null);
        setMaximumSize(new java.awt.Dimension(475, 185));
        setMinimumSize(new java.awt.Dimension(475, 185));
        setModal(true);
        setModalExclusionType(null);
        setResizable(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/database_accept.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Configuração do Banco de dados");

        jTxt_URL.setEditable(false);

        jLabel3.setText("URL");

        jBtt_Gravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/GravaBD.png"))); // NOI18N
        jBtt_Gravar.setText("Gravar");
        jBtt_Gravar.setEnabled(false);
        jBtt_Gravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtt_GravarActionPerformed(evt);
            }
        });

        jBtt_Validar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Validar.png"))); // NOI18N
        jBtt_Validar.setText("Validar");
        jBtt_Validar.setEnabled(false);
        jBtt_Validar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtt_ValidarActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/exit.png"))); // NOI18N
        jButton4.setText("Fechar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtt_Gravar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtt_Validar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTxt_URL, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxt_URL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtt_Gravar)
                    .addComponent(jBtt_Validar)
                    .addComponent(jButton4))
                .addGap(21, 21, 21))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtt_GravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtt_GravarActionPerformed

        obj_config.url = jTxt_URL.getText();
        obj_config.LucroVeiculoEntrada = obj_config._LucroVeiculoEntrada;
        if (obj_config.LucroVeiculoEntrada < 0) {
            obj_config.LucroVeiculoEntrada = 0;
        }
        try {
            FileOutputStream arquivo = new FileOutputStream("Config.ini");
            ObjectOutputStream obj_gravacao = new ObjectOutputStream(arquivo);
            obj_gravacao.writeObject(obj_config);
            obj_gravacao.flush();
            JOptionPane.showMessageDialog(null, "Arquivo de configuração gerado com sucesso!", "configuração", JOptionPane.INFORMATION_MESSAGE);
            jBtt_Gravar.setEnabled(false);
            jBtt_Validar.setEnabled(false);
            Recovery = true;

        } catch (IOException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar o arquivo de configuração!\n\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtt_GravarActionPerformed

    private void jBtt_ValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtt_ValidarActionPerformed
        if (conecta.Conexao(jTxt_URL.getText())) {
            JOptionPane.showMessageDialog(null, "Conectou com sucesso!");
            jBtt_Gravar.setEnabled(true);
            jBtt_Validar.setEnabled(false);
        }
    }//GEN-LAST:event_jBtt_ValidarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        if (Recovery) {
            dispose();
        } else {
            System.exit(0);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            javax.swing.JFileChooser URL_BD = new javax.swing.JFileChooser();
            URL_BD.setMultiSelectionEnabled(false);
            if (Recovery) {
                URL_BD.setCurrentDirectory(new File("Backup\\"));//caminho que vai abrir quando puxar a tela
            } else {
                URL_BD.setCurrentDirectory(new File("BaseDados\\"));//caminho que vai abrir quando puxar a tela
            }
            URL_BD.setDialogTitle("Selecione a base de dados");
            URL_BD.setFileFilter(new FileNameExtensionFilter("Firebird", "fdb"));//nao entendi pq tem que repetir as extencoes
            URL_BD.setFileSelectionMode(JFileChooser.FILES_ONLY);

            if (URL_BD.showOpenDialog(this) == 0) {// se clica em abrir imagem faz isso...
                String formato = "????";
                char[] format = formato.toCharArray(), foto = URL_BD.getSelectedFile().getName().toCharArray();
                format[0] = foto[URL_BD.getSelectedFile().getName().length() - 4];
                format[1] = foto[URL_BD.getSelectedFile().getName().length() - 3];
                format[2] = foto[URL_BD.getSelectedFile().getName().length() - 2];
                format[3] = foto[URL_BD.getSelectedFile().getName().length() - 1];
                char[] upper = String.valueOf(format).toCharArray();
                for (int i = 0; i < upper.length; i++) {
                    upper[i] = Character.toUpperCase(upper[i]);
                }
                formato = String.valueOf(upper);
                if ((".FDB".equals(formato))) {
                    jTxt_URL.setText("" + URL_BD.getSelectedFile());
                    jBtt_Validar.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor selecione as imagens com o formato:\n\n.FDB");
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir seletor de arquivo\n\n!" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(URL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(URL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(URL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(URL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            URL dialog = new URL(new javax.swing.JFrame(), true, true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtt_Gravar;
    private javax.swing.JButton jBtt_Validar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTxt_URL;
    // End of variables declaration//GEN-END:variables
}
