/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Murylo César Souza
 */
public class ModeloModelos {

    private int id_modelo;
    private String veiculo;
    private String marca;
    private String descricao;

    /**
     * @return the id_modelo
     */
    public int getId_modelo() {
        return id_modelo;
    }

    /**
     * @param id_modelo the id_modelo to set
     */
    public void setId_modelo(int id_modelo) {
        this.id_modelo = id_modelo;
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
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the veiculo
     */
    public String getVeiculo() {
        return veiculo;
    }

    /**
     * @param veiculo the veiculo to set
     */
    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

}
