package listas_encadeadas;

public class ListaDuplamenteEncadeada implements IListaEncadeada {
    NodeDuplo primeiro;
    NodeDuplo ultimo;

    public void inserirElemento(int dado) {
        NodeDuplo novoNode = new NodeDuplo(dado);
        if (primeiro == null) {
            primeiro = novoNode;
            ultimo = novoNode;
        } else {
            novoNode.anterior = ultimo;
            ultimo.proximo = novoNode;
            ultimo = novoNode;
        }
    }

    public void apagarElemento(int posicao) {
        if (posicao < 0) {
            System.out.println("Posição inválida.");
            return;
        }
        if (posicao == 0) {
            if (primeiro != null) {
                primeiro = primeiro.proximo;
                if (primeiro != null) {
                    primeiro.anterior = null;
                } else {
                    ultimo = null;
                }
                return;
            }
        }

        NodeDuplo atual = primeiro;
        int indice = 0;

        while (atual != null && indice < posicao) {
            atual = atual.proximo;
            indice++;
        }

        if (atual == null) {
            System.out.println("Posição não encontrada.");
            return;
        }

        if (atual.proximo != null) {
            atual.anterior.proximo = atual.proximo;
            atual.proximo.anterior = atual.anterior;
        } else {
            atual.anterior.proximo = null;
            ultimo = atual.anterior;
        }
    }

    public void exibirLista() {
        NodeDuplo atual = primeiro;
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }

        System.out.println();
    }
}

