import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.lang.StringBuilder;

public class ForeignDictionary {
    HashMap<Character, HashSet<Character>> charEdges;
    HashMap<Character, Integer> indegree;
    
    public String foreignDictionary(String[] words){
        charEdges = new HashMap<>();
        indegree = new HashMap<>();

        for(String word: words){
            for(char ch: word.toCharArray()){
                charEdges.putIfAbsent(ch, new HashSet<>());
                indegree.putIfAbsent(ch, 0);
            }
        }

        for(int i = 0; i < words.length - 1; i++){
            String w1 = words[i], w2 = words[i + 1];
            int minLngth = Math.min(w1.length(), w2.length());
            if(w1.length() > w2.length() && w1.substring(0, minLngth).equals(w2.substring(0, minLngth))){
                return "";
            }
            for(int k = 0; k < minLngth; k++){
                char ch1 = w1.charAt(k), ch2 = w2.charAt(k);
                if(ch1 != ch2){
                    if(!charEdges.get(ch1).contains(ch2)){
                        charEdges.get(ch1).add(ch2);
                        indegree.put(ch2, indegree.get(ch2) + 1);
                    }
                    break;
                }
            }
        }
        
        StringBuilder res = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for(Map.Entry<Character, Integer> entry: indegree.entrySet()){
            if(entry.getValue() == 0){
                q.add(entry.getKey());
            }
        }

        while(!q.isEmpty()){
            char ch = q.remove();
            res.append(ch);

            HashSet<Character> edges = charEdges.get(ch);
            for(char edge: edges){
                indegree.put(edge, indegree.get(edge) - 1);
                if(indegree.get(edge) == 0){
                    q.add(edge);
                }
            }
        }

        if(res.length() != indegree.size()){
            return "";
        }
        
        return res.toString();
    }

    public static void main(String[] args) {
        ForeignDictionary sol = new ForeignDictionary();
        System.out.println(sol.foreignDictionary(new String[]{"hrn","hrf","er","enn","rfnn"}).equals("hernf"));
    }
}