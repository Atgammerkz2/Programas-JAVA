//Turma: Engenharia de Software - 3º Período
//Aluno: Michael Marinho da Silva

import model.Aluno;

import java.util.Scanner;

public class Main {
    public static void main(String[ ] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o número de alunos que você deseja cadastrar: ");
        int numAlunos = scanner.nextInt();

        Aluno[] alunos = new Aluno[numAlunos];

        for (int i = 0; i < numAlunos; i++) {
            System.out.printf("Informe o nome do %dº aluno: ", i+1);
            String nome = scanner.next();

            Aluno aluno = new Aluno(i + 1, nome);

            System.out.print("Quantas notas você deseja cadastrar para esse aluno: ");
            int numNotas = scanner.nextInt();

            System.out.println("Informe as notas:");
            for (int j = 0; j < numNotas; j++) {
                System.out.print("Nota " + (j + 1) + ": ");
                aluno.getNotas().add(scanner.nextDouble());
            }

            alunos[i] = aluno;
        }

        System.out.println("\nInformações dos Alunos:");
        for (Aluno aluno : alunos) {
            aluno.exibirInformacoes();
        }

        scanner.close();
    }
}