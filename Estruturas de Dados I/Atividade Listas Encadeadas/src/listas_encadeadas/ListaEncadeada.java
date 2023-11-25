package listas_encadeadas;

public class ListaEncadeada implements IListaEncadeada {
    NodeSimples primeiro;

    public void inserirElemento(int dado){
        NodeSimples node = new NodeSimples(dado);

        if(primeiro == null){
            primeiro = node;
        } else {
            NodeSimples current = primeiro;

            while (current.proximo != null){
                current = current.proximo;
            }

            current.proximo = node;
        }
    }

    public void exibirLista() {
        NodeSimples atual = primeiro;
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }

        System.out.println();
    }

    public void apagarElemento(int posicao){
        if (posicao < 0) {
            System.out.println("Posição inválida.");
            return;
        }

        if (posicao == 0) {
            if (primeiro != null) {
                primeiro = primeiro.proximo;
            }
        }

        NodeSimples atual = primeiro;
        int indice = 0;

        while (atual != null && indice < posicao - 1) {
            atual = atual.proximo;
            indice++;
        }

        if (atual.proximo == null) {
            System.out.println("Posição não encontrada.");
            return;
        }

        if (atual.proximo.proximo != null) {
            atual.proximo = atual.proximo.proximo;
        } else {
            atual.proximo = null;
        }
    }
}
