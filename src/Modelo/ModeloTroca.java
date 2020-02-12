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
public class ModeloTroca {
    private int id_troca;
    private Date datacad;
    private int id_veiculo;
    private int id_veiculo_entrada;
    private String cliente;
    private String funcionario;
    private String forma_pagamento;
    private Double valor_troca;
    private int tempo_garantia;
    private String tipo_garantia;
    private String banco;
    private Double valor_financiado;
    private String nulo;

    /**
     * @return the id_troca
     */
    public int getId_troca() {
        return id_troca;
    }

    /**
     * @param id_troca the id_troca to set
     */
    public void setId_troca(int id_troca) {
        this.id_troca = id_troca;
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
     * @return the id_veiculo_entrada
     */
    public int getId_veiculo_entrada() {
        return id_veiculo_entrada;
    }

    /**
     * @param id_veiculo_entrada the id_veiculo_entrada to set
     */
    public void setId_veiculo_entrada(int id_veiculo_entrada) {
        this.id_veiculo_entrada = id_veiculo_entrada;
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
     * @return the valor_troca
     */
    public Double getValor_troca() {
        return valor_troca;
    }

    /**
     * @param valor_troca the valor_troca to set
     */
    public void setValor_troca(Double valor_troca) {
        this.valor_troca = valor_troca;
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
    public Double getValor_financiado() {
        return valor_financiado;
    }

    /**
     * @param valor_financiado the valor_financiado to set
     */
    public void setValor_financiado(Double valor_financiado) {
        this.valor_financiado = valor_financiado;
    }

    /**
     * @return the nulo
     */
    public String getNulo() {
        return nulo;
    }

    /**
     * @param nulo the nulo to set
     */
    public void setNulo(String nulo) {
        this.nulo = nulo;
    }
}
