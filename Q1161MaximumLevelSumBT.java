 // import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.Queue;
// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {
//     }
//     TreeNode(int val) {
//         this.val = val;
//     }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }
// public class Q1161MaximumLevelSumBT {
//     public int maxLevelSum(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
//         q.add(null);
//         ArrayList<Integer> arr = new ArrayList<>();
//         int sum = 0;
//         while (!q.isEmpty()) {
//             TreeNode curr = q.remove();
//             if (curr == null) {
//                 arr.add(sum);
//                 sum = 0;
//                 if (q.isEmpty()) {
//                     break;
//                 } else {
//                     q.add(null);
//                 }
//             } else {
//                 sum += curr.val;
//                 if (curr.left != null) {
//                     q.add(curr.left);
//                 }
//                 if (curr.right != null) {
//                     q.add(curr.right);
//                 }
//             }
//         }
//         int idx = 0;
//         int s = Integer.MIN_VALUE;
//         for (int i = 0; i < arr.size(); i++) {
//             if (arr.get(i) > s) {
//                 idx = i + 1;
//                 s = arr.get(i);
//             }
//         }
//         return idx;
//     }
//     public static void main(String[] args) {
//         Q1161MaximumLevelSumBT obj = new Q1161MaximumLevelSumBT();
//         TreeNode root = new TreeNode(1);
//         root.left = new TreeNode(7);
//         root.right = new TreeNode(0);
//         root.left.left = new TreeNode(7);
//         root.right.right = new TreeNode(-8);
//         System.out.println(obj.maxLevelSum(root));
//         // Add more test cases to validate your solution
//         // Example:
//         TreeNode root1 = new TreeNode(1);
//         root1.left = new TreeNode(7);
//         root1.right = new TreeNode(0);
//         root1.left.left = new TreeNode(7);
//         root1.right.right = new TreeNode(-8);
//         System.out.println(obj.maxLevelSum(root)); // Output: 2
//     }
// }





import java.util.*;



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

public class Q1161MaximumLevelSumBT {

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 0;
        List<Integer> sumArr = new ArrayList<>();
        sumArr.add(root.val);
        sumOfLevel(queue, sumArr, level + 1);
        int result = -1;
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < sumArr.size(); i++) {
            if (sumArr.get(i) > sum) {
                sum = sumArr.get(i);
                result = i;
            }
        }
        return result + 1;
    }

    private void sumOfLevel(Queue<TreeNode> queue, List<Integer> sumArr, int level) {
        if (queue.isEmpty()) {
            return;
        }
        Queue<TreeNode> lowQueue = new ArrayDeque<>();
        int sum = 0;
        boolean allElementNull = true;
        while (!queue.isEmpty()) {
            TreeNode element = queue.poll();
            if (element.left != null) {
                allElementNull = false;
                sum += element.left.val;
                lowQueue.add(element.left);
            }
            if (element.right != null) {
                allElementNull = false;
                sum += element.right.val;
                lowQueue.add(element.right);
            }
        }
        if (allElementNull) {
            sumArr.add(Integer.MIN_VALUE);
        } else {
            sumArr.add(sum);
        }
        sumOfLevel(lowQueue, sumArr, level + 1);
    }
    public static void main(String[] args) {
        Q1161MaximumLevelSumBT obj = new Q1161MaximumLevelSumBT();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.right.right = new TreeNode(-8);
        System.out.println(obj.maxLevelSum(root));
        // Add more test cases to validate your solution
        
    }
}
