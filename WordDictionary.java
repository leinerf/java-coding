public class WordDictionary {
    TrieNode root;
    WordDictionary(){
        root = new TrieNode();
    }
    public void addWord(String word){
        root.addWord(word);
    }

    public boolean search(String word){
        return dfs(word.toCharArray(), 0, root);
    }

    private boolean dfs(char[] word, int i, TrieNode root){
        if(root == null){
            return false;
        } else if(i >= word.length){
            return root.endOfWord;
        } else {
            if(word[i] != '.'){
                return dfs(word, i + 1, root.children[word[i] - 'a']);
            }
            for(int j = 0; j < 26; j++){
                if(dfs(word, i + 1, root.children[j])){
                    return true;
                }
            }
            return false;
        }
    }
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("day");
        wordDictionary.addWord("bay");
        wordDictionary.addWord("may");
        System.out.println(wordDictionary.search("say") == false); // return false
        System.out.println(wordDictionary.search("day") == true); // return true
        System.out.println(wordDictionary.search(".ay") == true); // return true
        System.out.println(wordDictionary.search("b..") == true); // return true
    }
}
