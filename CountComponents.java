import java.util.HashMap;
import java.util.ArrayList;

public class CountComponents {
    HashMap<Integer, ArrayList<Integer>> nodeToEdges;
    boolean[] visited;
    
    public int countComponents(int n, int[][] edges){
        visited = new boolean[n];
        nodeToEdges = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i < n; i++){
            nodeToEdges.put(i, new ArrayList<>());
        }
        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
            nodeToEdges.get(a).add(b);
            nodeToEdges.get(b).add(a);
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            if(visited[i]){
                continue;
            }
            dfs(i);
            count++;
        }
        return count;
    }

    private void dfs(int n){
        if(visited[n]){
            return;
        }
        visited[n] = true;
        ArrayList<Integer> edges = nodeToEdges.get(n);
        for(int i = 0; i < edges.size(); i++){
            dfs(edges.get(i));
        }
    }

    public static void main(String[] args) {
        CountComponents sol = new CountComponents();
        int[][] edges = new int[][]{
            new int[]{0,1},
            new int[]{1,2},
            new int[]{2,3},
            new int[]{4,5}
        };

        System.out.println(sol.countComponents(6, edges) == 2);
    }
}