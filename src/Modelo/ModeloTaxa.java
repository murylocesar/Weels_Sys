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
public class ModeloTaxa {

    private int id_taxa;
    private String tipo;
    private Date datacad;
    private String descricao;
    private int parcela;
    private int entrada;
    private double valor;
    private String ano_modelo;
    private float coeficiente;

    /**
     * @return the id_taxa
     */
    public int getId_taxa() {
        return id_taxa;
    }

    /**
     * @param id_taxa the id_taxa to set
     */
    public void setId_taxa(int id_taxa) {
        this.id_taxa = id_taxa;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the parcela
     */
    public int getParcela() {
        return parcela;
    }

    /**
     * @param parcela the parcela to set
     */
    public void setParcela(int parcela) {
        this.parcela = parcela;
    }

    /**
     * @return the entrada
     */
    public int getEntrada() {
        return entrada;
    }

    /**
     * @param entrada the entrada to set
     */
    public void setEntrada(int entrada) {
        this.entrada = entrada;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the ano_modelo
     */
    public String getAno_modelo() {
        return ano_modelo;
    }

    /**
     * @param ano_modelo the ano_modelo to set
     */
    public void setAno_modelo(String ano_modelo) {
        this.ano_modelo = ano_modelo;
    }

    /**
     * @return the coeficiente
     */
    public float getCoeficiente() {
        return coeficiente;
    }

    /**
     * @param coeficiente the coeficiente to set
     */
    public void setCoeficiente(float coeficiente) {
        this.coeficiente = coeficiente;
    }

}
