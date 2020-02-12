/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.ConectaBanco;
import Controle.ModeloTabela;
import Controle.Validacoes;
import Controle.cadastro;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Murylo César Souza
 */
public class Pesquisa_movimentacao extends javax.swing.JDialog {

    ConectaBanco conecta = new ConectaBanco();
    ConectaBanco conVei = new ConectaBanco();
    ConectaBanco conMod = new ConectaBanco();
    ConectaBanco conFun = new ConectaBanco();
    ConectaBanco conCli = new ConectaBanco();

    ConectaBanco controle = new ConectaBanco();
    ConectaBanco conCliente = new ConectaBanco();
    ConectaBanco conFuncionarios = new ConectaBanco();
    ConectaBanco conVeiculos = new ConectaBanco();

    Validacoes validar = new Validacoes();
    cadastro obj_config = new cadastro();

    int codFuncionarios, codCliente, Pesquisa;

    /**
     * Creates new form Trocar_Pesquisa
     *
     * @param parent
     * @param modal
     * @param pesquisa
     */
    public Pesquisa_movimentacao(java.awt.Frame parent, boolean modal, int pesquisa) {
        super(parent, modal);
        initComponents();

        Pesquisa = pesquisa;
        obj_config.carregaconfig();
        conecta.Conexao(obj_config._url);
        conecta.executaSQL("select nome from tb_funcionarios order by nome");
        try {
            conecta.rs.first();
            do {
                jCbx_Funcionarios.addItem(conecta.rs.getString("nome"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        conecta.Desconecta();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jCbx_Funcionarios = new javax.swing.JComboBox();
        jRBt_fisica = new javax.swing.JRadioButton();
        jRBt_juridica = new javax.swing.JRadioButton();
        jRBt_todos = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jTxt_nome = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jCbx_veiculo = new javax.swing.JComboBox();
        jLabel112 = new javax.swing.JLabel();
        jCbx_condicao = new javax.swing.JComboBox();
        jCbx_marca = new javax.swing.JComboBox();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jCbx_modelo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTxt_versao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jRBt_sim = new javax.swing.JRadioButton();
        jRBt_nao = new javax.swing.JRadioButton();
        jRBt_todo_nulo = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa");
        setResizable(false);

        jLabel1.setText("Funcionários");

        jCbx_Funcionarios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos" }));

        buttonGroup1.add(jRBt_fisica);
        jRBt_fisica.setText("Fisica");

        buttonGroup1.add(jRBt_juridica);
        jRBt_juridica.setText("Juridica");

        buttonGroup1.add(jRBt_todos);
        jRBt_todos.setSelected(true);
        jRBt_todos.setText("Todos");

        jLabel3.setText("Cliente");

        jButton1.setText("Pesquisa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Veículo");

        jCbx_veiculo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Moto", "Automovel", "Micro/Ônibus", "Caminhão" }));
        jCbx_veiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbx_veiculoActionPerformed(evt);
            }
        });

        jLabel112.setText("Condição");

        jCbx_condicao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Novo", "Semi", "Usado" }));

        jCbx_marca.setEnabled(false);
        jCbx_marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbx_marcaActionPerformed(evt);
            }
        });

        jLabel120.setText("Marca");

        jLabel121.setText("Modelo");

        jCbx_modelo.setEnabled(false);

        jLabel5.setText("Tipo");

        jLabel6.setText("Versão");

        jLabel2.setText("Nulo");

        buttonGroup2.add(jRBt_sim);
        jRBt_sim.setText("Sim");

        buttonGroup2.add(jRBt_nao);
        jRBt_nao.setText("Não");

        buttonGroup2.add(jRBt_todo_nulo);
        jRBt_todo_nulo.setSelected(true);
        jRBt_todo_nulo.setText("Todos");

        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Todos");
        jRadioButton1.setEnabled(false);
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRBt_todos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRBt_fisica, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRBt_juridica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jCbx_Funcionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel112)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jCbx_marca, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jCbx_condicao, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCbx_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jCbx_veiculo, 0, 391, Short.MAX_VALUE)
                                            .addComponent(jTxt_nome)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTxt_versao, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jRBt_todo_nulo)
                                                .addGap(3, 3, 3)
                                                .addComponent(jRBt_sim)
                                                .addGap(18, 18, 18)
                                                .addComponent(jRBt_nao)))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel112, jLabel120, jLabel121, jLabel2, jLabel3, jLabel4, jLabel6});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCbx_Funcionarios, jCbx_condicao, jCbx_modelo, jCbx_veiculo, jTxt_nome, jTxt_versao});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCbx_Funcionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBt_todos)
                    .addComponent(jRBt_fisica)
                    .addComponent(jRBt_juridica)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jCbx_veiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCbx_condicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel112))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCbx_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel120)
                    .addComponent(jRadioButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel121)
                    .addComponent(jCbx_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTxt_versao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jRBt_sim)
                    .addComponent(jRBt_nao)
                    .addComponent(jRBt_todo_nulo))
                .addGap(20, 20, 20)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel112, jLabel120, jLabel121, jLabel2, jLabel3, jLabel4, jLabel6});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jCbx_Funcionarios, jCbx_condicao, jCbx_modelo, jCbx_veiculo, jTxt_nome, jTxt_versao});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String SQL, CPF_CNPJ, veiculo, condicao = null, descricao, marca, nulo;

        if (jRBt_fisica.isSelected()) {
            CPF_CNPJ = "F";
        } else if (jRBt_juridica.isSelected()) {
            CPF_CNPJ = "J";
        } else {
            CPF_CNPJ = "";
        }

        if (jCbx_veiculo.getSelectedItem() == "Todos") {
            veiculo = "";
        } else if (jCbx_veiculo.getSelectedItem() == "Moto") {
            veiculo = "M";
        } else if (jCbx_veiculo.getSelectedItem() == "Automovel") {
            veiculo = "A";
        } else if (jCbx_veiculo.getSelectedItem() == "Micro/Ônibus") {
            veiculo = "O";
        } else {
            veiculo = "C";

        }

        if (jCbx_condicao.getSelectedItem() == "Todos") {
            condicao = "";
        } else if (jCbx_condicao.getSelectedItem() == "Novo") {
            condicao = "N";
        } else if (jCbx_condicao.getSelectedItem() == "Semi") {
            condicao = "S";
        } else if (jCbx_condicao.getSelectedItem() == "Usado") {
            condicao = "U";
        }

        if (jRadioButton1.isSelected()) {
            marca = "";
        } else {
            marca = (String) (jCbx_marca.getSelectedItem());
        }
        if ((jCbx_veiculo.getSelectedItem() == "Todos") || (jCbx_modelo.getSelectedItem() == "Todos")) {
            descricao = "";
        } else {
            descricao = (String) (jCbx_modelo.getSelectedItem());
        }

        if (jRBt_todo_nulo.isSelected()) {
            nulo = "";
        } else if (jRBt_sim.isSelected()) {
            nulo = "T";
        } else {
            nulo = "F";
        }

        if (Pesquisa == 2) {
            if (jCbx_Funcionarios.getSelectedItem() == "Todos") {

                SQL = "select * from tb_vendas T ,tb_clientes_fornecedores C , tb_veiculos V ,tb_modelos M where"
                        + " T.nulo like '%" + nulo + "%'"
                        + " and V.id_veiculo = T.id_veiculo"
                        + " and V.veiculo like '%" + veiculo + "%'"
                        + " and V.condicao like '%" + condicao + "%'"
                        + " and V.marca like '%" + marca + "%'"
                        + " and V.versao like '%" + jTxt_versao.getText() + "%'"
                        + " and C.id_cliente_fornecedor=T.id_cliente"
                        + " and C.nome like '%" + jTxt_nome.getText() + "%'"
                        + " and C.fisica_juridica like '%" + CPF_CNPJ + "%'"
                        + " and M.id_modelo = V.modelo"
                        + " and M.descricao like '%" + descricao + "%'"
                        + " order by T.id_venda";
            } else {
                SQL = "select * from tb_vendas T ,tb_clientes_fornecedores C , tb_veiculos V ,tb_modelos M ,tb_funcionarios F where "
                        + " T.nulo like '%" + nulo + "%'"
                        + " and F.id_funcionario=T.id_funcionario "
                        + " and F.nome='" + (String) (jCbx_Funcionarios.getSelectedItem()) + "'"
                        + " and V.id_veiculo = T.id_veiculo"
                        + " and V.veiculo like '%" + veiculo + "%'"
                        + " and V.condicao like '%" + condicao + "%'"
                        + " and V.marca like '%" + marca + "%'"
                        + " and V.versao like '%" + jTxt_versao.getText() + "%'"
                        + " and C.id_cliente_fornecedor=T.id_cliente"
                        + " and C.nome like '%" + jTxt_nome.getText() + "%'"
                        + " and C.fisica_juridica like '%" + CPF_CNPJ + "%'"
                        + " and M.id_modelo = V.modelo"
                        + " and M.descricao like '%" + descricao + "%'"
                        + " order by T.id_venda";
            }

            ArrayList dados = new ArrayList();
            String[] Colunas = new String[]{"Código", "Nulo", "Data", "Funcionarios", "Cliente", "Valor"};
            conecta.Conexao(obj_config._url);

            conecta.executaSQL(SQL);

            conFun.Conexao(obj_config._url);

            try {
                conecta.rs.first();

                do {
                    conFun.executaSQL("select nome from tb_funcionarios where id_funcionario = " + conecta.rs.getInt("id_funcionario"));
                    conFun.rs.first();
                    String NULO = conecta.rs.getString("nulo");
                    if ("T".equals(NULO)) {
                        NULO = "SIM";
                    } else {
                        NULO = "---";
                    }
                    dados.add(new Object[]{conecta.rs.getInt("id_venda"), NULO, (validar.formDataDateToStr(conecta.rs.getDate("datacad"))), conFun.rs.getString("nome"), conecta.rs.getString("nome"), conecta.rs.getDouble("Valor_total")});
                } while (conecta.rs.next());

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Pesquisa não encontrada!", "Erro", JOptionPane.ERROR_MESSAGE);

                conecta.executaSQL("select * from tb_vendas Va ,tb_clientes_fornecedores C , tb_veiculos V ,tb_modelos M where "//Selecione as tabela
                        + " Va.id_cliente = C.id_cliente_fornecedor"
                        + " and V.id_veiculo = Va.id_veiculo "
                        + " and M.id_modelo = V.modelo"
                        + " order by id_venda");

                conFun.Conexao(obj_config._url);
                try {
                    conecta.rs.first();

                    do {
                        conFun.executaSQL("select nome from tb_funcionarios where id_funcionario = " + conecta.rs.getInt("id_funcionario"));
                        conFun.rs.first();
                        String NULO = conecta.rs.getString("nulo");
                        if ("T".equals(NULO)) {
                            NULO = "SIM";
                        } else {
                            NULO = "---";
                        }
                        dados.add(new Object[]{conecta.rs.getInt("id_venda"), NULO, (validar.formDataDateToStr(conecta.rs.getDate("datacad"))), conFun.rs.getString("nome"), conecta.rs.getString("nome"), conecta.rs.getDouble("Valor_total")});
                    } while (conecta.rs.next());

                } catch (SQLException exe) {
                    JOptionPane.showMessageDialog(null, "Nenhum registro salvo!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
            conFun.Desconecta();

            ModeloTabela modelo = new ModeloTabela(dados, Colunas);
            JIFVenda.jTbl_Venda.setModel(modelo);
            JIFVenda.jTbl_Venda.getColumnModel().getColumn(0).setPreferredWidth(50);
            JIFVenda.jTbl_Venda.getColumnModel().getColumn(0).setResizable(false);
            JIFVenda.jTbl_Venda.getColumnModel().getColumn(1).setPreferredWidth(40);
            JIFVenda.jTbl_Venda.getColumnModel().getColumn(1).setResizable(false);
            JIFVenda.jTbl_Venda.getColumnModel().getColumn(2).setPreferredWidth(80);
            JIFVenda.jTbl_Venda.getColumnModel().getColumn(2).setResizable(false);
            JIFVenda.jTbl_Venda.getColumnModel().getColumn(3).setPreferredWidth(200);
            JIFVenda.jTbl_Venda.getColumnModel().getColumn(3).setResizable(false);
            JIFVenda.jTbl_Venda.getColumnModel().getColumn(4).setPreferredWidth(200);
            JIFVenda.jTbl_Venda.getColumnModel().getColumn(4).setResizable(false);
            JIFVenda.jTbl_Venda.getColumnModel().getColumn(5).setPreferredWidth(70);
            JIFVenda.jTbl_Venda.getColumnModel().getColumn(5).setResizable(false);
            JIFVenda.jTbl_Venda.getTableHeader().setReorderingAllowed(false);
            JIFVenda.jTbl_Venda.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            JIFVenda.jTbl_Venda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        } else if (Pesquisa == 3) {
            if (jCbx_Funcionarios.getSelectedItem() == "Todos") {

                SQL = "select * from tb_troca T ,tb_clientes_fornecedores C , tb_veiculos V ,tb_modelos M where"
                        + " T.nulo like '%" + nulo + "%'"
                        + " and V.id_veiculo = T.id_veiculo"
                        + " and V.veiculo like '%" + veiculo + "%'"
                        + " and V.condicao like '%" + condicao + "%'"
                        + " and V.marca like '%" + marca + "%'"
                        + " and V.versao like '%" + jTxt_versao.getText() + "%'"
                        + " and C.id_cliente_fornecedor=T.id_cliente"
                        + " and C.nome like '%" + jTxt_nome.getText() + "%'"
                        + " and C.fisica_juridica like '%" + CPF_CNPJ + "%'"
                        + " and M.id_modelo = V.modelo"
                        + " and M.descricao like '%" + descricao + "%'"
                        + " order by T.id_troca";
            } else {
                SQL = "select * from tb_troca T ,tb_clientes_fornecedores C , tb_veiculos V ,tb_modelos M ,tb_funcionarios F where "
                        + " T.nulo like '%" + nulo + "%'"
                        + " and F.id_funcionario=T.id_funcionario "
                        + " and F.nome='" + (String) (jCbx_Funcionarios.getSelectedItem()) + "'"
                        + " and V.id_veiculo = T.id_veiculo"
                        + " and V.veiculo like '%" + veiculo + "%'"
                        + " and V.condicao like '%" + condicao + "%'"
                        + " and V.marca like '%" + marca + "%'"
                        + " and V.versao like '%" + jTxt_versao.getText() + "%'"
                        + " and C.id_cliente_fornecedor=T.id_cliente"
                        + " and C.nome like '%" + jTxt_nome.getText() + "%'"
                        + " and C.fisica_juridica like '%" + CPF_CNPJ + "%'"
                        + " and M.descricao = V.modelo"
                        + " and M.id_modelo like '%" + descricao + "%'"
                        + " order by T.id_troca";
            }

            ArrayList dados = new ArrayList();
            String[] Colunas = new String[]{"Código", "Nulo", "Funcionarios", "Cliente", "Marca", "modelo", "Vesão", "Placa"};
            conecta.Conexao(obj_config._url);

            conecta.executaSQL(SQL);

            conFun.Conexao(obj_config._url);

            try {
                conecta.rs.first();

                do {
                    conFun.executaSQL("select nome from tb_funcionarios where id_funcionario = " + conecta.rs.getInt("id_funcionario"));
                    conFun.rs.first();
                    String NULO = conecta.rs.getString("nulo");
                    if ("T".equals(NULO)) {
                        NULO = "SIM";
                    } else {
                        NULO = "---";
                    }
                    dados.add(new Object[]{conecta.rs.getInt("id_troca"), NULO, conFun.rs.getString("nome"), conecta.rs.getString("nome") /*conCli.rs.getString("nome")*/, conecta.rs.getString("marca"), conecta.rs.getString("descricao"), conecta.rs.getString("versao"), conecta.rs.getString("placa")});
                } while (conecta.rs.next());

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Pesquisa não encontrada!" + ex, "Erro", JOptionPane.ERROR_MESSAGE);

                conecta.executaSQL("select * from tb_troca T ,tb_clientes_fornecedores C , tb_veiculos V ,tb_modelos M where "//Selecione as tabela
                        + " T.id_cliente = C.id_cliente_fornecedor"
                        + " and V.id_veiculo = T.id_veiculo "
                        + " and M.id_modelo = V.modelo"
                        + " order by id_troca");

                conFun.Conexao(obj_config._url);
                try {
                    conecta.rs.first();

                    do {
                        conFun.executaSQL("select nome from tb_funcionarios where id_funcionario = " + conecta.rs.getInt("id_funcionario"));
                        conFun.rs.first();
                        String NULO = conecta.rs.getString("nulo");
                        if ("T".equals(NULO)) {
                            NULO = "SIM";
                        } else {
                            NULO = "---";
                        }
                        dados.add(new Object[]{conecta.rs.getInt("id_troca"), NULO, conFun.rs.getString("nome"), conecta.rs.getString("nome") /*conCli.rs.getString("nome")*/, conecta.rs.getString("marca"), conecta.rs.getString("descricao"), conecta.rs.getString("versao"), conecta.rs.getString("placa")});
                    } while (conecta.rs.next());

                } catch (SQLException exe) {
                    JOptionPane.showMessageDialog(null, "Pesquisa não encontrada!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
            conFun.Desconecta();
            ModeloTabela modelo = new ModeloTabela(dados, Colunas);
            JIFTroca.jTbl_Troca.setModel(modelo);
            JIFTroca.jTbl_Troca.getColumnModel().getColumn(0).setPreferredWidth(50);//90
            JIFTroca.jTbl_Troca.getColumnModel().getColumn(0).setResizable(false);
            JIFTroca.jTbl_Troca.getColumnModel().getColumn(1).setPreferredWidth(45);//90
            JIFTroca.jTbl_Troca.getColumnModel().getColumn(1).setResizable(false);
            JIFTroca.jTbl_Troca.getColumnModel().getColumn(2).setPreferredWidth(200);//420
            JIFTroca.jTbl_Troca.getColumnModel().getColumn(2).setResizable(false);
            JIFTroca.jTbl_Troca.getColumnModel().getColumn(3).setPreferredWidth(200);
            JIFTroca.jTbl_Troca.getColumnModel().getColumn(3).setResizable(false);
            JIFTroca.jTbl_Troca.getColumnModel().getColumn(4).setPreferredWidth(59);
            JIFTroca.jTbl_Troca.getColumnModel().getColumn(4).setResizable(false);
            JIFTroca.jTbl_Troca.getColumnModel().getColumn(5).setPreferredWidth(70);
            JIFTroca.jTbl_Troca.getColumnModel().getColumn(5).setResizable(false);
            JIFTroca.jTbl_Troca.getColumnModel().getColumn(6).setPreferredWidth(70);
            JIFTroca.jTbl_Troca.getColumnModel().getColumn(6).setResizable(false);
            JIFTroca.jTbl_Troca.getColumnModel().getColumn(7).setPreferredWidth(70);
            JIFTroca.jTbl_Troca.getColumnModel().getColumn(7).setResizable(false);
            JIFTroca.jTbl_Troca.getTableHeader().setReorderingAllowed(false);
            JIFTroca.jTbl_Troca.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            JIFTroca.jTbl_Troca.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCbx_veiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbx_veiculoActionPerformed
        if (jCbx_veiculo.getSelectedItem() == "Todos") {
            jCbx_marca.setEnabled(false);
            jRadioButton1.setSelected(true);
            jCbx_modelo.setEnabled(false);
            jRadioButton1.setEnabled(false);
        } else {

            jRadioButton1.setEnabled(true);
jCbx_marca.setModel(new javax.swing.DefaultComboBoxModel(validar.preencherCampo((String) jCbx_veiculo.getSelectedItem())));
            PreencherCombo("select * from tb_modelos where marca = '" + (String) jCbx_marca.getSelectedItem() + "' order by descricao");
        }
    }//GEN-LAST:event_jCbx_veiculoActionPerformed

    private void jCbx_marcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbx_marcaActionPerformed
        PreencherCombo("select * from tb_modelos where marca = '" + (String) jCbx_marca.getSelectedItem() + "' order by descricao");
    }//GEN-LAST:event_jCbx_marcaActionPerformed

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        if (jRadioButton1.isSelected()) {
            jCbx_modelo.setEnabled(false);
            jCbx_marca.setEnabled(false);
        } else {
            jCbx_modelo.setEnabled(true);
            jCbx_marca.setEnabled(true);
        }
    }//GEN-LAST:event_jRadioButton1MouseClicked

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
            java.util.logging.Logger.getLogger(Pesquisa_movimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pesquisa_movimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pesquisa_movimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pesquisa_movimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            Pesquisa_movimentacao dialog = new Pesquisa_movimentacao(new javax.swing.JFrame(), true, 0);
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jCbx_Funcionarios;
    private javax.swing.JComboBox jCbx_condicao;
    private javax.swing.JComboBox jCbx_marca;
    private javax.swing.JComboBox jCbx_modelo;
    private javax.swing.JComboBox jCbx_veiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRBt_fisica;
    private javax.swing.JRadioButton jRBt_juridica;
    private javax.swing.JRadioButton jRBt_nao;
    private javax.swing.JRadioButton jRBt_sim;
    private javax.swing.JRadioButton jRBt_todo_nulo;
    private javax.swing.JRadioButton jRBt_todos;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTxt_nome;
    private javax.swing.JTextField jTxt_versao;
    // End of variables declaration//GEN-END:variables

    public String buscaCodigoModelo() {
        conMod.Conexao(obj_config._url);
        conMod.executaSQL("select * from tb_modelos where descricao = '" + (String) jCbx_modelo.getSelectedItem() + "'");
        try {
            conMod.rs.first();
            return String.valueOf(conMod.rs.getInt("id_modelo"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar os funcionários cadastrados com este código!" + ex);
        }
        conMod.Desconecta();
        return "";
    }

    public void PreencherCombo(String SQL) {

        conMod.Conexao(obj_config._url);
        conMod.executaSQL(SQL);
        try {
            conMod.rs.first();
            jCbx_modelo.removeAllItems();
            jCbx_modelo.addItem("Todos");
            do {
                jCbx_modelo.addItem(conMod.rs.getString("descricao"));
            } while (conMod.rs.next());
        } catch (SQLException ex) {
        }
        conMod.Desconecta();
    }
}
