import java.util.ArrayList;

public class Node {
    public Integer val;
    public ArrayList<Node> neighbors;
    public Node(){
        this(null, new ArrayList<Node>());
    }
    public Node(Integer val){
        this(val, new ArrayList<Node>());
    }
    public Node(Integer val, ArrayList<Node> neighbors){
        this.val = val;
        this.neighbors = neighbors;
    }
    public void addNeighbor(Node node){
        this.neighbors.add(node);
    }
}