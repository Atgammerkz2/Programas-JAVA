import estruturas.ArvoreBinaria;
import estruturas.EstrategiaBusca;
import estruturas.No;

import java.util.Scanner;

public class Main {
    private static Scanner s = new Scanner(System.in);

    private static ArvoreBinaria arvore = new ArvoreBinaria();

    public static void main(String[] args){
        while (true) {
            int opcao = criarMenu(new String[] {
                "Inserir nós na árvore binária",
                "Consultar nós da árvore binária",
                "Excluir nós da árvore binária"
            }, "Menu Principal");

            switch (opcao){
                case 1:
                    while (opcao != -1){
                        opcao = criarMenu(new String[]{
                            "Adicionar um novo nó na árvore",
                            "Criar uma nova árvore com valores aleatórios"
                        }, "Selecione uma opção");

                        switch (opcao){
                            case 1:
                                System.out.print("Informe o valor do nó: ");
                                arvore.inserirNo(s.nextInt());
                                arvore.imprimirArvore();
                                opcao = -1;
                                break;

                            case 2:
                                System.out.print("\nInforme a quantidade de nós desejada: ");
                                arvore = ArvoreBinaria.gerarAleatoria(s.nextInt());
                                arvore.imprimirArvore();
                                opcao = -1;
                                break;
                        }
                    }
                    break;

                case 2:
                    while (opcao != -1){
                        opcao = criarMenu(new String[]{
                            "Exibir árvore binária",
                            "Verificar se um valor está presente na árvore",
                            "Pesquisar um valor na árvore por um método específico"
                        }, "Selecione uma opção");

                        switch (opcao){
                            case 1:
                                arvore.imprimirArvore();
                                break;

                            case 2:
                                System.out.print("Informe o valor que deseja procurar: ");
                                int valor = s.nextInt();
                                No tmp = arvore.buscarNo(valor, EstrategiaBusca.PRE_ORDEM, false);
                                arvore.imprimirArvore();
                                if(tmp != null){
                                    System.out.println("O valor " + valor + " está presente na árvore.");
                                } else {
                                    System.out.println("O valor " + valor + " não está presente na árvore.");
                                }
                                break;

                            case 3:
                                System.out.print("Informe o valor que deseja procurar: ");
                                int valorProc = s.nextInt();
                                opcao = criarMenu(new String[]{
                                    "Pré-ordem",
                                    "Intraordem",
                                    "Pós-ordem"
                                }, "Estratégia de busca");

                                if(opcao == -1){
                                    opcao = 1;
                                    break;
                                }
                                arvore.imprimirArvore();
                                No tmpNode = arvore.buscarNo(valorProc, EstrategiaBusca.converter(opcao), true);
                                if(tmpNode != null){
                                    System.out.println("O valor " + valorProc + " está presente na árvore.");
                                } else {
                                    System.out.println("O valor " + valorProc + " não está presente na árvore.");
                                }
                                break;
                        }
                    }
                    break;

                case 3:
                    System.out.print("Informe o valor do nó a ser deletado: ");
                    int valor_deletar = s.nextInt();

                    No noDeletar = arvore.buscarNo(valor_deletar, EstrategiaBusca.PRE_ORDEM, false);
                    if(noDeletar != null){
                        arvore.deletarNo(noDeletar);
                    } else {
                        arvore.imprimirArvore();
                        System.out.println("O valor informado não existe na árvore binária!");
                    }

                    break;

                case -1:
                    return;
            }
        }
    }

    private static int criarMenu(String[] opcoes, String titulo){
        int opcao = -1;
        while (opcao < 0 || opcao > opcoes.length + 1) {
            System.out.println("====== " + titulo + " ======");

            int i;
            for (i = 0; i < opcoes.length; i++){
                System.out.println((i+1) + " - " + opcoes[i]);
            }
            System.out.println((i+1) + " - Sair");
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
