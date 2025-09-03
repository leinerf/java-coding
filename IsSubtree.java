import java.util.LinkedList;
import java.util.Queue;

public class IsSubtree {
    public static boolean isSubtree(TreeNode root, TreeNode subRoot){
        if(subRoot == null){
            return true;
        }
        if(root == null){
            return false;
        }
        if(sameTree(root, subRoot)){
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    private static boolean sameTree(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }
        if(root != null && subRoot != null && root.val == subRoot.val){
            return sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right);
        }            
        return false;
    }
    public static void main(String[] args) {
        TreeNode root = TreeNode.builder(new Integer[]{1,2,3,4,5});
        TreeNode subRoot = TreeNode.builder(new Integer[]{2,4,5});
        System.out.println(isSubtree(root, subRoot) == true);
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
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

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