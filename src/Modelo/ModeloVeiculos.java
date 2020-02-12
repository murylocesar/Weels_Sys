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
public class ModeloVeiculos {

    private int id_veiculo;
    private Date dataCad;
    private String compra_venda;
    private String veiculo;
    private String condicao;
    private int quilomentragem;
    private Date dataFab;
    private String anoModelo;
    private String porte;
    private String marca;
    private String modelo;
    private String versao;
    private String chassi;
    private String placa;
    private String cor;
    private int porta;
    private String flex;
    private String Direcao_hidraulica;
    private String ar_condicionado;
    private String obs;
    private Double valor_pago;
    private Double valor_venda;
    private String situacao;
    private String foto;

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
     * @return the dataCad
     */
    public Date getDataCad() {
        return dataCad;
    }

    /**
     * @param dataCad the dataCad to set
     */
    public void setDataCad(Date dataCad) {
        this.dataCad = dataCad;
    }

    /**
     * @return the compra_venda
     */
    public String getCompra_venda() {
        return compra_venda;
    }

    /**
     * @param compra_venda the compra_venda to set
     */
    public void setCompra_venda(String compra_venda) {
        this.compra_venda = compra_venda;
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

    /**
     * @return the condicao
     */
    public String getCondicao() {
        return condicao;
    }

    /**
     * @param condicao the condicao to set
     */
    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }

    /**
     * @return the quilomentragem
     */
    public int getQuilomentragem() {
        return quilomentragem;
    }

    /**
     * @param quilomentragem the quilomentragem to set
     */
    public void setQuilomentragem(int quilomentragem) {
        this.quilomentragem = quilomentragem;
    }

    /**
     * @return the dataFab
     */
    public Date getDataFab() {
        return dataFab;
    }

    /**
     * @param dataFab the dataFab to set
     */
    public void setDataFab(Date dataFab) {
        this.dataFab = dataFab;
    }

    /**
     * @return the anoModelo
     */
    public String getAnoModelo() {
        return anoModelo;
    }

    /**
     * @param anoModelo the anoModelo to set
     */
    public void setAnoModelo(String anoModelo) {
        this.anoModelo = anoModelo;
    }

    /**
     * @return the porte
     */
    public String getPorte() {
        return porte;
    }

    /**
     * @param porte the porte to set
     */
    public void setPorte(String porte) {
        this.porte = porte;
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
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the versao
     */
    public String getVersao() {
        return versao;
    }

    /**
     * @param versao the vesao to set
     */
    public void setVersao(String versao) {
        this.versao = versao;
    }

    /**
     * @return the chassi
     */
    public String getChassi() {
        return chassi;
    }

    /**
     * @param chassi the chassi to set
     */
    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @return the cor
     */
    public String getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * @return the porta
     */
    public int getPorta() {
        return porta;
    }

    /**
     * @param porta the porta to set
     */
    public void setPorta(int porta) {
        this.porta = porta;
    }

    /**
     * @return the flex
     */
    public String getFlex() {
        return flex;
    }

    /**
     * @param flex the flex to set
     */
    public void setFlex(String flex) {
        this.flex = flex;
    }

    /**
     * @return the ar_condicionado
     */
    public String getAr_condicionado() {
        return ar_condicionado;
    }

    /**
     * @param ar_condicionado the ar_condicionado to set
     */
    public void setAr_condicionado(String ar_condicionado) {
        this.ar_condicionado = ar_condicionado;
    }

    /**
     * @return the obs
     */
    public String getObs() {
        return obs;
    }

    /**
     * @param obs the obs to set
     */
    public void setObs(String obs) {
        this.obs = obs;
    }

    /**
     * @return the valor_pago
     */
    public Double getValor_pago() {
        return valor_pago;
    }

    /**
     * @param valor_pago the valor_pagor to set
     */
    public void setValor_pago(Double valor_pago) {
        this.valor_pago = valor_pago;
    }

    /**
     * @return the valor_venda
     */
    public Double getValor_venda() {
        return valor_venda;
    }

    /**
     * @param valor_venda the valor_venda to set
     */
    public void setValor_venda(Double valor_venda) {
        this.valor_venda = valor_venda;
    }

    /**
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * @return the Direcao_hidraulica
     */
    public String getDirecao_hidraulica() {
        return Direcao_hidraulica;
    }

    /**
     * @param Direcao_hidraulica the Direcao_hidraulica to set
     */
    public void setDirecao_hidraulica(String Direcao_hidraulica) {
        this.Direcao_hidraulica = Direcao_hidraulica;
    }
    

}
