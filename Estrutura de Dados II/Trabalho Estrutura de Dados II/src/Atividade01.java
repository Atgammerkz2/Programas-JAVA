import java.util.Scanner;
import tree_utils.*;

public class Atividade01 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Informe o valor do nó raiz: ");
        TreeNode root = new TreeNode(s.nextInt(), null);
        System.out.println("\n    " + root.value);
        System.out.println("   / \\");

        System.out.print("Informe o valor do nó esquerdo: ");
        root.left = new TreeNode(s.nextInt(), root);
        System.out.print("Informe o valor do nó direito: ");
        root.right = new TreeNode(s.nextInt(), root);

        System.out.println("\n    " + root.value);
        System.out.println("   / \\");
        System.out.printf("  %d   %d\n", root.left.value, root.right.value);
        System.out.println(" / \\");

        System.out.print("Informe o valor do nó esquerdo: ");
        root.left.left = new TreeNode(s.nextInt(), root.left);
        System.out.print("Informe o valor do nó direito: ");
        root.left.right = new TreeNode(s.nextInt(), root.left);

        System.out.println("\n    " + root.value);
        System.out.println("   / \\");
        System.out.printf("  %d   %d\n", root.left.value, root.right.value);
        System.out.println(" / \\ / \\");
        System.out.printf("%d  %d     \n", root.left.left.value, root.left.right.value);

        System.out.print("Informe o valor do nó esquerdo: ");
        root.right.left = new TreeNode(s.nextInt(), root.right);
        System.out.print("Informe o valor do nó direito: ");
        root.right.right = new TreeNode(s.nextInt(), root.right);

        int height = BinaryTreeHeight.calculateHeight(root);

        // Imprimindo o resultado
        System.out.println("\nÁrvore Binária:");
        System.out.println("    " + root.value);
        System.out.println("   / \\");
        System.out.printf("  %d   %d\n", root.left.value, root.right.value);
        System.out.println(" / \\ / \\");
        System.out.printf("%d  %d %d  %d\n", root.left.left.value, root.left.right.value, root.right.left.value, root.right.right.value);
        System.out.println("\nAltura da árvore binária: " + height);
    }
}
