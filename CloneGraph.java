import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CloneGraph {
    HashMap<Integer, Node> copies;
    public Node cloneGraph(Node node) {
        copies = new HashMap<>();
        dfs(node);
        return copies.get(1);
    }

    private void dfs(Node node){
        if(copies.containsKey(node.val)){
            return;
        }
        Node copy = new Node(node.val);
        copies.put(node.val, copy);

        for(int i = 0; i < node.neighbors.size(); i++){
            Node neighbor = node.neighbors.get(i);
            if(!copies.containsKey(neighbor.val)){
                dfs(neighbor);
            }
            copy.neighbors.add(copies.get(neighbor.val));
        }
    }
    public static void main(String[] args) {
        HashMap<Integer, Node> nm = new HashMap<>();
        ArrayList<ArrayList<Integer>> nodeNeighbors = new ArrayList<>(
            Arrays.asList(
                new ArrayList<>(Arrays.asList(2)),
                new ArrayList<>(Arrays.asList(1,3)),
                new ArrayList<>(Arrays.asList(2))
            )
        );

        for(int i = 0; i < nodeNeighbors.size(); i++){
            Node node = new Node(i + 1);
            nm.put(node.val, node);
        }

        for(int i = 0; i < nodeNeighbors.size(); i++){
            Node node = nm.get(i + 1);
            ArrayList<Integer> neighbors = nodeNeighbors.get(i);
            for(int j = 0; j < neighbors.size(); j++){
                node.addNeighbor(nm.get(neighbors.get(j)));
            }
        }
        CloneGraph sol = new CloneGraph();
        Node old = nm.get(1);
        List<List<Integer>> oldNeighbors = new ArrayList<>();
        sol.getNeighbors(old, oldNeighbors, new HashSet<>());
        Node nw = sol.cloneGraph(old);
        List<List<Integer>> nwNeighbors = new ArrayList<>();
        sol.getNeighbors(nw, nwNeighbors, new HashSet<>());
        System.out.println(oldNeighbors.toString());
        System.out.println(nwNeighbors.toString());
        

    }

    public void getNeighbors(Node node, List<List<Integer>> res, HashSet<Integer> visited){
        if(visited.contains(node.val)){
            return;
        }
        ArrayList<Integer> neighbors = new ArrayList<>();        
        visited.add(node.val);
        for(int i = 0; i < node.neighbors.size(); i++){
            Node neighbor = node.neighbors.get(i); 
            neighbors.add(neighbor.val);
            getNeighbors(neighbor, res, visited);
        }
        res.add(neighbors);
    }
}
