package model;

import interfaces.IResidencia;

public class Residencia implements IResidencia {

    private int quartos;
    private int banheiros;

    public int getQuartos() {
        return quartos;
    }

    public void setQuartos(int quartos) {
        this.quartos = quartos;
    }

    public int getBanheiros() {
        return banheiros;
    }

    public void setBanheiros(int banheiros) {
        this.banheiros = banheiros;
    }

    public void alugar() {
        System.out.println("Casa alugada com sucesso!");
    }

    public void comprar() {
        System.out.println("Casa comprada com sucesso!");
    }
}
