
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BST {

    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        BST bst = new BST();
        TreeNode result = bst.searchBST(root, 2);
        System.out.println("Value found: " + (result == null? "Not found" : result.val));
        result = bst.searchBST(root, 5);
        System.out.println("Value found: " + (result == null? "Not found" : result.val));
        result = bst.searchBST(null, 5);
        System.out.println("Value found: " + (result == null? "Not found" : result.val));
    }
}
