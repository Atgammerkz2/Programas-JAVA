package estruturas;

import java.util.ArrayList;
import java.util.List;

public class Vertice implements Comparable<Vertice> {
    private String nome;
    private int distancia = Integer.MAX_VALUE;
    private Vertice pai;
    private boolean visitado = false;
    private List<Aresta> arestas = new ArrayList<>();

    public Vertice(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public Vertice getPai() {
        return pai;
    }

    public void setPai(Vertice pai) {
        this.pai = pai;
    }

    public boolean verificarVisita() {
        return visitado;
    }

    public void visitar() {
        this.visitado = true;
    }

    public List<Aresta> getArestas() {
        return arestas;
    }

    public void addAresta(Aresta aresta) {
        this.arestas.add(aresta);
    }

    @Override
    public int compareTo(Vertice other) {
        return Integer.compare(this.distancia, other.distancia);
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
