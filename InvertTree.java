import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {
    public static TreeNode invertTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            
            if(node.left != null){
                queue.add(node.left);
            }

            if(node.right != null){
                queue.add(node.right);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 1;
        TreeNode head = new TreeNode(0);
        queue.add(head);
        while(count < 7){
            TreeNode node = queue.remove();
            node.left = new TreeNode(count);
            node.right = new TreeNode(count + 1);
            queue.add(node.left);
            queue.add(node.right);
            count = count + 2;
        }

        queue = new LinkedList<>();
        
        queue.add(head);
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            System.out.println(temp.val);
            if(temp.left != null){
                queue.add(temp.left);
            }

            if(temp.right != null){
                queue.add(temp.right);
            }
        }
        
        invertTree(head);
        
        queue.add(head);
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            System.out.println(temp.val);
            if(temp.left != null){
                queue.add(temp.left);
            }

            if(temp.right != null){
                queue.add(temp.right);
            }
        }
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