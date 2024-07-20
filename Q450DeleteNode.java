
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

// public class Q450DeleteNode {

//     public TreeNode deleteNode(TreeNode root, int key) {
//         if (root == null) {
//             return null;
//         }

//         if (root.val == key && (root.right == null && root.left == null)) {
//             root = null;
//             return root;
//         }

//         if (root.val < key) // go to right 
//         {
//             root.right = deleteNode(root.right, key);
//         } else if (root.val > key) // go to left 
//         {
//             root.left = deleteNode(root.left, key);
//         } else {  // equal val  ----> 3 case l null r null or both are non null
//             if (root.right == null) {
//                 return root.left;
//             }
//             if (root.right == null) {
//                 return root.left;
//             } else {
//                 root.val = minHelper(root.right);
//                 root.right = deleteNode(root.right, root.val);
//             }
//         }

//         return root;
//     }

//     public int minHelper(TreeNode root) // go to extreme left and udate root 
//     {
//         int min = root.val;
//         if (root == null) {
//             return min;
//         }
//         while (root.left != null) {
//             min = root.left.val;
//             root = root.left;
//         }
//         return min;
//     }

//     public static void main(String[] args) {
//         TreeNode root = new TreeNode(5);
//         root.left = new TreeNode(3);
//         root.right = new TreeNode(6);
//         root.left.left = new TreeNode(2);
//         root.left.right = new TreeNode(4);
//         root.right.right = new TreeNode(7);
//         Q450DeleteNode q = new Q450DeleteNode();
//         root = q.deleteNode(root, 3);
//         System.out.println(root); // expected output: 5 6 7
//         // or 5 4 6 7 if we delete 2
//         // or 5 3 4 6 7 if we delete 6

//     }
// }













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

public class Q450DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            // root.val == key
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // Node with two children
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        }
        return root;
    }

    public TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        
        Q450DeleteNode q = new Q450DeleteNode();
        root = q.deleteNode(root, 3);
        printInOrder(root); // expected output: 2 4 5 6 7
    }

    // Helper method to print the tree in order
    public static void printInOrder(TreeNode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.val + " ");
            printInOrder(root.right);
        }
    }
}
