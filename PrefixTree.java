import java.util.HashMap;

class PrefixTree {
    private TrieNode head;
    
    PrefixTree() {
        head = new TrieNode();
    }

    public void insert(String word) {
        head.addWord(word);
    }

    public boolean search(String word) {
        return head.search(word);
    }

    public boolean startsWith(String prefix) {
        return head.startsWith(prefix);
    }
    public static void main(String[] args){
        PrefixTree prefixTree = new PrefixTree();
        prefixTree.insert("dog");
        System.out.println(prefixTree.search("dog") == true);    // return true
        System.out.println(prefixTree.search("do") == false);     // return false
        System.out.println(prefixTree.startsWith("do") == true); // return true
        prefixTree.insert("do");
        System.out.println(prefixTree.search("do") == true);     // return true
    }
}
