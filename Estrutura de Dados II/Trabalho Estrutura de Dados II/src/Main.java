import java.util.Scanner;

public class Main {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args){
        while (true) {
            int opcao = criarMenu(new String[] {
                "Inserir nós na árvore binária",
                "Consultar nós da árvore binária",
                "Excluir nós da árvore binária",
                "Pesquisar valores na árvore binária"
            });

            switch (opcao){
                case -1:
                    return;
            }
        }
    }

    private static int criarMenu(String[] opcoes){
        int opcao = -1;
        while (opcao < 0 || opcao > opcoes.length + 1) {
            System.out.println("====== Selecione uma opção ======");

            int i;
            for (i = 0; i < opcoes.length; i++){
                System.out.println((i+1) + " - " + opcoes[i]);
            }
            System.out.println((i+1) + " - Sair");
            System.out.print("Informe a opção desejada: ");
            opcao = s.nextInt();

            if(opcao == i+1){
                return -1;
            } else if(opcao < 0 || opcao > opcoes.length + 1){
                System.out.println("\nOpção inválida!\n");
            }

            break;
        }

        return opcao;
    }
}
