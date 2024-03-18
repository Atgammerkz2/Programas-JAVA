import java.util.*;

public class EstadoTabuleiro {
    int[][] tabuleiro;
    EstadoTabuleiro anterior;
    int g; // Cost from start
    int h; // Heuristic cost
    int f; // Total cost
    int tam = 3; // Tamanho do tabuleiro (3x3 para o quebra-cabeça 8)

    public EstadoTabuleiro(int[][] tabuleiro, EstadoTabuleiro anterior) {
        this.tabuleiro = copiarArray(tabuleiro);
        this.anterior = anterior;
        this.g = (anterior != null) ? anterior.g + 1 : 0;
        this.h = calcularHeuristica(tabuleiro);
        this.f = this.g + this.h;
    }

    public int calcularHeuristica(int[][] tabuleiroAtual) {
        int heuristica = 0;

        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                int value = tabuleiroAtual[i][j];

                if (value != 0) {
                    int targetX = (value - 1) / tam;
                    int targetY = (value - 1) % tam;
                    heuristica += Math.abs(i - targetX) + Math.abs(j - targetY);
                }
            }
        }

        return heuristica;
    }

    public List<EstadoTabuleiro> obterVizinhos() {
        List<EstadoTabuleiro> vizinhos = new ArrayList<>();
        int posicao_zero = encontrarZero();
        int x = posicao_zero / tam;
        int y = posicao_zero % tam;

        // Definições para mover o espaço vazio: para cima, para baixo, para a esquerda, para a direita
        int[][] direcoes = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] direcao : direcoes) {
            int novoX = x + direcao[0], novoY = y + direcao[1];

            if (novoX >= 0 && novoX < tam && novoY >= 0 && novoY < tam) {
                int[][] novoTabuleiro = copiarArray(tabuleiro);
                novoTabuleiro[x][y] = novoTabuleiro[novoX][novoY];
                novoTabuleiro[novoX][novoY] = 0;
                vizinhos.add(new EstadoTabuleiro(novoTabuleiro, this));
            }
        }

        return vizinhos;
    }

    private int encontrarZero() {
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                if (tabuleiro[i][j] == 0) {
                    return i * tam + j;
                }
            }
        }
        return -1; // Não deveria acontecer se o tabuleiro sempre tiver um zero
    }

    private int[][] copiarArray(int[][] original) {
        int[][] copia = new int[tam][tam];
        for (int i = 0; i < tam; i++) {
            System.arraycopy(original[i], 0, copia[i], 0, tam);
        }
        return copia;
    }

    public boolean isIdeal(int[][] tabuleiroIdeal) {
        return Arrays.deepEquals(this.tabuleiro, tabuleiroIdeal);
    }

    public void imprimirTabuleiro() {
        for (int[] linha : tabuleiro) {
            for (int val : linha) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadoTabuleiro that = (EstadoTabuleiro) o;
        return Arrays.deepEquals(tabuleiro, that.tabuleiro);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(tabuleiro);
    }
}