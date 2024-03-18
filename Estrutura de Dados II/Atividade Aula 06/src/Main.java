import estruturas.ArvoreBinaria;
import estruturas.No;

import java.util.Scanner;

public class Main {
    private static Scanner s = new Scanner(System.in);

    private static ArvoreBinaria arvore = new ArvoreBinaria();

    public static void main(String[] args) {
        while (true) {
            int opcao = criarMenu(new String[] {
                "Inserir nós na árvore binária",
                "Excluir árvore binária"
            }, "Menu Principal", true);

            switch (opcao){
                case 1:
                    while (true){
                        System.out.print("Informe o valor do nó (-1 para finalizar): ");
                        int valor = s.nextInt();

                        if(valor == -1){
                            break;
                        }

                        arvore.inserirNo(valor);
                        arvore.imprimirArvore();
                    }
                    break;

                case 2:
                    System.out.print("Tem certeza que deseja excluir a árvore binária? (S/N)");
                    if(s.next().equalsIgnoreCase("S")){
                        arvore.excluir();
                        arvore = new ArvoreBinaria();
                        System.out.println("Árvore binária excluída com sucesso");
                    }
                    break;

                case -1:
                    return;
            }
        }
    }

    private static int criarMenu(String[] opcoes, String titulo, boolean sair){
        int opcao = -1;
        while (opcao < 0 || opcao > opcoes.length + 1) {
            System.out.println("====== " + titulo + " ======");

            int i;
            for (i = 0; i < opcoes.length; i++){
                System.out.println((i+1) + " - " + opcoes[i]);
            }

            String optSair = sair ? "Sair" : "Voltar";
            System.out.println((i+1) + " - " + optSair);
            System.out.print("Informe a opção desejada: ");
            opcao = s.nextInt();

            if(opcao == i+1){
                return -1;
            } else if(opcao < 0 || opcao > opcoes.length + 1){
                System.out.println("\nOpção inválida!\n");
            }

            System.out.println();
            break;
        }

        return opcao;
    }
}
