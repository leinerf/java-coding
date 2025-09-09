import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlantic{
    public int rowSize;
    public int colSize;
    public int[][] heights;
    public boolean[][] visited;
    public boolean[][] pacific;
    public boolean[][] atlantic;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        rowSize = heights.length;
        colSize = heights[0].length;
        this.heights = heights;
        visited = new boolean[rowSize][colSize];
        pacific = new boolean[rowSize][colSize];
        atlantic = new boolean[rowSize][colSize];

        for(int i = 0; i < rowSize; i++){
            for(int j = 0; j < colSize; j++){
                dfsAtlantic(i, j, heights[i][j]);
                dfsPacific(i, j, heights[i][j]);
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(new ArrayList<Integer>(Arrays.asList(i, j)));
                }
            }
        }

        return res;
    }
    private boolean dfsPacific(int i, int j, int prev){
        if(i < 0 || j < 0){
            return true;
        } else if(i >= rowSize || j >= colSize){
            return false;
        } else if(visited[i][j]) {
            return false;
        } else if(heights[i][j] > prev){
            return false;
        } else if(pacific[i][j]){
            return true;
        } else {
            visited[i][j] = true;
            prev = heights[i][j];
            pacific[i][j] =
                dfsPacific(i + 1, j, prev) ||
                dfsPacific(i - 1, j, prev) ||
                dfsPacific(i, j + 1, prev) ||
                dfsPacific(i, j - 1, prev);
            visited[i][j] = false;
            return pacific[i][j];
        }
    }
    private boolean dfsAtlantic(int i, int j, int prev){
        if(i >= rowSize || j >= colSize){
            return true;
        } else if(i < 0 || j < 0){
            return false;
        } else if(heights[i][j] > prev){
            return false;
        } else if(visited[i][j]){
            return false;
        } else if(atlantic[i][j]){
            return true;
        } else {
            visited[i][j] = true;
            prev = heights[i][j];
            atlantic[i][j] = 
                dfsAtlantic(i + 1, j, prev) ||
                dfsAtlantic(i - 1, j, prev) ||
                dfsAtlantic(i, j + 1, prev) ||
                dfsAtlantic(i, j - 1, prev);
            visited[i][j] = false;
            return atlantic[i][j];
        }
    }
    public static void main(String[] args) {
        int[][] heights = new int[][]{
            new int[]{4,2,7,3,4},
            new int[]{7,4,6,4,7},
            new int[]{6,3,5,3,6}
        };
        PacificAtlantic sol = new PacificAtlantic();
        List<List<Integer>> target = new ArrayList<>(
            Arrays.asList(
                new ArrayList<>(Arrays.asList(0, 2)),
                new ArrayList<>(Arrays.asList(0, 4)),
                new ArrayList<>(Arrays.asList(1, 0)),
                new ArrayList<>(Arrays.asList(1, 1)),
                new ArrayList<>(Arrays.asList(1,2)),
                new ArrayList<>(Arrays.asList(1,3)),
                new ArrayList<>(Arrays.asList(1,4)),
                new ArrayList<>(Arrays.asList(2,0))
            )
        );
        System.out.println(sol.pacificAtlantic(heights).equals(target));
    }
}