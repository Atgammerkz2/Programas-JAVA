//Aluno: Michael Marinho da Silva
//Turma: Engenharia de Software - 3º Período

import metodos_ordenacao.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Informe o tamanho do vetor de inteiros que você deseja ordenar: ");
        int tam = s.nextInt();

        int[] vetor = new int[tam];

        int opcao = -1;
        while (opcao != 1 && opcao != 2){
            System.out.println("Selecione a opção que corresponde a como você deseja preencher o vetor:\n1 - Preencher manualmente\n2 - Preencher com números aleatórios");
            try {
                opcao = s.nextInt();
            } catch (Exception ex){ }

            if(opcao != 1 && opcao != 2){
                System.out.println("Opção inválida!");
            }
        }

        if(opcao == 1){
            for (int i = 0; i < tam; i++){
                System.out.printf("Digite o %dº elemento: ", i + 1);
                vetor[i] = s.nextInt();
            }
        } else {
            Random r = new Random();
            Arrays.setAll(vetor, x -> r.nextInt(99));
        }

        opcao = -1;
        while (opcao < 1 || opcao > 4){
            System.out.println("Qual método de ordenação de vetores você deseja usar?");
            System.out.println("1 - Ordenação por BubbleSort");
            System.out.println("2 - Ordenação por QuickSort");
            System.out.println("3 - Ordenação por MergeSort");
            System.out.println("4 - Ordenação por HeapSort");

            try {
                opcao = s.nextInt();
            } catch (Exception ex){ }
            if(opcao < 1 || opcao > 4){
                System.out.println("Opção inválida!");
            }
        }

        System.out.print("\nVetor informado: [ ");
        for (int i = 0; i < tam; i++){
            System.out.print(vetor[i] + " ");
        }
        System.out.print("]\n");

        String algoritmoSelecionado = "";

        switch (opcao) {
            case 1:
                BubbleSort.ordenar(vetor);
                algoritmoSelecionado = "BubbleSort";
                break;

            case 2:
                QuickSort.ordenar(vetor);
                algoritmoSelecionado = "QuickSort";
                break;

            case 3:
                MergeSort.ordenar(vetor);
                algoritmoSelecionado = "MergeSort";
                break;

            case 4:
                HeapSort.ordenar(vetor);
                algoritmoSelecionado = "HeapSort";
                break;
        }

        System.out.printf("Vetor ordenado com o algoritmo %s: [ ", algoritmoSelecionado);
        for (int i = 0; i < tam; i++){
            System.out.print(vetor[i] + " ");
        }
        System.out.print("]\n\n");
    }
}