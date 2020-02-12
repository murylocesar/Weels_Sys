/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author Murylo César Souza
 */
public class ModeloVendas {

    private int id_venda;
    private Date datacad;
    private String cliente;
    private String funcionario;
    private int id_veiculo;
    private String forma_pagamento;
    private float valor_total;
    private int tempo_garantia;
    private String tipo_garantia;
    private String banco;
    private float valor_financiado;

    /**
     * @return the id_movimentacao
     */
    public int getId_venda() {
        return id_venda;
    }

    /**
     * @param id_venda the id_movimentacao to set
     */
    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    /**
     * @return the datacad
     */
    public Date getDatacad() {
        return datacad;
    }

    /**
     * @param datacad the datacad to set
     */
    public void setDatacad(Date datacad) {
        this.datacad = datacad;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the funcionario
     */
    public String getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * @return the id_veiculo
     */
    public int getId_veiculo() {
        return id_veiculo;
    }

    /**
     * @param id_veiculo the id_veiculo to set
     */
    public void setId_veiculo(int id_veiculo) {
        this.id_veiculo = id_veiculo;
    }

    /**
     * @return the forma_pagamento
     */
    public String getForma_pagamento() {
        return forma_pagamento;
    }

    /**
     * @param forma_pagamento the forma_pagamento to set
     */
    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    /**
     * @return the valor_total
     */
    public float getValor_total() {
        return valor_total;
    }

    /**
     * @param valor_total the valor_total to set
     */
    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

    /**
     * @return the tempo_garantia
     */
    public int getTempo_garantia() {
        return tempo_garantia;
    }

    /**
     * @param tempo_garantia the tempo_garantia to set
     */
    public void setTempo_garantia(int tempo_garantia) {
        this.tempo_garantia = tempo_garantia;
    }

    /**
     * @return the tipo_garantia
     */
    public String getTipo_garantia() {
        return tipo_garantia;
    }

    /**
     * @param tipo_garantia the tipo_garantia to set
     */
    public void setTipo_garantia(String tipo_garantia) {
        this.tipo_garantia = tipo_garantia;
    }

    /**
     * @return the banco
     */
    public String getBanco() {
        return banco;
    }

    /**
     * @param banco the banco to set
     */
    public void setBanco(String banco) {
        this.banco = banco;
    }

    /**
     * @return the valor_financiado
     */
    public float getValor_financiado() {
        return valor_financiado;
    }

    /**
     * @param valor_financiado the valor_financiado to set
     */
    public void setValor_financiado(float valor_financiado) {
        this.valor_financiado = valor_financiado;
    }

}
