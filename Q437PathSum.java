import java.util.HashMap;
import java.util.Map;

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

public class Q437PathSum {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);  // Initialize with sum 0 having one count
        return dfs(root, targetSum, map, 0L);
    }

    private int dfs(TreeNode root, int targetSum, Map<Long, Integer> map, long sum) {
        if (root == null) {
            return 0;
        }

        sum += root.val;
        int count = map.getOrDefault(sum - targetSum, 0);

        map.put(sum, map.getOrDefault(sum, 0) + 1);

        count += dfs(root.left, targetSum, map, sum);
        count += dfs(root.right, targetSum, map, sum);

        map.put(sum, map.get(sum) - 1);  // Backtrack

        return count;
    }

    public static void main(String[] args) {
        Q437PathSum obj = new Q437PathSum();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        int targetSum = 8;
        System.out.println(obj.pathSum(root, targetSum));  // Expected output: 3
    }
}













// class TreeNode{
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode(){

//     }
//     TreeNode(int val){
//         this.val = val;
//     }
//     TreeNode(int val, TreeNode left, TreeNode right){
//         this.val = val;
//         this.left = left ;
//         this.right = right;
//     }
// }

// public class Q437PathSum {
//     int counter = 0;
//     public int pathSum(TreeNode root, int sum) {

//         if (root == null) return 0;

//         pathSumHelper(root, sum, 0);
//         pathSum(root.left, sum);
//         pathSum(root.right, sum);

//         return counter;

//     }

//     void pathSumHelper(TreeNode root, int sum, int currentSum) {
//         if (root == null) {
//             return;
//         }
//         currentSum += root.val;
//         if (currentSum == sum) {
//             counter++;
//         }
//         pathSumHelper(root.left, sum, currentSum);
//         pathSumHelper(root.right, sum, currentSum);
//     } 
//     public static void main(String[] args) {

//         Q437PathSum obj = new Q437PathSum();

//         TreeNode root = new TreeNode(10);
//         root.left = new TreeNode(5);
//         root.right = new TreeNode(-3);
//         root.left.left = new TreeNode(3);
//         root.left.right = new TreeNode(2);
//         root.right.left = new TreeNode(1);
//         root.left.left.left = new TreeNode(11);
//         int sum = 8;
//         System.out.println(obj.pathSum(root, sum)); // Output: 3
//     }
// }
