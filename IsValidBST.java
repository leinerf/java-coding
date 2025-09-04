import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class IsValidBST {
    public static boolean isValidBST(TreeNode root){
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public static void main(String[] args) {
        System.out.println(isValidBST(TreeNode.builder(new Integer[]{2,1,3})) == true);
        System.out.println(isValidBST(TreeNode.builder(new Integer[]{2,4,3})) == false);
    }
    private static boolean valid(TreeNode root, long left, long right){
        if(root == null){
            return true;
        }
        if(!(left < root.val && root.val < right)){
            return false;
        }
        return valid(root.left, left, root.val) && valid(root.right, root.val, right);
    }
}

