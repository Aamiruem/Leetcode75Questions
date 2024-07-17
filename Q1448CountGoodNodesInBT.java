//BT=> BINARY TREE

// Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

/* 
 *         
 *              3
               / \
              1   4
             /   / \
            3   1   5

 * 
 *
 * 
*/



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

public class Q1448CountGoodNodesInBT {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    public int dfs(TreeNode curr, int maxVal) {
        if (curr == null) {
            return 0;
        }

        int res = 0;
        if (curr.val >= maxVal) {
            res = 1;
            maxVal = curr.val;
        }
        res += dfs(curr.left, maxVal);
        res += dfs(curr.right, maxVal);
        return res;
    }

    public static void main(String[] args) {
        Q1448CountGoodNodesInBT obj = new Q1448CountGoodNodesInBT();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(obj.goodNodes(root));  // Expected output: 4
    }
}
// Time Complexity: O(n) where n is the number of nodes in the binary tree.
// Space Complexity: O(n) where n is the number of nodes in the binary tree.













// public class Q1448CountGoodNodesInBT {
// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     int count;
//     public int goodNodes(TreeNode root) {
//         if(root==null) return 0;
//         PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
//         pq.add(root.val);
//         count=0;
//         dfs(root,pq);
//         return count;
//     }
//     public void dfs(TreeNode root,PriorityQueue<Integer> pq){
//         if (root == null) return;

//     if (root.val >= pq.peek()) {
//         count++;
//     }

//     pq.add(root.val);
//     dfs(root.left, pq);
//     dfs(root.right, pq);
//     pq.remove(root.val);
//     }
// }












//  Definition for a binary tree node.
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

// public class Q1448CountGoodNodesInBT {
//     public int goodNodes(TreeNode root) {
//         int maxValue = -10001;

//         return dfs(root, maxValue);
//     }

//     public int dfs(TreeNode curr, int maxVal) {
//         // Base case
//         if (curr == null) {
//             return 0;
//         }

//         // Conditions
//         if (curr.val >= maxVal) {
//             int left = dfs(curr.left, curr.val);
//             int right = dfs(curr.right, curr.val);
//             return 1 + left + right;
//         } else {
//             int left = dfs(curr.left, maxVal);
//             int right = dfs(curr.right, maxVal);
//             return left + right;
//         }
//     }

//     public static void main(String[] args) {
//         Q1448CountGoodNodesInBT obj = new Q1448CountGoodNodesInBT();
//         TreeNode root = new TreeNode(3);
//         root.left = new TreeNode(1);
//         root.right = new TreeNode(4);
//         root.right.left = new TreeNode(3);
//         root.right.right = new TreeNode(1);
//             root.right.right.right = new TreeNode(5);
//         System.out.println(obj.goodNodes(root));


//     }
// }
