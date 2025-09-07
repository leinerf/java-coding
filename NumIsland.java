public class NumIsland {
    int rowSize;
    int colSize;
    char[][] grid;
    boolean[][] visited;
    
    public int numIslands(char[][] grid) {
        this.grid = grid;
        rowSize = grid.length;
        colSize = grid[0].length;
        visited = new boolean[rowSize][colSize];
        int count = 0;
        for(int i = 0; i < rowSize; i++){
            for(int j = 0; j < colSize; j++){
                if(visited[i][j]){
                    continue;
                } else if(grid[i][j] == '0'){
                    visited[i][j] = true;
                    continue;
                } else {
                    count++;
                    dfs(i, j);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j){
        if(i < 0 || i >= rowSize || j < 0 || j >= colSize){
            return;
        } else if(visited[i][j]){
            return;
        }
        visited[i][j] = true;
        if(grid[i][j] == '0'){
            return;
        }
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }
    public static void main(String[] args) {
        char[][] grid = new char[][]{
            new char[]{'0','1','0','1','1'},
            new char[]{'0','1','0','1','0'},
            new char[]{'1','1','0','0','1'},
            new char[]{'0','0','0','1','0'}
        };
        NumIsland sol = new NumIsland();
        System.out.println(sol.numIslands(grid) == 4);
    }
}