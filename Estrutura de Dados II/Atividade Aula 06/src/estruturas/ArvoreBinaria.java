package estruturas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ArvoreBinaria {
    public No raiz;

    public void inserirNo(int valor) {
        raiz = inserirRecursivamente(raiz, valor);
    }

    private No inserirRecursivamente(No raiz, int valor) {
        if (raiz == null) {
            raiz = new No(valor);
            return raiz;
        }

        if (valor < raiz.valor) {
            raiz.esquerdo = inserirRecursivamente(raiz.esquerdo, valor);
        } else {
            raiz.direito = inserirRecursivamente(raiz.direito, valor);
        }

        return raiz;
    }

    private void imprimir(No raiz, int nivel) {
        if (raiz != null) {
            imprimir(raiz.direito, nivel + 1);

            if(raiz.direito != null){
                for (int i = 0; i < nivel; i++) {
                    System.out.print("   ");
                }
                System.out.print("  /\n");
            }

            for (int i = 0; i < nivel; i++) {
                System.out.print("   ");
            }
            System.out.println(raiz.valor);

            if(raiz.esquerdo != null){
                for (int i = 0; i < nivel; i++) {
                    System.out.print("   ");
                }
                System.out.print("  \\\n");
            }

            imprimir(raiz.esquerdo, nivel + 1);
        }
    }

    public void imprimirArvore(){
        System.out.print("\n====== Árvore Binária =====\n");
        imprimir(this.raiz, 0);
        System.out.println();
    }

    public void excluir(){
        while (raiz != null){
            deletarNoFolha(this.raiz);
        }
    }

    private No buscarPreOrdem(No raiz, int valorProcurado, boolean exibirCaminho){
        if(exibirCaminho){
            System.out.println("Visitado nó: " + raiz.valor);
        }

        No noAtual = null;

        if(raiz.valor == valorProcurado){
            return raiz;
        } else if (raiz.esquerdo != null){
            noAtual = buscarPreOrdem(raiz.esquerdo, valorProcurado, exibirCaminho);
        }

        if(noAtual == null && raiz.direito != null){
            noAtual = buscarPreOrdem(raiz.direito, valorProcurado, exibirCaminho);
        }

        return noAtual;
    }

    private void deletarNoFolha(No raiz){
        if(raiz == null){
            return;
        }

        if(raiz.equals(this.raiz) && this.raiz.esquerdo == null && this.raiz.direito == null){
            this.raiz = null;
            System.out.println("Excluindo o nó: " + raiz.valor);
            return;
        }

        if(raiz.esquerdo != null && raiz.esquerdo.esquerdo == null && raiz.esquerdo.direito == null){
            System.out.println("Excluindo o nó: " + raiz.esquerdo.valor);
            raiz.esquerdo = null;
        } else if(raiz.direito != null && raiz.direito.esquerdo == null && raiz.direito.direito == null){
            System.out.println("Excluindo o nó: " + raiz.direito.valor);
            raiz.direito = null;
        }

        deletarNoFolha(raiz.esquerdo);
        deletarNoFolha(raiz.direito);
    }
}

