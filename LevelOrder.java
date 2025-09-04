import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class LevelOrder {
    public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>(Arrays.asList(root));

        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> values = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.remove();
                values.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(values);
        }
        return res;
    }
    public static void main(String[] args) {
        List<List<Integer>> target = new ArrayList<>();
        target.add(new ArrayList<>(Arrays.asList(0)));
        target.add(new ArrayList<>(Arrays.asList(1,2)));
        target.add(new ArrayList<>(Arrays.asList(3,4,5,6)));
        
        List<List<Integer>> res = levelOrder(TreeNode.builder(new Integer[]{0,1,2,3,4,5,6}));
        
        System.out.println(target.equals(res));
    }
}
