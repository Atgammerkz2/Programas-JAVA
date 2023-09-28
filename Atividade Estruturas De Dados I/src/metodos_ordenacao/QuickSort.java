package metodos_ordenacao;

public class QuickSort {
    public static void ordenar(int[] vetor){
        quickSort(vetor, 0, vetor.length - 1);
    }

    private static void quickSort(int[] vetor, int inicio, int fim){
        if(inicio < fim){
            int pivo = dividirVetor(vetor, inicio, fim);

            quickSort(vetor, inicio, pivo - 1);
            quickSort(vetor, pivo + 1, fim);
        }
    }

    public static int dividirVetor(int[] vetor, int inicio, int fim){
        int pivo = vetor[inicio];

        int i = inicio + 1;
        int j = fim;

        while (i <= j){
            if(vetor[i] <= pivo){
                i++;
            } else if(vetor[j] > pivo){
                j--;
            } else if(i <= j){
                trocarElementos(vetor, i, j);
            }
        }

        trocarElementos(vetor, inicio, j);

        return j;
    }

    public static void trocarElementos(int[] vetor, int i, int j){
        int tmp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = tmp;
    }
}
