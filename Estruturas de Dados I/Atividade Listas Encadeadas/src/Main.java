import listas_encadeadas.IListaEncadeada;
import listas_encadeadas.ListaDuplamenteEncadeada;
import listas_encadeadas.ListaEncadeada;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        int opcaoPrincipal = -1;

        do {
            System.out.println("=========== Menu pricipal ===========");
            System.out.println("1 - Criar uma lista encadeada simples");
            System.out.println("2 - Criar uma lista duplamente encadeada");
            System.out.println("3 - Sair da aplicação\n");
            System.out.print("Escolha uma opção: ");

            try {
                opcaoPrincipal = scanner.nextInt();
            } catch (Exception ex){
                System.out.print("\nOpção inválida!\n\n");
                continue;
            }

            switch (opcaoPrincipal){
                case 1:
                    criarLista(false);
                    break;

                case 2:
                    criarLista(true);
                    break;

                case 3:
                    return;
            }
            opcaoPrincipal = -1;
        } while (opcaoPrincipal < 1 || opcaoPrincipal > 3);
    }

    private static void criarLista(boolean duplamenteEncadeada){
        IListaEncadeada lista = duplamenteEncadeada ? new ListaDuplamenteEncadeada() : new ListaEncadeada();
        adicionarValores(lista);

        int opcao = -1;

        do {
            System.out.println("======= Operações =======");
            System.out.println("1 - Adicionar elementos");
            System.out.println("2 - Excluir elementos");
            System.out.println("3 - Exibir elementos da lista");
            System.out.println("4 - Voltar ao menu principal");
            System.out.println("5 - Sair da aplicação\n");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
            } catch (Exception ex){
                System.out.print("\nOpção inválida!\n\n");
                continue;
            }

            switch (opcao){
                case 1:
                    adicionarValores(lista);
                    break;

                case 2:
                    excluirElementos(lista);
                    break;

                case 3:
                    mostrarLista(lista);
                    break;

                case 4:
                    return;

                case 5:
                    System.exit(0);
                    break;
            }
            opcao = -1;
        } while (opcao < 1 || opcao > 4);
    }

    private static void adicionarValores(IListaEncadeada lista){
        System.out.println("Insira os valores na lista (digite -1 para encerrar):");

        while (true){
            System.out.print("Informe o valor que deseja adicionar: ");

            int valor;
            try {
                valor = scanner.nextInt();
            } catch (Exception ex){
                System.out.println("Valor inválido!");
                continue;
            }

            if (valor == -1){
                break;
            }

            lista.inserirElemento(valor);
        }

        mostrarLista(lista);
    }

    private static void excluirElementos(IListaEncadeada lista){
        while (true){
            System.out.print("A lista informada foi: ");
            lista.exibirLista();

            System.out.print("Informe a posição (baseada em 0) do elemento que você deseja excluir: ");

            int pos;
            try {
                pos = scanner.nextInt();
                lista.apagarElemento(pos);
            } catch (Exception ex){
                continue;
            }

            System.out.print("Deseja continuar excluindo elementos? (S/N) ");
            boolean continuar = scanner.next().equalsIgnoreCase("S");

            if(!continuar){
                break;
            }
        }
        mostrarLista(lista);
    }

    private static void mostrarLista(IListaEncadeada lista){
        System.out.print("\nLista armazenada na memória: ");
        lista.exibirLista();
        System.out.println();
    }
}
