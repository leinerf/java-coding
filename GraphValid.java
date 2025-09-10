import java.util.HashMap;

public class GraphValid {
    HashMap<Integer, Integer> childParent;
    HashMap<Integer, Integer> rank;
    public boolean validTree(int n, int[][] edges){
        int maxRank = 0;
        rank = new HashMap<>();
        childParent = new HashMap<>();

        for(int i = 0; i < n; i++){
            rank.put(i, 1);
            childParent.put(i, i);
        }

        for(int[] edge: edges){
            int a = getParent(edge[0]);
            int b = getParent(edge[1]);
            if(a == b){
                return false;
            }
            if(rank.get(a) >= b){
                childParent.put(b, a);
                rank.put(a, rank.get(a) + rank.get(b));
                maxRank = Math.max(maxRank, rank.get(a));
            } else {
                childParent.put(a, b);
                rank.put(b, rank.get(b) + rank.get(a));
                maxRank = Math.max(maxRank, rank.get(b));
            }
        }
        return maxRank == n;
    }

    private int getParent(int edge){
        while(edge != childParent.get(edge)){
            int nw = childParent.get(edge);
            childParent.put(edge, childParent.get(nw));
            edge = nw;
        }
        return edge;
    }

    public static void main(String[] args) {
        GraphValid sol = new GraphValid();
        int[][] validEdges = new int[][]{
            new int[]{0, 1},
            new int[]{0, 2},
            new int[]{0, 3},
            new int[]{1, 4}
        };
        int[][] invalidEdges = new int[][]{
            new int[]{0, 1},
            new int[]{1, 2},
            new int[]{2, 3},
            new int[]{1, 3},
            new int[]{1, 4}
        };

        System.out.println(sol.validTree(5, validEdges) == true);
        System.out.println(sol.validTree(5, invalidEdges) == false);

    }
}
