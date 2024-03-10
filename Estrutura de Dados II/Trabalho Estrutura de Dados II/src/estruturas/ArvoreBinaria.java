package estruturas;

import java.util.LinkedList;
import java.util.Queue;

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

    public static int calcularProfundidade(No raiz) {
        if (raiz == null) {
            return 0;  // Se a árvore estiver vazia, a altura é 0.
        }

        int altura = 0;  // Inicializa a altura como 0.
        Queue<No> fila = new LinkedList<>();  // Cria uma fila para percorrer os nós.
        fila.offer(raiz);  // Adiciona o nó raiz à fila.

        while (!fila.isEmpty()) {  // Enquanto a fila não estiver vazia.
            int numeroNos = fila.size();  // Obtém o número de nós no nível atual.
            for (int i = 0; i < numeroNos; i++) {
                No node = fila.poll();  // Remove o nó da frente da fila.
                if (node.esquerdo != null) {
                    fila.offer(node.esquerdo);  // Adiciona o nó à esquerda à fila.
                }
                if (node.direito != null) {
                    fila.offer(node.direito);  // Adiciona o nó à direita à fila.
                }
            }
            altura++;  // Incrementa a altura após processar um nível.
        }

        return altura;  // Retorna a altura calculada.
    }

    public void imprimirArvore(No raiz, int nivel) {
        if (raiz != null) {
            imprimirArvore(raiz.direito, nivel + 1);

            for (int i = 0; i < nivel; i++) {
                System.out.print("   ");
            }

            System.out.println(raiz.valor);

            imprimirArvore(raiz.esquerdo, nivel + 1);
        }
    }
}

