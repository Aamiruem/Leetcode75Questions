// public class Q1137NthTribonacciNumbers {

//     public int tribonacci(int n) {
//         if (n < 3) {
//             return n == 0 ? 0 : 1;
//         }

//         int a = 0, b = 1, c = 1;

//         for (int i = 2; i < n; i++) {
//             int temp = a + b + c;
//             a = b;
//             b = c;
//             c = temp;
//         }
//         return c;
//     }

//     public static void main(String[] args) {
//         Q1137NthTribonacciNumbers obj = new Q1137NthTribonacciNumbers();
//         System.out.println(obj.tribonacci(4));
//     }

// }














// import java.util.*;

public class Q1137NthTribonacciNumbers {
    public int tribonacci(int n){
        if(n< 2){
            return n;
        }
        int dp[] = {0, 1, 1};

        for(int i = 3; i <= n; i++){
            final int next = dp[0] + dp[1] + dp[2];
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = next;
        }

        return dp[2];
    }
    public static void main(String[] args) {
        Q1137NthTribonacciNumbers obj = new Q1137NthTribonacciNumbers();
        System.out.println(obj.tribonacci(25));
    }
}
