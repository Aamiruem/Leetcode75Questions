// 714. Best Time to Buy and Sell Stock with Transaction Fee

// public class Q714BuyAndSellStockWithTransaction1 {
//     public int maxProfit(int[] P, int F) {
//         int len = P.length, buying = 0, selling = -P[0];
//         for (int i = 1; i < len; i++) {
//             buying = Math.max(buying, selling + P[i] - F);
//             selling = Math.max(selling, buying - P[i]);
//         }
//         return buying;
//     }
//     public static void main(String[] args) {
//         Q714BuyAndSellStockWithTransaction1 obj = new Q714BuyAndSellStockWithTransaction1();
//         int[] P = {1, 3, 2, 8, 4, 9};
//         int F = 2;
//         int result = obj.maxProfit(P, F);
//         System.out.println(result);
//     }
// }









public class Q714BuyAndSellStockWithTransaction1 {

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp[][] = new int[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy < 2; buy++) {
                if (buy == 0) {
                    dp[i][buy] = Math.max(prices[i] + dp[i + 1][1], dp[i + 1][0]);
                } else {
                    dp[i][buy] = Math.max((-prices[i] + dp[i + 1][0]) - fee, dp[i + 1][1]);
                }

            }
        }
        return dp[0][1];

    }

    public static void main(String[] args) {
        Q714BuyAndSellStockWithTransaction1 obj = new Q714BuyAndSellStockWithTransaction1();
        int[] P = {1, 3, 2, 8, 4, 9};
        int F = 2;
        int result = obj.maxProfit(P, F);
        System.out.println(result);
    }
}
