
// public class Q1143LongestCommonSubsequence {
//     public int longestCommonSubsequence(String text1, String text2) {
//         // Lengths of the input strings
//         int length1 = text1.length();
//         int length2 = text2.length();
//         // Create a 2D array to store the lengths of longest common subsequences
//         // for all subproblem, initialized with zero
//         int[][] dp = new int[length1 + 1][length2 + 1];
//         // Build the dp array from the bottom up
//         for (int i = 1; i <= length1; ++i) {
//             for (int j = 1; j <= length2; ++j) {
//                 // If characters match, take diagonal value and add 1
//                 if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
//                     dp[i][j] = dp[i - 1][j - 1] + 1;
//                 } // If characters do not match, take the maximum value from 
//                 // the left (dp[i][j-1]) or above (dp[i-1][j])
//                 else {
//                     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                 }
//             }
//         }
//         // The bottom-right cell contains the length of the longest
//         // common subsequence of text1 and text2
//         return dp[length1][length2];
//     }
//     public static void main(String[] args) {
//         Q1143LongestCommonSubsequence obj = new Q1143LongestCommonSubsequence();
//         String text1 = "abcde";
//         String text2 = "ace";
//         int result = obj.longestCommonSubsequence(text1, text2);
//         System.out.println(result);
//     }
// }



//1D

// public class Q1143LongestCommonSubsequence {

//     public int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length(), m = text2.length();
//         char[] large, small;
//         if (n > m) {
//             large = text1.toCharArray();
//             small = text2.toCharArray();
//         } else {
//             large = text2.toCharArray();
//             small = text1.toCharArray();
//             //swap lengths to store larger length in 'n'
//             n = n ^ m;
//             m = n ^ m;
//             n = n ^ m;
//         }
//         int[] dp = new int[n + 1];

//         for (int i = 1; i <= n; i++) {
//             int prev = dp[0]; // store the value before updating dp[j]
//             for (int j = 1; j <= m; j++) {
//                 int temp = dp[j]; // store the current value of dp[j]
//                 if (large[i - 1] == small[j - 1]) {
//                     dp[j] = prev + 1;
//                 } else {
//                     dp[j] = Math.max(dp[j], dp[j - 1]);
//                 }
//                 prev = temp; // update prev for the next iteration
//             }
//         }
//         return dp[m];
//     }

//     public static void main(String[] args) {
//         Q1143LongestCommonSubsequence obj = new Q1143LongestCommonSubsequence();
//         String text1 = "abcde";
//         String text2 = "ace";
//         int result = obj.longestCommonSubsequence(text1, text2);
//         System.out.println(result);
//     }
// }





//2D

public class Q1143LongestCommonSubsequence {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int n = text1.length(), m =  text2.length();
            char[] s1 = text1.toCharArray();
            char[] s2 = text2.toCharArray();
    
            int[][] dp = new int[n+1][m+1];
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= m; j++){
                    if(s1[i-1] == s2[j-1]){
                        dp[i][j] = dp[i-1][j-1]+1;
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
            return dp[n][m];        
        }
    }

    public static void main(String[] args) {
        Q1143LongestCommonSubsequence obj = new Q1143LongestCommonSubsequence();
        String text1 = "abcde";
        String text2 = "ace";
        int result = obj.new Solution().longestCommonSubsequence(text1, text2);
        System.out.println(result);
    }
}
