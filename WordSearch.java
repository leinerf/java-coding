import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class WordSearch {
    char[][] board;
    char[] word;
    int rowSize;
    int colSize;
    HashSet<ArrayList<Integer>> visited;
    public boolean exist(char[][] board, String word){
        this.board = board;
        rowSize = board.length;
        colSize = board[0].length;
        this.word = word.toCharArray();
        for(int i = 0; i < rowSize; i++){
            for(int j = 0; j < colSize; j++){
                visited = new HashSet<>();
                if(match(i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean match(int i, int j, int k){
        ArrayList<Integer> coord = new ArrayList<>(Arrays.asList(i, j));
        if(k >= word.length){
            return true;
        } else if(i < 0 || i >= rowSize || j < 0 || j >= colSize){
            return false;
        } else if(visited.contains(coord)){
            return false;
        } else if(board[i][j] != word[k]){
            return false;
        } else {
            visited.add(coord);
            boolean res = match(i - 1, j, k + 1) ||
                match(i + 1, j, k + 1) ||
                match(i, j - 1, k + 1) ||
                match(i, j + 1, k + 1);
            visited.remove(coord);
            return res;
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
            new char[]{'A','B','C','D'},
            new char[]{'S','A','A','T'},
            new char[]{'A','C','A','E'}
        };
        String word = "CAT";
        WordSearch ws = new WordSearch();
        System.out.println(ws.exist(board, word) == true);
    }
}
