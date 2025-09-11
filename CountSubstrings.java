import java.util.ArrayList;

public class CountSubstrings {
    public int countSubstrings(String s){
        ArrayList<String> palindromes = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            addPalindromes(s, i, i, palindromes);
        }

        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) != s.charAt(i + 1)){
                continue;
            }
            addPalindromes(s, i, i + 1, palindromes);
        }
        return palindromes.size();
    }

    private void addPalindromes(String s, int l, int r, ArrayList<String> lst){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            lst.add(s.substring(l, r + 1));
            l--;
            r++;
        }
    }
    public static void main(String[] args) {
        CountSubstrings sol = new CountSubstrings();
        System.out.println(sol.countSubstrings("aaa") == 6);
    }
}