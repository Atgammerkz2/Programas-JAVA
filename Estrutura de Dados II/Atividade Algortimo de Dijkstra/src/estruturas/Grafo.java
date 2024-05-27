package estruturas;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
    private List<Vertice> vertices = new ArrayList<>();

    public void addVertice(Vertice vertice) {
        vertices.add(vertice);
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public Vertice getVertice(String nome) {
        for (Vertice v : vertices) {
            if (v.getNome().equals(nome)) {
                return v;
            }
        }
        return null;
    }
}
