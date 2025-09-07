//This trieNode is used for lowercase alphabet
public class TrieNode {
    TrieNode[] children;
    boolean endOfWord;
    TrieNode(){
        children = new TrieNode[26];
        endOfWord = false;
    }

    public void addWord(String word){
        TrieNode curr = this;
        for(char c: word.toCharArray()){
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.endOfWord = true;
    }

    public boolean search(String word){
        TrieNode curr = this;
        for(char c: word.toCharArray()){
            if(curr.children[c - 'a'] == null){
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return curr.endOfWord;
    }

    public boolean startsWith(String prefix){
        TrieNode curr = this;
        for(char c: prefix.toCharArray()){
            if(curr.children[c - 'a'] == null){
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return true;
    }
}