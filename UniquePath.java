public class UniquePath {
    public int uniquePath(int m, int n){
        int[] old = new int[n];
        int[] nw = new int[n];
        for(int i = 0; i < n; i++){
            old[i] = 1;
        }
        for(int i = 1; i < m; i++){
            nw[0] = 1;
            for(int j = 1; j < n; j++){
                nw[j] = old[j] + nw[j - 1];
            }
            old = nw;
            nw = new int[n];
        }
        return old[n - 1];
    }

    public static void main(String[] args) {
        UniquePath sol = new UniquePath();
        System.out.println(sol.uniquePath(3, 3) == 6);
    }
}
