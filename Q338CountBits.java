import java.util.Arrays;

public class Q338CountBits{
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i=1; i<=n; i++){
            dp[i] = dp[i>>1] + (i&1);
        }
        return dp;
    }
    public static void main(String[] args) {

        Q338CountBits obj = new Q338CountBits();

        int n = 2;

        System.out.println("The number of bits in the binary representation of all numbers from 0 to " + n + " are: " + Arrays.toString(obj.countBits(n)));

    }
}
