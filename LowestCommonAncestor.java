import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;
import java.lang.Math;

public class LowestCommonAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || p == null || q == null){
            return null;
        }

        if(Math.max(p.val, q.val) < root.val){
            return lowestCommonAncestor(root.left, p, q);
        } else if(Math.min(p.val, q.val) > root.val){
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
    public static void main(String[] args) {
        TreeNode root = TreeNode.builder(new Integer[]{5,3,8,1,4,7,9,null,2});
        TreeNode p = new TreeNode(3);
        TreeNode q = new TreeNode(8);
        System.out.println(lowestCommonAncestor(root, p, q).val == 5);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public static TreeNode builder(Integer[] nums){
        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> q = new LinkedList<>(Arrays.asList(root));
        for(int i = 1; i < nums.length; i += 2){
            TreeNode node = q.remove();
            if(nums[i] != null){
                node.left = new TreeNode(nums[i]);
                q.add(node.left);
            }

            if(i + 1 < nums.length && nums[i + 1] != null){
                node.right = new TreeNode(nums[i + 1]);
                q.add(node.right);
            }
        }
        return root;
    }
}