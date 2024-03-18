import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] tabuleiroInicial = {
                {7, 2, 4},
                {5, 0, 6},
                {8, 3, 1}
        };

        int[][] tabuleiroOrganizado = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        };

        EstadoTabuleiro estadoInicial = new EstadoTabuleiro(tabuleiroInicial, null);
        EstadoTabuleiro estadoIdeal = new EstadoTabuleiro(tabuleiroOrganizado, null);

        List<EstadoTabuleiro> caminho = buscarSolucaoMaisRapida(estadoInicial, estadoIdeal);
        if (caminho != null) {
            int movimentos = 0;
            for (EstadoTabuleiro estadoTabuleiro : caminho) {
                estadoTabuleiro.imprimirTabuleiro();
                System.out.println();
                movimentos++;
            }

            System.out.println("Quantidade de Movimentos: " + movimentos);
        } else {
            System.out.println("Solução não encontrada.");
        }
    }

    public static List<EstadoTabuleiro> buscarSolucaoMaisRapida(EstadoTabuleiro tabuleiroInicial, EstadoTabuleiro tabuleiroIdeal) {
        PriorityQueue<EstadoTabuleiro> openSet = new PriorityQueue<>(Comparator.comparingInt(s -> s.f));
        Map<EstadoTabuleiro, EstadoTabuleiro> historicoMovimentos = new HashMap<>();
        Map<EstadoTabuleiro, Integer> custo = new HashMap<>();

        openSet.add(tabuleiroInicial);
        historicoMovimentos.put(tabuleiroInicial, null);
        custo.put(tabuleiroInicial, 0);

        while (!openSet.isEmpty()) {
            EstadoTabuleiro atual = openSet.poll();

            if (atual.isIdeal(tabuleiroIdeal.tabuleiro)) {
                return reconstruirCaminho(historicoMovimentos, atual);
            }

            for (EstadoTabuleiro vizinho : atual.obterVizinhos()) {
                int novoCusto = custo.get(atual) + 1; // supõe-se que o custo de cada movimento é 1
                if (!custo.containsKey(vizinho) || novoCusto < custo.get(vizinho)) {
                    custo.put(vizinho, novoCusto);
                    openSet.add(vizinho);
                    historicoMovimentos.put(vizinho, atual);
                }
            }
        }
        return null; // Não foi possível encontrar um caminho
    }

    public static List<EstadoTabuleiro> reconstruirCaminho(Map<EstadoTabuleiro, EstadoTabuleiro> estadoAnterior, EstadoTabuleiro tabuleiroAtual) {
        List<EstadoTabuleiro> caminho = new ArrayList<>();
        while (tabuleiroAtual != null) {
            caminho.add(tabuleiroAtual);
            tabuleiroAtual = estadoAnterior.get(tabuleiroAtual);
        }
        Collections.reverse(caminho);
        return caminho;
    }

}
