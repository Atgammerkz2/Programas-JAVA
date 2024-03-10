package tree_utils;

public class BinaryTree {
    public TreeNode root;

    public void insertSorted(int value) {
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value, null);
            return root;
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else {
            root.right = insertRec(root.right, value);
        }

        if(root.left != null){
            root.left.parent = root;
        }
        if(root.right != null){
            root.right.parent = root;
        }

        return root;
    }

    public void printTree(TreeNode root, int level) {
        if (root != null) {
            printTree(root.right, level + 1);

            for (int i = 0; i < level; i++) {
                System.out.print("   ");
            }

            System.out.println(root.value);

            printTree(root.left, level + 1);
        }
    }

    public int calculateDepth(TreeNode root, int level, int depth) {
        if (root != null) {
            if (level > depth) {
                depth = level;
            }
            depth = calculateDepth(root.left, level + 1, depth);
            depth = calculateDepth(root.right, level + 1, depth);
        }
        return depth;
    }
}

