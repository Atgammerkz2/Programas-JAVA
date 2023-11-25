package listas_encadeadas;

class NodeDuplo {
    int dado;
    NodeDuplo anterior;
    NodeDuplo proximo;

    public NodeDuplo(int data) {
        this.dado = data;
        this.anterior = null;
        this.proximo = null;
    }
}