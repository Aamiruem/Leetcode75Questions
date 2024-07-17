// import java.util.HashMap;
// import java.util.Map;

// class TreeNode {
//     int val;
//     TreeNode left, right;

//     TreeNode() {
//     }

//     TreeNode(int val) {
//         this.val = val;
//         left = right = null;
//     }

//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

// public class Q1372LOngestZigZagPathInBT {

//     int MAX = 0;
//     Map<TreeNode, int[]> dp;

//     public int longestZigZag(TreeNode root) {
//         dp = new HashMap<>();
//         dfs(root);
//         return MAX;
//     }

//     // returns max length from here if you go in a particular direction
//     private void dfs(TreeNode root) {
//         if (root == null)
//             return;

//         if (root.left == null && root.right == null) {
//             dp.put(root, new int[]{0, 0});
//             return;
//         }

//         // In dp value int []
//         // index 0 represents left direction
//         // index 1 represents right direction
//         dfs(root.left);
//         dfs(root.right);

//         int left = 0, right = 0;

//         if (dp.get(root.left) != null)
//             left = 1 + dp.get(root.left)[1]; // we go right after left

//         if (dp.get(root.right) != null)
//             right = 1 + dp.get(root.right)[0]; // we go left after right

//         dp.put(root, new int[]{left, right});
//         MAX = Math.max(MAX, Math.max(left, right));
//     }

//     public static void main(String[] args) {
//         TreeNode root = new TreeNode(1);
//         root.left = new TreeNode(1);
//         root.right = new TreeNode(1);
//         root.left.left = new TreeNode(1);
//         root.left.right = new TreeNode(1);
//         root.right.left = new TreeNode(1);
//         root.right.right = new TreeNode(1);
//         Q1372LOngestZigZagPathInBT obj = new Q1372LOngestZigZagPathInBT();
//         System.out.println(obj.longestZigZag(root));  // Expected output: 3
//     }
// }










// import java.util.HashMap;
// import java.util.Map;

// class TreeNode {
//     int val;
//     TreeNode left, right;

//     TreeNode() {

//     }

//     TreeNode(int val) {
//         this.val = val;
//         left = right = null;
//     }

//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }

//     public class Q1372LOngestZigZagPathInBT {

//         int MAX;
//         Map<TreeNode, int[]> dp;

//         public int longestZigZag(TreeNode root) {

//             // postorder traversal
//             // Map stores left from node and right from node
//             dp = new HashMap<>();
//             dfs(root);
//             return MAX;
//         }

//         // returns max length from here if you go in a particular direction
//         private void dfs(TreeNode root) {
//             if (root == null)
//                 return;

//             if (root.left == null && root.right == null) {
//                 dp.put(root, new int[] { 0, 0 });
//                 return;
//             }
//             // In dp value int []
//             // index 0 represents left direction
//             // index 1 represents right direction
//             dfs(root.left);
//             dfs(root.right);

//             int left = 0, right = 0;

//             if (dp.get(root.left) != null)
//                 left = 1 + dp.get(root.left)[1]; // we go right after left

//             if (dp.get(root.right) != null)
//                 right = 1 + dp.get(root.right)[0]; // we go left after right
//             dp.put(root, new int[] { left, right });
//             MAX = Math.max(MAX, Math.max(left, right));
//         }
//     }

//     public static void main(String[] args) {
//         TreeNode root = new TreeNode(1);
//         root.left = new TreeNode(1);
//         root.right = new TreeNode(1);
//         root.left.left = new TreeNode(1);
//         root.left.right = new TreeNode(1);
//         root.right.left = new TreeNode(1);
//         root.right.right = new TreeNode(1);
//         // Q1372LOngestZigZagPathInBT obj = new Q1372LOngestZigZagPathInBT();
//         System.out.println(obj.longestZigZag(root)); // Expected output: 3
//     }
// }








import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Q1372LOngestZigZagPathInBT {

    private int MAX = 0;
    private Map<TreeNode, int[]> dp;

    public int longestZigZag(TreeNode root) {
        dp = new HashMap<>();
        dfs(root);
        return MAX;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            dp.put(root, new int[]{0, 0});
            return;
        }
        
        dfs(root.left);
        dfs(root.right);

        int left = 0;
        int right = 0;

        if (root.left != null && dp.containsKey(root.left))
            left = 1 + dp.get(root.left)[1]; // go right after left

        if (root.right != null && dp.containsKey(root.right))
            right = 1 + dp.get(root.right)[0]; // go left after right

        dp.put(root, new int[]{left, right});
        MAX = Math.max(MAX, Math.max(left, right));
    }
    
    public static void main(String[] args) {
        Q1372LOngestZigZagPathInBT solution = new Q1372LOngestZigZagPathInBT();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.right.right = new TreeNode(1);
        root.left.left.left = new TreeNode(1);


        System.out.println(solution.longestZigZag(root)); // Expected output: 3
    }
}
