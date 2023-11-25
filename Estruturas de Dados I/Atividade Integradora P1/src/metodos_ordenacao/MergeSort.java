package metodos_ordenacao;

public class MergeSort {
    public static void ordenar(int[] vetor) {
        if (vetor.length <= 1) {
            return;
        }

        int meio = vetor.length / 2;
        int[] metadeEsquerda = new int[meio];
        int[] metadeDireita = new int[vetor.length - meio];


        for (int i = 0; i < meio; i++) {
            metadeEsquerda[i] = vetor[i];
        }

        for (int i = meio; i < vetor.length; i++) {
            metadeDireita[i - meio] = vetor[i];
        }

        ordenar(metadeEsquerda);
        ordenar(metadeDireita);
        combinar(vetor, metadeEsquerda, metadeDireita);
    }

    private static void combinar(int[] vetor, int[] metadeEsquerda, int[] metadeDireita) {
        int i = 0, j = 0, pos = 0;

        //Percorre as metades do vetor e preenche de forma ordenada
        while (i < metadeEsquerda.length && j < metadeDireita.length) {
            if (metadeEsquerda[i] < metadeDireita[j]) {
                vetor[pos++] = metadeEsquerda[i++];
            } else {
                vetor[pos++] = metadeDireita[j++];
            }
        }

        //Preenche o restante do vetor com a metade que falta, caso uma das metades foi toda percorrida e outra não.
        //O que significa que esses valores são maiores que o da outra metade
        while (i < metadeEsquerda.length) {
            vetor[pos++] = metadeEsquerda[i++];
        }
        while (j < metadeDireita.length) {
            vetor[pos++] = metadeDireita[j++];
        }
    }
}
