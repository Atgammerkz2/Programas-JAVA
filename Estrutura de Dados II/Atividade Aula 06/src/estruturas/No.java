package estruturas;

import java.util.ArrayList;
import java.util.List;

public class No {
    public int valor;
    public No esquerdo;
    public No direito;

    public No(int valor) {
        this.valor = valor;
        this.esquerdo = null;
        this.direito = null;
    }
}
