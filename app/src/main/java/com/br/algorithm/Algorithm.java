package com.br.algorithm;

/**
 * Created by a.ricarti on 09/12/2016.
 */

public class Algorithm {
    private String algorithm;
    private String tipoAlgorithm;
    private String linguagem;

    public Algorithm(){

    }

    public Algorithm(String algorithm, String tipoAlgorithm, String linguagem) {
        this.algorithm = algorithm;
        this.tipoAlgorithm = tipoAlgorithm;
        this.linguagem = linguagem;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getTipoAlgorithm() {
        return tipoAlgorithm;
    }

    public void setTipoAlgorithm(String tipoAlgorithm) {
        this.tipoAlgorithm = tipoAlgorithm;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }
}
