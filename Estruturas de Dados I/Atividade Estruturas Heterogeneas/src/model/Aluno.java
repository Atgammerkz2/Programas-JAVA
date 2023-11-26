package model;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private int id;
    private String nome;
    private List<Double> notas;

    public Aluno(int id, String nome, List<Double> notas) {
        this.id = id;
        this.nome = nome;
        this.notas = notas;
    }

    public Aluno (int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.notas = new ArrayList<>();
    }

    public List<Double> getNotas(){
        return this.notas;
    }

    private double calcularMedia() {
        if (notas.size() > 0) {
            double soma = 0;
            for (double nota : notas) {
                soma += nota;
            }
            return soma / notas.size();
        } else {
            return 0;
        }
    }

    public void exibirInformacoes() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.print("Notas: ");
        for (double nota : notas) {
            System.out.print(nota + " ");
        }
        System.out.printf("\nMédia Final: %.2f\n", calcularMedia());
        System.out.println("------------------------");
    }
}
