public class CanJump {
    public boolean canJump(int[] nums){
        int r = 0;
        for(int i = 0; i < nums.length - 1; i++){
            r = Math.max(r, nums[i] + i);
            if(i == r){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        CanJump sol = new CanJump();
        System.out.println(sol.canJump(new int[]{1,2,0,1,0}) == true);
    }
}
