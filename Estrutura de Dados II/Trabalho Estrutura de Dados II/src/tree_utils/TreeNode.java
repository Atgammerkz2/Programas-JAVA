package tree_utils;

public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;

    public TreeNode(int value, TreeNode parent) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = parent;
    }
}
