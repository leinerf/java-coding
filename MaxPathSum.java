import java.lang.Integer;
import java.lang.Math;

public class MaxPathSum {
    static int max;
    public static int maxPathSum(TreeNode root){
        max = Integer.MIN_VALUE;
        maxPath(root);
        return max;
    }

    private static int maxPath(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = maxPath(root.left);
        left = left > 0 ? left : 0;
        int right = maxPath(root.right);
        right = right > 0 ? right : 0;

        max = Math.max(max, left + right + root.val);
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode test1 = TreeNode.builder(new Integer[]{-15,10,20,null,null,15,5,-5});
        TreeNode test2 = TreeNode.builder(new Integer[]{1,2,3});
        System.out.println(maxPathSum(test1) == 40);
        System.out.println(maxPathSum(test2) == 6);

    }
}
