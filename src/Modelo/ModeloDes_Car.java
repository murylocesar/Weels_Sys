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
public class ModeloDes_Car {
    private int id_codigo;
    private int id_veiculo;
    private Date Data;
    private String Descricao;
    private Double valor;

    /**
     * @return the id_codigo
     */
    public int getId_codigo() {
        return id_codigo;
    }

    /**
     * @param id_codigo the id_codigo to set
     */
    public void setId_codigo(int id_codigo) {
        this.id_codigo = id_codigo;
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
     * @return the Data
     */
    public Date getData() {
        return Data;
    }

    /**
     * @param Data the Data to set
     */
    public void setData(Date Data) {
        this.Data = Data;
    }

    /**
     * @return the Descricao
     */
    public String getDescricao() {
        return Descricao;
    }

    /**
     * @param Descricao the Descricao to set
     */
    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    
}
