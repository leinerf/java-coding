public class LongestCommonSubstring {

    public int longestCommonSubstring(String text1, String text2){
        int[] old = new int[text2.length() + 1], nw = new int[text2.length() + 1];
        for(int i = 0; i < text1.length(); i++){
            char a = text1.charAt(i);
            for(int j = 0; j < text2.length(); j++){
                char b = text2.charAt(j);
                if(a != b){
                    nw[j + 1] = Math.max(nw[j], old[j + 1]);
                } else {
                    nw[j + 1] = Math.max(old[j] + 1, old[j + 1]);
                    nw[j + 1] = Math.max(nw[j], nw[j + 1]);
                }
            }
            old = nw;
            nw = new int[text2.length() + 1];
        }
        return old[old.length - 1];
    }

    public static void main(String[] args) {
        LongestCommonSubstring sol = new LongestCommonSubstring();
        System.out.println(sol.longestCommonSubstring("xyzcat", "xcyrzaqt") == 5);
    }
}
