/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.ConectaBanco;
import Controle.ControleModelos;
import Controle.Maiuscula;
import Controle.ModeloTabela;
import Controle.Validacoes;
import Controle.cadastro;
import Modelo.ModeloModelos;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Murylo César Souza
 */
public class JIFModelos extends javax.swing.JInternalFrame {

    ConectaBanco conecta = new ConectaBanco();
    ControleModelos conmod = new ControleModelos();
    ModeloModelos model = new ModeloModelos();
    Validacoes validar = new Validacoes();
    cadastro obj_config = new cadastro();

    int flag = 0, Modelo;

    /**
     * Creates new form JIFModelos
     */
    public JIFModelos() {

        initComponents();
        obj_config.carregaconfig();
        jTxt_modelo.setDocument(new Maiuscula(25));
        jTxt_pesquisa.setDocument(new Maiuscula(25));
        conecta.Conexao(obj_config._url);
        preencherTabela("select * from tb_modelos order by id_modelo");
        jCbx_marca.setModel(new javax.swing.DefaultComboBoxModel(validar.preencherCampo((String) jCbx_veiculo.getSelectedItem())));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTxt_modelo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbl_modelos = new javax.swing.JTable();
        jBtt_novo = new javax.swing.JButton();
        jBtt_salvar = new javax.swing.JButton();
        jBtt_editar = new javax.swing.JButton();
        jBtt_excluir = new javax.swing.JButton();
        jBtt_cancelar = new javax.swing.JButton();
        jBtt_ultimo = new javax.swing.JButton();
        jBtt_proximo = new javax.swing.JButton();
        jBtt_anterior = new javax.swing.JButton();
        jBtt_primeiro = new javax.swing.JButton();
        jTxt_pesquisa = new javax.swing.JTextField();
        jBtt_pesquisar = new javax.swing.JButton();
        jCbx_veiculo = new javax.swing.JComboBox();
        jLabel111 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jCbx_marca = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel113 = new javax.swing.JLabel();
        jCbx_veiculo2 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jTxt_codigo = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Cadastro de modelos");

        jLabel2.setText("Modelo");

        jTxt_modelo.setEnabled(false);

        jTbl_modelos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTbl_modelos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTbl_modelosMouseClicked(evt);
            }
        });
        jTbl_modelos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTbl_modelosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTbl_modelos);

        jBtt_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/new.png"))); // NOI18N
        jBtt_novo.setText("Novo");
        jBtt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtt_novoActionPerformed(evt);
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
        jBtt_editar.setEnabled(false);
        jBtt_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtt_editarActionPerformed(evt);
            }
        });

        jBtt_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/del.png"))); // NOI18N
        jBtt_excluir.setText("Excluir");
        jBtt_excluir.setEnabled(false);
        jBtt_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtt_excluirActionPerformed(evt);
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

        jBtt_ultimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/last.png"))); // NOI18N
        jBtt_ultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtt_ultimoActionPerformed(evt);
            }
        });

        jBtt_proximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/next.png"))); // NOI18N
        jBtt_proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtt_proximoActionPerformed(evt);
            }
        });

        jBtt_anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/leftarrow.png"))); // NOI18N
        jBtt_anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtt_anteriorActionPerformed(evt);
            }
        });

        jBtt_primeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/first.png"))); // NOI18N
        jBtt_primeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtt_primeiroActionPerformed(evt);
            }
        });

        jTxt_pesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTxt_pesquisaKeyReleased(evt);
            }
        });

        jBtt_pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Search.png"))); // NOI18N
        jBtt_pesquisar.setText("Pesquisar");
        jBtt_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtt_pesquisarActionPerformed(evt);
            }
        });

        jCbx_veiculo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Moto", "Automovel", "Micro/Ônibus", "Caminhão" }));
        jCbx_veiculo.setEnabled(false);
        jCbx_veiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbx_veiculoActionPerformed(evt);
            }
        });

        jLabel111.setText("Veiculo");

        jLabel120.setText("Marca");

        jCbx_marca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SUZUKI", "KAWASAKI", "DAINESE", "HONDA" }));
        jCbx_marca.setEnabled(false);

        jLabel113.setText("Veiculo");

        jCbx_veiculo2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Moto", "Automovel", "Micro/Ônibus", "Caminhão" }));

        jLabel3.setText("Código");

        jTxt_codigo.setEditable(false);
        jTxt_codigo.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBtt_novo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtt_salvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtt_editar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtt_excluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtt_cancelar))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxt_modelo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCbx_veiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jCbx_marca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxt_codigo)
                                .addGap(116, 116, 116)
                                .addComponent(jBtt_primeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtt_anterior)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtt_proximo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtt_ultimo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCbx_veiculo2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTxt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBtt_pesquisar)))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtt_anterior, jBtt_primeiro, jBtt_proximo, jBtt_ultimo});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel111, jLabel2, jLabel3});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtt_proximo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jBtt_anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jTxt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtt_ultimo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jBtt_primeiro))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCbx_veiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel111)
                    .addComponent(jCbx_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel120))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxt_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtt_salvar)
                    .addComponent(jBtt_editar)
                    .addComponent(jBtt_excluir)
                    .addComponent(jBtt_cancelar)
                    .addComponent(jBtt_novo))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTxt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtt_pesquisar))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCbx_veiculo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel113)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtt_anterior, jBtt_primeiro, jBtt_proximo, jBtt_ultimo});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel111, jLabel2, jLabel3});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtt_novoActionPerformed

        limpaCampos();
        flag = 0;

        conecta.executaSQL("select * from tb_modelos order by id_modelo");

        try {
            if (!conecta.rs.last()) {
                jTxt_codigo.setText("1");
            } else {
                jTxt_codigo.setText(String.valueOf(conecta.rs.getInt("id_modelo") + 1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir o registro!");
        }
        HabilitaDesabilitaCampos(true);
        jBtt_novo.setEnabled(false);
        jBtt_salvar.setEnabled(true);
        jBtt_editar.setEnabled(false);
        jBtt_excluir.setEnabled(false);
        jBtt_cancelar.setEnabled(true);
    }//GEN-LAST:event_jBtt_novoActionPerformed

    private void jBtt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtt_salvarActionPerformed
        char[] validaModelo = jTxt_modelo.getText().toCharArray();
        int ok = 0;
        for (int n = 0; n < jTxt_modelo.getText().length(); n++) {
            if (validaModelo[n] == ' ') {
                ok++;
            }
        }
        if (ok != jTxt_modelo.getText().length()) {

            jBtt_novo.setEnabled(true);
            jBtt_salvar.setEnabled(false);
            jBtt_editar.setEnabled(false);
            jBtt_excluir.setEnabled(false);
            jBtt_cancelar.setEnabled(false);
            model.setId_modelo(Integer.parseInt(jTxt_codigo.getText()));
            model.setVeiculo((String) jCbx_veiculo.getSelectedItem());
            model.setMarca((String) jCbx_marca.getSelectedItem());
            model.setDescricao(jTxt_modelo.getText());

            if (flag == 0) {
                conmod.GravareModelos(model);
            } else {
                conmod.AlterarModelos(model);
            }

            limpaCampos();
            HabilitaDesabilitaCampos(!true);
            preencherTabela("select * from tb_modelos order by id_modelo");
        } else {
            JOptionPane.showMessageDialog(null, "Preencha o campo modelo!", "Erro", JOptionPane.ERROR_MESSAGE);
            jTxt_modelo.setText("");
        }
    }//GEN-LAST:event_jBtt_salvarActionPerformed

    private void jBtt_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtt_editarActionPerformed
        flag = 1;

        jBtt_novo.setEnabled(false);
        jBtt_salvar.setEnabled(true);
        jBtt_editar.setEnabled(false);
        jBtt_excluir.setEnabled(false);
        jBtt_cancelar.setEnabled(true);
        HabilitaDesabilitaCampos(true);
    }//GEN-LAST:event_jBtt_editarActionPerformed

    private void jBtt_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtt_excluirActionPerformed

        jBtt_novo.setEnabled(true);
        jBtt_salvar.setEnabled(false);
        jBtt_editar.setEnabled(false);
        jBtt_excluir.setEnabled(false);
        jBtt_cancelar.setEnabled(false);
        conmod.ExcluirModelo(Integer.parseInt(jTxt_codigo.getText()));
        limpaCampos();
        HabilitaDesabilitaCampos(!true);
        preencherTabela("select * from tb_modelos order by id_modelo");

    }//GEN-LAST:event_jBtt_excluirActionPerformed

    private void jBtt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtt_cancelarActionPerformed
        jTxt_modelo.setEnabled(!true);
        jBtt_novo.setEnabled(true);
        jBtt_salvar.setEnabled(false);
        jBtt_editar.setEnabled(false);
        jBtt_excluir.setEnabled(false);
        jBtt_cancelar.setEnabled(false);
        limpaCampos();
        HabilitaDesabilitaCampos(!true);
        preencherTabela("select * from tb_modelos order by id_modelo");
    }//GEN-LAST:event_jBtt_cancelarActionPerformed

    private void jBtt_ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtt_ultimoActionPerformed
        jBtt_novo.setEnabled(true);
        jBtt_salvar.setEnabled(false);
        jBtt_editar.setEnabled(true);
        jBtt_excluir.setEnabled(true);
        jBtt_cancelar.setEnabled(true);
        model = conmod.Ultimo();
        jTxt_codigo.setText(String.valueOf(model.getId_modelo()));
        jCbx_veiculo.setSelectedItem(model.getVeiculo());
        jCbx_marca.setSelectedItem(model.getMarca());
        jTxt_modelo.setText(model.getDescricao());

        HabilitaDesabilitaCampos(!true);
    }//GEN-LAST:event_jBtt_ultimoActionPerformed

    private void jBtt_proximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtt_proximoActionPerformed
        jCbx_veiculo.setEnabled(!true);
        jCbx_marca.setEnabled(!true);
        jTxt_modelo.setEnabled(!true);
        jBtt_novo.setEnabled(true);
        jBtt_salvar.setEnabled(false);
        jBtt_editar.setEnabled(true);
        jBtt_excluir.setEnabled(true);
        jBtt_cancelar.setEnabled(true);
        model = conmod.Proximo();
        jTxt_codigo.setText(String.valueOf(model.getId_modelo()));
        jCbx_veiculo.setSelectedItem(model.getVeiculo());
        jCbx_marca.setSelectedItem(model.getMarca());
        jTxt_modelo.setText(model.getDescricao());

        HabilitaDesabilitaCampos(!true);
    }//GEN-LAST:event_jBtt_proximoActionPerformed

    private void jBtt_anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtt_anteriorActionPerformed
        jCbx_veiculo.setEnabled(!true);
        jCbx_marca.setEnabled(!true);
        jTxt_modelo.setEnabled(!true);
        jBtt_novo.setEnabled(true);
        jBtt_salvar.setEnabled(false);
        jBtt_editar.setEnabled(true);
        jBtt_excluir.setEnabled(true);
        jBtt_cancelar.setEnabled(true);
        model = conmod.Anterior();
        jTxt_codigo.setText(String.valueOf(model.getId_modelo()));
        jCbx_veiculo.setSelectedItem(model.getVeiculo());
        jCbx_marca.setSelectedItem(model.getMarca());
        jTxt_modelo.setText(model.getDescricao());
        HabilitaDesabilitaCampos(!true);
    }//GEN-LAST:event_jBtt_anteriorActionPerformed

    private void jBtt_primeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtt_primeiroActionPerformed
        jBtt_novo.setEnabled(true);
        jBtt_salvar.setEnabled(false);
        jBtt_editar.setEnabled(true);
        jBtt_excluir.setEnabled(true);
        jBtt_cancelar.setEnabled(true);
        model = conmod.Primeiro();
        jTxt_codigo.setText(String.valueOf(model.getId_modelo()));
        jCbx_veiculo.setSelectedItem(model.getVeiculo());
        jCbx_marca.setSelectedItem(model.getMarca());
        jTxt_modelo.setText(model.getDescricao());

        HabilitaDesabilitaCampos(!true);
    }//GEN-LAST:event_jBtt_primeiroActionPerformed

    private void jBtt_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtt_pesquisarActionPerformed
        HabilitaDesabilitaCampos(!true);
        String veiculo = null;

        if (jCbx_veiculo2.getSelectedItem() == "Todos") {
            veiculo = "";
        } else if (jCbx_veiculo2.getSelectedItem() == "Moto") {
            veiculo = "Moto";
        } else if (jCbx_veiculo2.getSelectedItem() == "Automovel") {
            veiculo = "Automovel";
        } else if (jCbx_veiculo2.getSelectedItem() == "Micro/Ônibus") {
            veiculo = "Micro/Ônibus";
        } else if (jCbx_veiculo2.getSelectedItem() == "Caminhão") {
            veiculo = "Caminhão";
        }

        preencherTabela("select * from tb_modelos  where descricao like '%" + jTxt_pesquisa.getText() + "%'  and veiculo  like '%" + veiculo + "%' order by id_modelo");

        jTxt_pesquisa.setText("");
    }//GEN-LAST:event_jBtt_pesquisarActionPerformed

    private void jTbl_modelosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTbl_modelosKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP) {
            atualizaTabela();
        }
    }//GEN-LAST:event_jTbl_modelosKeyReleased

    private void jTbl_modelosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbl_modelosMouseClicked
        atualizaTabela();
    }//GEN-LAST:event_jTbl_modelosMouseClicked

    private void jCbx_veiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbx_veiculoActionPerformed
        jCbx_marca.setModel(new javax.swing.DefaultComboBoxModel(validar.preencherCampo((String) jCbx_veiculo.getSelectedItem())));
    }//GEN-LAST:event_jCbx_veiculoActionPerformed

    private void jTxt_pesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxt_pesquisaKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            HabilitaDesabilitaCampos(!true);
            String veiculo = null;

            if (jCbx_veiculo2.getSelectedItem() == "Todos") {
                veiculo = "";
            } else if (jCbx_veiculo2.getSelectedItem() == "Moto") {
                veiculo = "Moto";
            } else if (jCbx_veiculo2.getSelectedItem() == "Automovel") {
                veiculo = "Automovel";
            } else if (jCbx_veiculo2.getSelectedItem() == "Micro/Ônibus") {
                veiculo = "Micro/Ônibus";
            } else if (jCbx_veiculo2.getSelectedItem() == "Caminhão") {
                veiculo = "Caminhão";
            }
            preencherTabela("select * from tb_modelos  where descricao like '%" + jTxt_pesquisa.getText() + "%'  and veiculo  like '%" + veiculo + "%' order by id_modelo");

            jTxt_pesquisa.setText("");
        }
    }//GEN-LAST:event_jTxt_pesquisaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtt_anterior;
    private javax.swing.JButton jBtt_cancelar;
    private javax.swing.JButton jBtt_editar;
    private javax.swing.JButton jBtt_excluir;
    private javax.swing.JButton jBtt_novo;
    private javax.swing.JButton jBtt_pesquisar;
    private javax.swing.JButton jBtt_primeiro;
    private javax.swing.JButton jBtt_proximo;
    private javax.swing.JButton jBtt_salvar;
    private javax.swing.JButton jBtt_ultimo;
    private javax.swing.JComboBox jCbx_marca;
    private javax.swing.JComboBox jCbx_veiculo;
    private javax.swing.JComboBox jCbx_veiculo2;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTbl_modelos;
    private javax.swing.JTextField jTxt_codigo;
    private javax.swing.JTextField jTxt_modelo;
    private javax.swing.JTextField jTxt_pesquisa;
    // End of variables declaration//GEN-END:variables
 public void limpaCampos() {
        jTxt_codigo.setText("");
        jTxt_modelo.setText("");
    }

    public void HabilitaDesabilitaCampos(boolean acao) {

        if (acao) {
            jCbx_veiculo.setEnabled(true);
            jCbx_marca.setEnabled(true);
            jCbx_veiculo.setEnabled(true);
            jCbx_marca.setEnabled(true);
            jTxt_modelo.setEnabled(true);
            jCbx_veiculo2.setEnabled(false);
            jTxt_pesquisa.setEnabled(false);
            jBtt_pesquisar.setEnabled(false);
        } else {
            jCbx_veiculo.setEnabled(false);
            jCbx_marca.setEnabled(false);
            jCbx_veiculo.setEnabled(false);
            jCbx_marca.setEnabled(false);
            jTxt_modelo.setEnabled(false);
            jCbx_veiculo2.setEnabled(true);
            jTxt_pesquisa.setEnabled(true);
            jBtt_pesquisar.setEnabled(true);
        }
    }

    public void preencherTabela(String SQL) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Veiculo", "Marca", "Modelo"};
        conecta.executaSQL(SQL);
        try {
            conecta.rs.first();

            do {
                dados.add(new Object[]{conecta.rs.getInt("id_modelo"), conecta.rs.getString("veiculo"), conecta.rs.getString("marca"), conecta.rs.getString("descricao")});

            } while (conecta.rs.next());

        } catch (SQLException ex) {

        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTbl_modelos.setModel(modelo);
        jTbl_modelos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTbl_modelos.getColumnModel().getColumn(0).setResizable(false);
        jTbl_modelos.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTbl_modelos.getColumnModel().getColumn(1).setResizable(false);
        jTbl_modelos.getColumnModel().getColumn(2).setPreferredWidth(140);
        jTbl_modelos.getColumnModel().getColumn(2).setResizable(false);
        jTbl_modelos.getColumnModel().getColumn(3).setPreferredWidth(140);
        jTbl_modelos.getColumnModel().getColumn(3).setResizable(false);
        jTbl_modelos.getTableHeader().setReorderingAllowed(false);
        jTbl_modelos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTbl_modelos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void atualizaTabela() {

        conecta.Conexao(obj_config._url);
        conecta.executaSQL("select * from tb_modelos where id_modelo = '" + jTbl_modelos.getValueAt(jTbl_modelos.getSelectedRow(), 0) + "'");
        try {
            conecta.rs.first();
            jTxt_codigo.setText(String.valueOf(conecta.rs.getInt("id_modelo")));
            jCbx_veiculo.setSelectedItem(conecta.rs.getString("veiculo"));
            jCbx_marca.setSelectedItem(conecta.rs.getString("marca"));
            jTxt_modelo.setText(conecta.rs.getString("descricao"));
            jBtt_novo.setEnabled(false);
            jBtt_salvar.setEnabled(false);
            jBtt_editar.setEnabled(true);
            jBtt_excluir.setEnabled(true);
            jBtt_cancelar.setEnabled(true);
            jTxt_pesquisa.setEnabled(true);
            jBtt_pesquisar.setEnabled(true);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar os dados do registro!\n\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        HabilitaDesabilitaCampos(!true);
    }

    public void AtualizaModelo() {
    }
}