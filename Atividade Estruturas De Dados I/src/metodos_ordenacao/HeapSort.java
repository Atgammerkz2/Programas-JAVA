package metodos_ordenacao;

public class HeapSort {
    public static void ordenar(int vetor[]) {
        int tam = vetor.length;

        // Construir o heap da metade do vetor até o início
        for (int i = tam / 2 - 1; i >= 0; i--) {
            aplicarHeap(vetor, tam, i);
        }

        // Extrair elementos do heap um por um, jogando eles para o final do vetor já que os elementos da direita serão sempre os maiores após aplicar o heap
        for (int i = tam - 1; i >= 0; i--) {
            // Trocar o elemento raiz com o último elemento
            int temp = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = temp;

            //Após trocar os elementos de lugar deve-se aplicar o heap novamente no restante do vetor para que o elemento da esquerda seja o
            // maior daquele trecho do vetor
            aplicarHeap(vetor, i, 0);
        }
    }

    private static void aplicarHeap(int vetor[], int tam, int inicio) {
        int pos_maior = inicio;
        int filho_esquerdo = 2 * inicio + 1;
        int filho_direito = 2 * inicio + 2;

        if (filho_esquerdo < tam && vetor[filho_esquerdo] > vetor[pos_maior]){
            pos_maior = filho_esquerdo;
        }
        if (filho_direito < tam && vetor[filho_direito] > vetor[pos_maior]){
            pos_maior = filho_direito;
        }

        if (pos_maior != inicio) {
            int aux = vetor[inicio];
            vetor[inicio] = vetor[pos_maior];
            vetor[pos_maior] = aux;

            aplicarHeap(vetor, tam, pos_maior);
        }
    }
}
