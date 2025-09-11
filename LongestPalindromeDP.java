public class LongestPalindromeDP {
    public String longestPalindrome(String s){
        int[] res = new int[]{0,0};
        
        for(int i = 0; i < s.length(); i++){
            int[] nw = helperLongestPalindrome(s, i, i);
            if(res[1] - res[0] < nw[1] - nw[0]){
                res[0] = nw[0];
                res[1] = nw[1];
            }
        }

        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) != s.charAt(i + 1)){
                continue;
            }

            int[] nw = helperLongestPalindrome(s, i, i);
            if(res[1] - res[0] < nw[1] - nw[0]){
                res[0] = nw[0];
                res[1] = nw[1];
            }
        }

        return s.substring(res[0], res[1] + 1);
    }
    
    private int[] helperLongestPalindrome(String s, int l, int r){
        int[] res = new int[]{l, r};
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            res[0] = l;
            res[1] = r;
            l--;
            r++;
        }
        return res;
    }
    
    public static void main(String[] args) {
        LongestPalindromeDP sol = new LongestPalindromeDP();
        System.out.println(sol.longestPalindrome("ababd").equals("aba"));        
    } 
}
