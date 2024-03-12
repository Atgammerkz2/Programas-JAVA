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

    public static ArvoreBinaria gerarAleatoria(int quantidadeNos){
        ArvoreBinaria arvore = new ArvoreBinaria();

        for(int i = 0; i < quantidadeNos; i++){
            Random r = new Random();
            arvore.inserirNo(r.nextInt(100));
        }

        return arvore;
    }

    public No buscarNo(int valorProcurado, EstrategiaBusca estrategiaBusca, boolean exibirCaminho){
        switch (estrategiaBusca){
            case PRE_ORDEM:
                return buscarPreOrdem(this.raiz, valorProcurado, exibirCaminho);

            case INTRA_ORDEM:
                return buscarIntraOrdem(this.raiz, valorProcurado, exibirCaminho);

            case POS_ORDEM:
                return buscarPosOrdem(this.raiz, valorProcurado, exibirCaminho);

            default:
                return null;
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

    private No buscarIntraOrdem(No raiz, int valorProcurado, boolean exibirCaminho) {
        No noAtual = null;

        if(raiz.esquerdo != null){
            if(exibirCaminho){
                System.out.println("Visitado nó: " + raiz.esquerdo.valor);
            }
            noAtual = buscarIntraOrdem(raiz.esquerdo, valorProcurado, exibirCaminho);
        }

        if(noAtual == null){
            if(exibirCaminho && raiz.esquerdo != null){
                System.out.println("Visitado nó: " + raiz.valor);
            }

            if(raiz.valor == valorProcurado){
                noAtual = raiz;
            } else if(raiz.direito != null){
                if(exibirCaminho){
                    System.out.println("Visitado nó: " + raiz.direito.valor);
                }
                noAtual = buscarIntraOrdem(raiz.direito, valorProcurado, exibirCaminho);
            }
        }

        return noAtual;
    }

    private No buscarPosOrdem(No raiz, int valorProcurado, boolean exibirCaminho) {
        No noAtual = null;

        if(raiz.esquerdo != null){
            if(exibirCaminho) {
                System.out.println("Visitado nó: " + raiz.esquerdo.valor);
            }

            if(raiz.esquerdo.valor == valorProcurado){
                return raiz.esquerdo;
            } else if(raiz.esquerdo.esquerdo != null){
                noAtual = buscarPosOrdem(raiz.esquerdo, valorProcurado, exibirCaminho);
            }
        }

        if(noAtual != null){
            return noAtual;
        }

        if(raiz.direito != null){
            if(exibirCaminho) {
                System.out.println("Visitado nó: " + raiz.direito.valor);
            }

            if(raiz.direito.valor == valorProcurado){
                return raiz.direito;
            } else if(raiz.direito.esquerdo != null){
                noAtual = buscarPosOrdem(raiz.direito, valorProcurado, exibirCaminho);
            }
        }

        if(raiz.valor == valorProcurado){
            if(exibirCaminho) {
                System.out.println("Visitado nó: " + raiz.valor);
            }
            return raiz;
        }

        return noAtual;
    }

    public void deletarNo(No noDeletar){
        int valor = noDeletar.valor;

        if(noDeletar.esquerdo != null && noDeletar.direito != null) {
            noDeletar.valor = noDeletar.direito.valor;
            noDeletar.direito = noDeletar.direito.direito;
        } else if(noDeletar.esquerdo != null || noDeletar.direito != null) {
            No substituto = noDeletar.esquerdo != null ? noDeletar.esquerdo : noDeletar.direito;
            noDeletar.valor = substituto.valor;
            noDeletar.esquerdo = substituto.esquerdo;
            noDeletar.direito = substituto.direito;
        } else {
            if(noDeletar.equals(this.raiz)){
                this.raiz = null;
            } else {
                deletarNoFolha(this.raiz, noDeletar);
            }
        }

        this.imprimirArvore();
        System.out.println("Nó com valor " + valor + " excluído com sucesso!");
    }

    private void deletarNoFolha(No raiz, No noDeletar){
        if(raiz == null){
            return;
        }

        if(raiz.esquerdo != null && raiz.esquerdo.equals(noDeletar)){
            raiz.esquerdo = null;
        } else if(raiz.direito != null && raiz.direito.equals(noDeletar)){
            raiz.direito = null;
        }

        deletarNoFolha(raiz.esquerdo, noDeletar);
        deletarNoFolha(raiz.direito, noDeletar);
    }
}

