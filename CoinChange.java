public class CoinChange {
    public int coinChange(int[] coins, int amount){
        int[] dp1 = new int[amount + 1], dp2 = new int[amount + 1];
        boolean[] valid1 = new boolean[amount +1], valid2 = new boolean[amount + 1];
        int coin = coins[0];
        valid1[0] = true;
        valid2[0] = true;

        for(int i = 1; i <= amount; i++){
            if(i - coin < 0 || !valid1[i - coin]){
                dp1[i] = -1;
            } else {
                dp1[i] = dp1[i - coin] + 1;
                valid1[i] = true;
            }
        }

        for(int i = 1; i < coins.length; i++){
            coin = coins[i];
            for(int j = 1; j <= amount; j++){
                int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
                if(valid1[j]){
                    a = dp1[j];
                }
                if(j - coin >= 0 && valid2[j - coin]){
                    b = dp2[j - coin] + 1;
                }
                if(a == Integer.MAX_VALUE && b == Integer.MAX_VALUE){
                    dp2[j] = -1;
                } else {
                    dp2[j] = Math.min(a, b);
                    valid2[j] = true;
                }
            }
            valid1 = valid2;
            valid2 = new boolean[amount + 1];
            valid2[0] = true;

            dp1 = dp2;
            dp2 = new int[amount + 1];
        }
        return dp1[amount];
    }
    public static void main(String[] args) {
        CoinChange sol = new CoinChange();
        System.out.println(sol.coinChange(new int[]{1,2,5}, 11) == 3);
    }
}