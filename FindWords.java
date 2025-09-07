import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;

public class FindWords {
    TrieNode root;
    char[][] board;
    boolean[][] visited;
    int rowSize;
    int colSize;
    
    public List<String> findWords(char[][] board, String[] words){
        HashSet<String> wordSet = new HashSet<>();
        this.board = board;
        rowSize = board.length;
        colSize = board[0].length;
        visited = new boolean[rowSize][colSize];
        root = new TrieNode();
        for(String word: words){
            root.addWord(word);
        }

        for(int i = 0; i < rowSize; i++){
            for(int j = 0; j < colSize; j++){
                dfs(i, j, root, wordSet, "");
            }
        }
        return new ArrayList<String>(wordSet);
    }
    
    private void dfs(int i, int j, TrieNode root, HashSet<String> wordSet, String word){
        if(root == null){
            return;
        } 
        if(root.endOfWord){
            wordSet.add(word);
        }
        
        if(i < 0 || i >= rowSize || j < 0 || j >= colSize){
            return;
        } else if(visited[i][j]){
            return;
        } else {
            char c = board[i][j];
            visited[i][j] = true;
            dfs(i + 1, j, root.children[c - 'a'], wordSet, word + c);
            dfs(i - 1, j, root.children[c - 'a'], wordSet, word + c);
            dfs(i, j + 1, root.children[c - 'a'], wordSet, word + c);
            dfs(i, j - 1, root.children[c - 'a'], wordSet, word + c);
            visited[i][j] = false;
        }
    }
    public static void main(String[] args) {
        FindWords sol = new FindWords();
        char[][] board = new char[][]{
            new char[]{'a','b','c','d'},
            new char[]{'s','a','a','t'},
            new char[]{'a','c','k','e'},
            new char[]{'a','c','d','n'}
        };
        String[] words = new String[]{"bat", "cat", "back", "backend", "stack"};
        System.out.println(sol.findWords(board, words).toString());
    }
}
