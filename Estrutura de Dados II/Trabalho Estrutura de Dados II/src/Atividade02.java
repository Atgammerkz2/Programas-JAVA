import java.util.Scanner;
import tree_utils.*;

public class Atividade02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantityNodes, value;

        System.out.print("Quantos nós você gostaria que a árvore tenha? ");
        quantityNodes = scanner.nextInt();

        BinaryTree tree = new BinaryTree();

        for (int i = 1; i <= quantityNodes; i++) {
            System.out.print("Digite o valor para o nó " + i + ": ");
            value = scanner.nextInt();
            tree.insertSorted(value);
        }

        System.out.println("Árvore Binária Ordenada:");
        tree.printTree(tree.root, 0);

        int depth = 0;
        depth = tree.calculateDepth(tree.root, 0, depth);

        System.out.println("Profundidade da árvore: " + depth);
    }
}
