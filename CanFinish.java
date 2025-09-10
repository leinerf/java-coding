import java.util.ArrayList;
import java.util.HashMap;

public class CanFinish {
    boolean[] visited;
    HashMap<Integer, ArrayList<Integer>> graph;
    public boolean canFinish(int numCourses, int[][] prerequisites){
        visited = new boolean[numCourses];
        graph = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            graph.get(course).add(prereq);
        }

        for(int i = 0; i < prerequisites.length; i++){
            if(!dfsValid(i)){
                return false;
            }
        }
        return true;
    }

    private boolean dfsValid(int i){
        if(visited[i]){
            return false;
        }
        visited[i] = true;
        ArrayList<Integer> prereqs = graph.get(i);
        for(int j = 0; j < prereqs.size(); j++){
            if(!dfsValid(prereqs.get(j))){
                visited[i] = false;
                return false;
            }
        }

        visited[i] = false;
        return true;
    }

    public static void main(String[] args) {
        CanFinish sol = new CanFinish();
        System.out.println(sol.canFinish(2, new int[][]{ new int[]{0,1}}) == true);
        System.out.println(sol.canFinish(2, new int[][]{new int[]{0, 1}, new int[]{1, 0}}) == false);
    }
}