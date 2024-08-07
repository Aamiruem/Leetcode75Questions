// public class Q746minCostClimbingStairs {

//     public int minCostClimbingStairs(int[] cost) {
//         int n = cost.length;
//         int[] dp = new int[n];

//         dp[0] = cost[0];
//         dp[1] = cost[1];

//         for (int i = 2; i < n; i++) {
//             dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
//         }

//         return Math.min(dp[n - 1], dp[n - 2]);
//     }

//     public static void main(String[] args) {
//         Q746minCostClimbingStairs obj = new Q746minCostClimbingStairs();
//         int[] cost = { 10, 15, 20 };
//         System.out.println(obj.minCostClimbingStairs(cost));

//         cost = new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
//         System.out.println(obj.minCostClimbingStairs(cost));

//     }
// }

// import java.util.*;

// public class Q746minCostClimbingStairs {
//     public int minCostClimbingStairs(int[] cost) {
//         int n = cost.length;
//         int DP[] = new int[n + 1];
//         Arrays.fill(DP, -1);
//         return mincost(cost, n, DP);

//     }

//     public static int mincost(int cost[], int n, int DP[]) {
//         if (n == 0 || n == 1)
//             return DP[n] = 0;
//         if (DP[n] != -1) {
//             return DP[n];
//         }
//         if (n == 2) {
//             return DP[n] = Math.min(cost[0], cost[1]);
//         }
//         return DP[n] = Math.min(mincost(cost, n - 1, DP) + cost[n - 1], mincost(cost, n - 2, DP) + cost[n - 2]);

//     }

//     public static void main(String[] args) {
//         Q746minCostClimbingStairs obj = new Q746minCostClimbingStairs();
//         int[] cost = { 10, 15, 20 };
//         System.out.println(obj.minCostClimbingStairs(cost));

//         cost = new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
//         System.out.println(obj.minCostClimbingStairs(cost));

//     }
// }

// Recursive Top Down - O(2^n) Time Limit Exceeded

// public class Q746minCostClimbingStairs {
//     public int minCostClimbingStairs(int[] cost) {
//         int n = cost.length;
//         return Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
//     }

//     private int minCost(int[] cost, int n) {
//         if (n < 0)
//             return 0;
//         if (n == 0 || n == 1)
//             return cost[n];
//         return cost[n] + Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
//     }

//     public static void main(String[] args) {
//         Q746minCostClimbingStairs obj = new Q746minCostClimbingStairs();
//         int[] cost = { 10, 15, 20 };
//         System.out.println(obj.minCostClimbingStairs(cost));
//     }
// }

// Top Down Memoization - O(n) 1ms

// public class Q746minCostClimbingStairs {
// int[] dp;
// public int minCostClimbingStairs(int[] cost) {
// 	int n = cost.length;
// 	dp = new int[n];
// 	return Math.min(minCost(cost, n-1), minCost(cost, n-2));
// }
// private int minCost(int[] cost, int n) {
// 	if (n < 0) return 0;
// 	if (n==0 || n==1) return cost[n];
// 	if (dp[n] != 0) return dp[n];
// 	dp[n] = cost[n] + Math.min(minCost(cost, n-1), minCost(cost, n-2));
// 	return dp[n];
// }

//     public static void main(String[] args) {
//         Q746minCostClimbingStairs obj = new Q746minCostClimbingStairs();
//         int[] cost = { 10, 15, 20 };
//         System.out.println(obj.minCostClimbingStairs(cost));
//     }
// }

// Bottom up tabulation - O(n) 1ms

// public class Q746minCostClimbingStairs {
// public int minCostClimbingStairs(int[] cost) {
// 	int n = cost.length;
// 	int[] dp = new int[n];
// 	for (int i=0; i<n; i++) {
// 		if (i<2) dp[i] = cost[i];
// 		else dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
// 	}
// 	return Math.min(dp[n-1], dp[n-2]);
// }

//         public static void main(String[] args) {
//             Q746minCostClimbingStairs obj = new Q746minCostClimbingStairs();
//             int[] cost = { 10, 15, 20 };
//             System.out.println(obj.minCostClimbingStairs(cost));
//         }
//     }

// Top Down Memoization - O(n) 1ms

// public class Q746minCostClimbingStairs {
// int[] dp;
// public int minCostClimbingStairs(int[] cost) {
// 	int n = cost.length;
// 	dp = new int[n];
// 	return Math.min(minCost(cost, n-1), minCost(cost, n-2));
// }
// private int minCost(int[] cost, int n) {
// 	if (n < 0) return 0;
// 	if (n==0 || n==1) return cost[n];
// 	if (dp[n] != 0) return dp[n];
// 	dp[n] = cost[n] + Math.min(minCost(cost, n-1), minCost(cost, n-2));
// 	return dp[n];
// }

//     public static void main(String[] args) {
//         Q746minCostClimbingStairs obj = new Q746minCostClimbingStairs();
//         int[] cost = { 10, 15, 20 };
//         System.out.println(obj.minCostClimbingStairs(cost));
//     }
// }

// Bottom up tabulation - O(n) 1ms

// public class Q746minCostClimbingStairs {
// public int minCostClimbingStairs(int[] cost) {
// 	int n = cost.length;
// 	int[] dp = new int[n];
// 	for (int i=0; i<n; i++) {
// 		if (i<2) dp[i] = cost[i];
// 		else dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
// 	}
// 	return Math.min(dp[n-1], dp[n-2]);
// }

//     public static void main(String[] args) {
//         Q746minCostClimbingStairs obj = new Q746minCostClimbingStairs();
//         int[] cost = { 10, 15, 20 };
//         System.out.println(obj.minCostClimbingStairs(cost));
//     }
// }





// Bottom up computation - O(n) time, O(1) space

public class Q746minCostClimbingStairs {

public int minCostClimbingStairs(int[] cost) {
	int n = cost.length;
	int first = cost[0];
	int second = cost[1];
	if (n<=2) return Math.min(first, second);
	for (int i=2; i<n; i++) {
		int curr = cost[i] + Math.min(first, second);
		first = second;
		second = curr;
	}
	return Math.min(first, second);
}
    public static void main(String[] args) {
        Q746minCostClimbingStairs obj = new Q746minCostClimbingStairs();
        int[] cost = { 10, 15, 20 };
        System.out.println(obj.minCostClimbingStairs(cost));
    }
}
