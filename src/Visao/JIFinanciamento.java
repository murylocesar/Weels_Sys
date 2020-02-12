/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.ConectaBanco;
import Controle.Numeric;
import Controle.cadastro;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.NumberFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Murylo César Souza
 */
public class JIFinanciamento extends javax.swing.JInternalFrame {

    ConectaBanco conecta = new ConectaBanco();
    cadastro obj_config = new cadastro();

    /**
     * Creates new form JIFinanciamento
     */
    public JIFinanciamento() {
        initComponents();
        obj_config.carregaconfig();
        jTxt_modelo.setDocument(new Numeric(2));
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
        jTxt_valortotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jCbx_parcela = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jTxt_modelo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTxt_mensal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTxt_financiado = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jCbx_entrada = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jTxt_total = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Validar Financiamento");

        jLabel1.setText("Valor Total");

        jLabel3.setText("Qdt.Parcela");

        jCbx_parcela.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "12", "24", "36", "48", "60" }));

        jLabel4.setText("Ano do modelo");

        jButton1.setText("Validar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Valor mensal");

        jTxt_mensal.setEnabled(false);

        jLabel6.setText("Valor financiado");

        jTxt_financiado.setEnabled(false);

        jLabel7.setText("Entrada");

        jCbx_entrada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0%", "10%", "20%", "30%", "40%", "50%" }));

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setText("Valor total");

        jTxt_total.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jTxt_financiado))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(34, 34, 34)
                                .addComponent(jTxt_mensal))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTxt_valortotal, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCbx_parcela, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCbx_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxt_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(45, 45, 45)
                        .addComponent(jTxt_total)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxt_valortotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTxt_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCbx_parcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jCbx_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTxt_mensal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTxt_financiado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTxt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel3});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTxt_financiado, jTxt_mensal});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTxt_valortotal.setText("");
        jTxt_modelo.setText("");
        jCbx_parcela.setSelectedIndex(0);
        jCbx_entrada.setSelectedIndex(0);
        jTxt_mensal.setText("");
        jTxt_financiado.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        conecta.Conexao(obj_config._url);

        String entrada = (String) jCbx_entrada.getSelectedItem();
        entrada = entrada.replaceAll("%", "");

        double Valor = (0.01 * (double) Integer.parseInt(entrada)) * (Double.valueOf(jTxt_valortotal.getText()));
        try {
            conecta.executaSQL("select valor from tb_taxas where tipo = 'O'");
            conecta.rs.first();

            do {
                Valor += conecta.rs.getInt("valor");
            } while (conecta.rs.next());
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Não existe cadastro com esse valor", "Atenção", JOptionPane.QUESTION_MESSAGE);
        }

        try {
            conecta.executaSQL("select coeficiente from tb_taxas where tipo = 'A' and parcela='" + Integer.parseInt((String) jCbx_parcela.getSelectedItem()) + "' and entrada = '" + Integer.parseInt(entrada) + "' and ano_modelo like '%" + jTxt_modelo.getText() + "%'");
            conecta.rs.first();

            /// transforma em valor 'R$...'
            NumberFormat nf = NumberFormat.getCurrencyInstance();

            jTxt_mensal.setText(nf.format(new BigDecimal(String.valueOf(Valor * conecta.rs.getFloat("COEFICIENTE")))));

            jTxt_financiado.setText(nf.format(new BigDecimal(String.valueOf(Valor * conecta.rs.getFloat("COEFICIENTE") * Integer.parseInt((String) jCbx_parcela.getSelectedItem())))));

            jTxt_total.setText(nf.format(new BigDecimal(String.valueOf(Valor * conecta.rs.getFloat("COEFICIENTE") * Integer.parseInt((String) jCbx_parcela.getSelectedItem()) + (((0.01 * (double) Integer.parseInt(entrada)) * (Double.valueOf(jTxt_valortotal.getText()))) - Double.valueOf(jTxt_valortotal.getText())) * -1))));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe cadastro com esse valores ", "Atenção", JOptionPane.QUESTION_MESSAGE);
            jTxt_mensal.setText("");
            jTxt_financiado.setText("");
            jTxt_total.setText("");
        }
        conecta.Desconecta();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jCbx_entrada;
    private javax.swing.JComboBox jCbx_parcela;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTxt_financiado;
    private javax.swing.JTextField jTxt_mensal;
    private javax.swing.JTextField jTxt_modelo;
    private javax.swing.JTextField jTxt_total;
    private javax.swing.JTextField jTxt_valortotal;
    // End of variables declaration//GEN-END:variables
}