package estruturas;

import java.util.*;

public class Dijkstra {
    List<Vertice> menorCaminho = new ArrayList<>();
    Vertice verticeCaminho = new Vertice("");
    Vertice atual = new Vertice("");
    Vertice vizinho = new Vertice("");
    List<Vertice> naoVisitados = new ArrayList<>();

    public List<Vertice> encontrarMenorCaminhoDijkstra(Grafo grafo, Vertice v1, Vertice v2) {
        menorCaminho.add(v1);

        for (Vertice v : grafo.getVertices()) {
            if (v.equals(v1)) {
                v.setDistancia(0);
            } else {
                v.setDistancia(Integer.MAX_VALUE);
            }
            naoVisitados.add(v);
        }

        Collections.sort(naoVisitados);

        while (!naoVisitados.isEmpty()) {
            atual = naoVisitados.get(0);

            for (Aresta aresta : atual.getArestas()) {
                vizinho = aresta.getDestino();
                if (!vizinho.verificarVisita()) {
                    if (vizinho.getDistancia() > (atual.getDistancia() + aresta.getPeso())) {
                        vizinho.setDistancia(atual.getDistancia() + aresta.getPeso());
                        vizinho.setPai(atual);

                        if (vizinho.equals(v2)) {
                            menorCaminho.clear();
                            verticeCaminho = vizinho;
                            menorCaminho.add(vizinho);
                            while (verticeCaminho.getPai() != null) {
                                menorCaminho.add(verticeCaminho.getPai());
                                verticeCaminho = verticeCaminho.getPai();
                            }
                            Collections.sort(menorCaminho);
                        }
                    }
                }
            }

            atual.visitar();
            naoVisitados.remove(atual);
            Collections.sort(naoVisitados);
        }

        return menorCaminho;
    }

}
