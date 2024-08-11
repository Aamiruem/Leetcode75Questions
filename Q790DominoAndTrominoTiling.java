public class Q790DominoAndTrominoTiling {
    public int numTilings(int n) {
        long[] dp = new long[n + 3]; dp[0] = 1; dp[1] = 2; dp[2] = 5;
        for (int i = 3; i < n; i ++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 3]) % 1000000007;
        }
        return (int)dp[n - 1];
    }

    public static void main(String[] args) {

        Q790DominoAndTrominoTiling obj = new Q790DominoAndTrominoTiling();

        int n = 3;
        System.out.println(obj.numTilings(n));

        n = 4;  
        System.out.println(obj.numTilings(n));

    }
}
