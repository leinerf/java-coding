import java.util.Arrays;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;

public class MaxDepth {
    public static int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    public static void main(String[] args) {
        ArrayList<Integer> intArray = new ArrayList<Integer>(Arrays.asList(1,2,3,null,null,4,5));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(0);
        
        queue.add(root);
        
        int i = 0;
        while(i < intArray.size()){
            TreeNode node = queue.remove();
            Integer left = null, right = null;

            left = intArray.get(i);
            if(i + 1 < intArray.size()){
                right = intArray.get(i + 1);
            }
            
            if(left != null){
                node.left = new TreeNode(left);
                queue.add(node.left);
            }
            if(right != null){
                node.right = new TreeNode(right);
                queue.add(node.right);
            }
            i += 2;
        }
        System.out.println(maxDepth(root) == 4);
    }
}

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
}