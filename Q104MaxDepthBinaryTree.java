class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){

    }
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left ;
        this.right = right;
    }
}

public class Q104MaxDepthBinaryTree {
    public int maxDepth(TreeNode root){
        if(root == null) {

            return 0;
        }
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return Math.max(left, right);
    }

    public static void main(String[] args) {

        Q104MaxDepthBinaryTree obj = new Q104MaxDepthBinaryTree();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(obj.maxDepth(root));
        // Expected output: 3
        // This is because the longest path from the root node down to the farthest leaf node is 3.
        // The path is 3 -> 9 -> 20 -> 15 ->7.
        // The code successfully finds the maximum depth of the binary tree.
        // Note: The code assumes that the binary tree is not empty and has at least one node. If the binary tree is empty, the method will return 0.
        // If the binary tree has only one node, the method will return 1.
        // Time complexity: O(n)
        // Space complexity: O(n)
    }
}
