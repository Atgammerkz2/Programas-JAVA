package estruturas;

import java.util.ArrayList;
import java.util.List;

public class No {
    public int valor;
    public No esquerdo;
    public No direito;
    private List<No> vizinhos;

    public No(int valor) {
        this.valor = valor;
        this.esquerdo = null;
        this.direito = null;
        vizinhos = new ArrayList<>();
    }

    public List<No> getVizinhos(){
        return vizinhos;
    }

    public void addVizinho(No no){
        vizinhos.add(no);
    }
}
