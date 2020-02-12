/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.Numeric;
import Controle.cadastro;
import java.awt.HeadlessException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author Murylo César Souza
 */
public class JIFConf extends javax.swing.JInternalFrame {

    cadastro obj_config = new cadastro();

    /**
     * Creates new form JIFConf
     */
    public JIFConf() {
        initComponents();
        jTxt_outros.setDocument(new Numeric(5));
        obj_config.carregaconfig();
        try {
            if ((obj_config._LucroVeiculoEntrada == 5.0) || (obj_config._LucroVeiculoEntrada == 10.0) || (obj_config._LucroVeiculoEntrada == 15.0)
                    || (obj_config._LucroVeiculoEntrada == 20.0) || (obj_config._LucroVeiculoEntrada == 25.0) || (obj_config._LucroVeiculoEntrada == 30.0)) {
                jCbx_Lucro_veiculo.setSelectedItem(obj_config._LucroVeiculoEntrada + "%");

            } else {
                jCbx_Lucro_veiculo.setSelectedItem("Outros");
                jTxt_outros.setText(String.valueOf(obj_config._LucroVeiculoEntrada));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor configure o lucro do veiculo de entrada", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        jTxt_outros.setEnabled(!true);
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
        jCbx_Lucro_veiculo = new javax.swing.JComboBox();
        jTxt_outros = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jBtt_salvar = new javax.swing.JButton();
        jBtt_editar = new javax.swing.JButton();
        jBtt_cancelar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Configuração do sistema");

        jLabel1.setText("Lucro do veículo de entrada");

        jCbx_Lucro_veiculo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0.0%", "5.0%", "10.0%", "15.0%", "20.0%", "25.0%", "30.0%", "Outros" }));
        jCbx_Lucro_veiculo.setEnabled(false);
        jCbx_Lucro_veiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbx_Lucro_veiculoActionPerformed(evt);
            }
        });

        jTxt_outros.setEnabled(false);
        jTxt_outros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxt_outrosKeyTyped(evt);
            }
        });

        jBtt_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/save.png"))); // NOI18N
        jBtt_salvar.setText("Salvar");
        jBtt_salvar.setEnabled(false);
        jBtt_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtt_salvarActionPerformed(evt);
            }
        });

        jBtt_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/editar.png"))); // NOI18N
        jBtt_editar.setText("Editar");
        jBtt_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtt_editarActionPerformed(evt);
            }
        });

        jBtt_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancela.png"))); // NOI18N
        jBtt_cancelar.setText("Cancelar");
        jBtt_cancelar.setEnabled(false);
        jBtt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtt_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCbx_Lucro_veiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxt_outros, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtt_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtt_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtt_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtt_cancelar, jBtt_editar, jBtt_salvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCbx_Lucro_veiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxt_outros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtt_editar)
                    .addComponent(jBtt_salvar)
                    .addComponent(jBtt_cancelar))
                .addGap(25, 25, 25))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtt_editar, jBtt_salvar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtt_salvarActionPerformed
        String entrada = (String) jCbx_Lucro_veiculo.getSelectedItem();
        if (("Outros".equals(jCbx_Lucro_veiculo.getSelectedItem())) && ("".equals(jTxt_outros.getText()))) {

            JOptionPane.showMessageDialog(null, "Complete o campo de texto!", "Negação", JOptionPane.INFORMATION_MESSAGE);

        } else {
            if (("Outros".equals(jCbx_Lucro_veiculo.getSelectedItem())) && (!"".equals(jTxt_outros.getText()))) {
                obj_config.LucroVeiculoEntrada = Float.valueOf(jTxt_outros.getText());
            } else {
                obj_config.LucroVeiculoEntrada = Float.valueOf(entrada.replaceAll("%", ""));

            }
            obj_config.url = obj_config._url;
            try {
                FileOutputStream arquivo = new FileOutputStream("config.ini");
                ObjectOutputStream obj_gravacao = new ObjectOutputStream(arquivo);
                obj_gravacao.writeObject(obj_config);
                obj_gravacao.flush();
                JOptionPane.showMessageDialog(null, "Arquivo de configuração salvo com sucesso!", "configuração", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException | HeadlessException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar gerar o arquivo de configuração!\n\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            }
            jCbx_Lucro_veiculo.setEnabled(!true);
            jTxt_outros.setEnabled(!true);
            jBtt_editar.setEnabled(true);
            jBtt_salvar.setEnabled(!true);
            jBtt_cancelar.setEnabled(!true);

        }

    }//GEN-LAST:event_jBtt_salvarActionPerformed

    private void jCbx_Lucro_veiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbx_Lucro_veiculoActionPerformed
        if ("Outros".equals(jCbx_Lucro_veiculo.getSelectedItem())) {
            jTxt_outros.setEnabled(true);
        } else {
            jTxt_outros.setText("");
            jTxt_outros.setEnabled(!true);
        }
    }//GEN-LAST:event_jCbx_Lucro_veiculoActionPerformed

    private void jBtt_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtt_editarActionPerformed
        jCbx_Lucro_veiculo.setEnabled(true);
        jTxt_outros.setEnabled(true);
        jBtt_editar.setEnabled(!true);
        jBtt_salvar.setEnabled(true);
        jBtt_cancelar.setEnabled(true);
        if ("Outros".equals(jCbx_Lucro_veiculo.getSelectedItem())) {
            jTxt_outros.setEnabled(true);
        } else {
            jTxt_outros.setText("");
            jTxt_outros.setEnabled(!true);
        }
    }//GEN-LAST:event_jBtt_editarActionPerformed

    private void jBtt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtt_cancelarActionPerformed

        if ((obj_config._LucroVeiculoEntrada == 5.0) || (obj_config._LucroVeiculoEntrada == 10.0) || (obj_config._LucroVeiculoEntrada == 15.0)
                || (obj_config._LucroVeiculoEntrada == 20.0) || (obj_config._LucroVeiculoEntrada == 25.0) || (obj_config._LucroVeiculoEntrada == 30.0)) {

            jCbx_Lucro_veiculo.setSelectedItem(obj_config._LucroVeiculoEntrada + "%");
            jTxt_outros.setText("");
        } else if (Objects.equals(obj_config._LucroVeiculoEntrada, "null%")) {
            jCbx_Lucro_veiculo.setSelectedItem("0.0%");
            jTxt_outros.setText("");
        } else {
            jCbx_Lucro_veiculo.setSelectedItem("Outros");
            jTxt_outros.setText(String.valueOf(obj_config._LucroVeiculoEntrada));
        }
        jCbx_Lucro_veiculo.setEnabled(!true);
        jTxt_outros.setEnabled(!true);
        jBtt_editar.setEnabled(true);
        jBtt_salvar.setEnabled(!true);
        jBtt_cancelar.setEnabled(!true);
    }//GEN-LAST:event_jBtt_cancelarActionPerformed

    private void jTxt_outrosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxt_outrosKeyTyped

        if (evt.getKeyChar() == '.') {
            char[] Erro = jTxt_outros.getText().toCharArray();
            for (int n = 0; n < jTxt_outros.getText().length(); n++) {
                if (Erro[n] == '.') {
                    evt.consume();
                    n = jTxt_outros.getText().length();
                }
            }
        }

    }//GEN-LAST:event_jTxt_outrosKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtt_cancelar;
    private javax.swing.JButton jBtt_editar;
    private javax.swing.JButton jBtt_salvar;
    private javax.swing.JComboBox jCbx_Lucro_veiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTxt_outros;
    // End of variables declaration//GEN-END:variables
}
