package model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Aluno {
    public Aluno(long id, String nome, Queue<Double> notas) {
        this.id = id;
        this.nome = nome;
        this.notas = notas;
    }

    public Aluno(){
        this.notas = new LinkedList<>();
    }

    private long id;
    private String nome;
    private Queue<Double> notas;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Queue<Double> getNotas() {
        return notas;
    }

    public void setNotas(Queue<Double> notas) {
        this.notas = notas;
    }

    public double calcularMedia(){
        double soma = 0;

        Iterator<Double> iterator = this.notas.iterator();
        while (iterator.hasNext()){
            soma += iterator.next();
        }

        return soma / this.notas.size();
    }
}
