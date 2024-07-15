import java.util.*;


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


public class Q872LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2){
        List<Integer> leafv1 = new ArrayList<>();
        List<Integer> leafv2 = new ArrayList<>();
        leafNode(root1, leafv1);
        leafNode(root2, leafv2);

        return leafv1.equals(leafv2);
    }

    public void leafNode(TreeNode root, List<Integer> arr){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            arr.add(root.val);
        }
        leafNode(root.left, arr);
        leafNode(root.right, arr);
    }
    
    public static void main(String[] args){
        Q872LeafSimilarTrees s = new Q872LeafSimilarTrees();

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);
        
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);

        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(2);
        root2.left.right.left = new TreeNode(7);
        root2.left.right.right = new TreeNode(4);
        
        System.out.println(s.leafSimilar(root1, root2)); // true
    }
}
