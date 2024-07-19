import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

public class Q199BinaryTreeRightSideView {
  //1st way
    // List<Integer> ans = new ArrayList<>();
    // public void dfsRecursive(TreeNode node, int level){
    // if(ans.size() == level) {
    // ans.add(node.val);
    // }
    // if(node.right!=null) dfsRecursive(node.right, level+1);
    // if(node.left!=null) dfsRecursive(node.left, level+1);

    // }
    // public List<Integer> rightSideView(TreeNode root) {
    // if(root == null){
    // return ans;
    // }

    // dfsRecursive(root, 0);
    // return ans;
    // }
    // }

    //2nd way
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();

            List<Integer> values = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                values.add(node.val);
            }
            result.add(values.get(values.size() - 1));
        }
        return result;
    }

    public static void main(String[] args) {

        Q199BinaryTreeRightSideView obj = new Q199BinaryTreeRightSideView();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        System.out.println(obj.rightSideView(root));
    }
}
