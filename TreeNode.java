import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public static TreeNode builder(Integer[] nums){
        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>(Arrays.asList(root));
        for(int i = 1; i < nums.length; i += 2){
            TreeNode node = queue.remove();
            if(nums[i] != null){
                node.left = new TreeNode(nums[i]);
                queue.add(node.left);
            }

            if(i + 1 < nums.length && nums[i + 1] != null){
                node.right = new TreeNode(nums[i + 1]);
                queue.add(node.right);
            }
        }
        return root;
    }
}