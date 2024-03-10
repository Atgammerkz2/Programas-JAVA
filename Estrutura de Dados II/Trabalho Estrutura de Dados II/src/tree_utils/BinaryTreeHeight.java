package tree_utils;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeHeight {

    public static int calculateHeight(TreeNode root) {
        if (root == null) {
            return 0;  // Se a árvore estiver vazia, a altura é 0.
        }

        int height = 0;  // Inicializa a altura como 0.
        Queue<TreeNode> queue = new LinkedList<>();  // Cria uma fila para percorrer os nós.
        queue.offer(root);  // Adiciona o nó raiz à fila.

        while (!queue.isEmpty()) {  // Enquanto a fila não estiver vazia.
            int levelSize = queue.size();  // Obtém o número de nós no nível atual.
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();  // Remove o nó da frente da fila.
                if (node.left != null) {
                    queue.offer(node.left);  // Adiciona o nó à esquerda à fila.
                }
                if (node.right != null) {
                    queue.offer(node.right);  // Adiciona o nó à direita à fila.
                }
            }
            height++;  // Incrementa a altura após processar um nível.
        }

        return height;  // Retorna a altura calculada.
    }
}
