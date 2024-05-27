/*
* Aluno: Michael Marinho da Silva
* Turma: Engenharia de Software - 4º Período
* */

import estruturas.Aresta;
import estruturas.Dijkstra;
import estruturas.Grafo;
import estruturas.Vertice;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Grafo grafo = new Grafo();

        System.out.println("A cidade de origem é Goiânia!");
        grafo.addVertice(new Vertice("Goiânia"));

        System.out.println("Por favor informe o nome de mais 9 cidades:");
        for (int i = 0; i < 9; i++) {
            System.out.print("Cidade " + (i + 1) + ": ");
            String nomeCidade = scanner.nextLine();
            grafo.addVertice(new Vertice(nomeCidade));
        }

        System.out.println("Informe as conexões entre as cidades!");
        while (true) {
            scanner = new Scanner(System.in);
            System.out.print("Informe uma cidade: ");
            String cidade1 = scanner.nextLine();

            System.out.print("Informe a cidade que ela tem conexão: ");
            String cidade2 = scanner.nextLine();

            System.out.print("Informe a distância entre elas (KM): ");
            int distancia = scanner.nextInt();

            Vertice v1 = grafo.getVertice(cidade1);
            Vertice v2 = grafo.getVertice(cidade2);

            if (v1 != null && v2 != null) {
                v1.addAresta(new Aresta(v2, distancia));
                v2.addAresta(new Aresta(v1, distancia)); // Supondo que a conexão é bidirecional
            } else {
                System.out.println("Cidades não encontradas! Tente novamente.");
                continue;
            }

            System.out.print("Deseja informar outra conexão? (Sim/Não) ");
            String input = scanner.next();
            if (input.toLowerCase().replace("ã", "a").equals("nao")) {
                break;
            }
        }

        Vertice origem = grafo.getVertice("Goiânia");

        System.out.print("Informe a cidade de destino: ");
        scanner = new Scanner(System.in);
        String destinoNome = scanner.nextLine();
        Vertice destino = grafo.getVertice(destinoNome);

        if (destino != null) {
            Dijkstra dijkstra = new Dijkstra();
            List<Vertice> caminho = dijkstra.encontrarMenorCaminhoDijkstra(grafo, origem, destino);

            System.out.println("Menor caminho de Goiânia para " + destinoNome + ": ");
            StringBuilder sb = new StringBuilder();
            int distanciaTotal = 0;
            for (Vertice v : caminho) {
                sb.append(v.getNome() + " > ");
                distanciaTotal = v.getDistancia();
            }
            String msg = sb.substring(0, sb.length() - 2);
            System.out.println(msg);
            System.out.println("Distância: " + distanciaTotal);
        } else {
            System.out.println("Cidade de destino não encontrada!");
        }

        scanner.close();
    }
}

