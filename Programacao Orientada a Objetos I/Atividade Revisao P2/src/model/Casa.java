package model;

public class Casa extends Residencia {

    public Casa(int quartos, int banheiros, boolean quintal) {
        this.setQuartos(quartos);
        this.setBanheiros(banheiros);
        this.quintal = quintal;
    }

    private boolean quintal;

    public boolean temQuintal() {
        return quintal;
    }

    public void setQuintal(boolean quintal) {
        this.quintal = quintal;
    }
}
