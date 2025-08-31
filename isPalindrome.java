class Solution {
    public boolean isPalindrome(String s) {
        String strippedS = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int mid = Math.floorDiv(strippedS.length(),2);
        int left, right;

        if(strippedS.length() % 2 == 0){
            right = mid;
            left = right -1;
        } else {
            right = mid + 1;
            left = mid - 1;
        }
        
        while(left >= 0) {
            if(strippedS.charAt(left) != strippedS.charAt(right)){
                return false;
            }
            left--;
            right++;
        }
        return true;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome("Hello o l l e h!!!"));
    }
}
