import java.util.ArrayList;

public class KthSmallest {
    public static int kthSmallest(TreeNode root, int k){
        ArrayList<Integer> arr = new ArrayList<>();
        findKthSmallest(root, arr);
        return arr.get(k - 1);
    }

    private static void findKthSmallest(TreeNode root, ArrayList<Integer> arr){
        if(root == null){
            return;
        }
        findKthSmallest(root.left, arr);
        arr.add(root.val);
        findKthSmallest(root.right, arr);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.builder(new Integer[]{2,1,3});
        System.out.println(kthSmallest(root, 2));
    }
}
