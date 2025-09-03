import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsSameTree {
    public static boolean isSameTree(TreeNode q, TreeNode p){
        Queue<TreeNode> qq  = new LinkedList<>(Arrays.asList(q));
        Queue<TreeNode> pq = new LinkedList<>(Arrays.asList(p));

        while(!qq.isEmpty()){
            TreeNode qn = qq.poll(), pn = pq.poll();
            if(qn == null && pn == null){
                continue;
            } else if(qn == null || pn == null){
                return false;
            } else if(qn.val != pn.val){
                return false;
            }
            qq.add(qn.left); qq.add(qn.right);
            pq.add(pn.left); pq.add(pn.right);
        }
        return true;
    }
    public static void main(String[] args) {
        TreeNode p = TreeNode.createTree(new Integer[]{4,7});
        TreeNode q = TreeNode.createTree(new Integer[]{4,null,7});
        TreeNode a = TreeNode.createTree(new Integer[]{1,2,3});
        TreeNode b = TreeNode.createTree(new Integer[]{1,2,3});
        System.out.println(isSameTree(q, p) == false);
        System.out.println(isSameTree(a, b) == true);

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
    public static TreeNode createTree(Integer[] nums){
        if(nums.length == 0){
            return null;
        }

        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

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
