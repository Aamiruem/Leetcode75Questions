
// import java.util.Arrays;
// import java.util.PriorityQueue;
// import java.util.Queue;
// public class Q2542MaxSubsequenceScore {
//     public long maxScore(int[] nums1, int[] nums2, int k) {
//         long ans = 0;
//         int N = nums1.length;
//         if (k == 1) {
//             for (int i = 0; i < N; i++) {
//                 long cur = (long) nums1[i] * nums2[i];
//                 ans = Math.max(ans, cur);
//             }
//             return ans;
//         }
//         int[][] arr = new int[N][];
//         for (int i = 0; i < N; i++) {
//             arr[i] = new int[]{nums1[i], nums2[i]};
//         }
//         Arrays.sort(arr, (a, b) -> a[1] - b[1]);
//         Queue<Integer> queue = new PriorityQueue<>();
//         long sum = 0;
//         for (int i = N - 1; i >= 0; i--) {
//             int num1 = arr[i][0];
//             if (i <= N - k) {
//                 long cur = (sum + num1) * arr[i][1];
//                 ans = Math.max(ans, cur);
//             }
//             if (queue.size() < k - 1) {
//                 queue.add(num1);
//                 sum += num1;
//             } else if (num1 > queue.peek()) {
//                 sum -= queue.poll();
//                 sum += num1;
//                 queue.add(num1);
//             }
//         }
//         return ans;
//     }
//     public static void main(String[] args) {
//         Q2542MaxSubsequenceScore obj = new Q2542MaxSubsequenceScore();
//         int[] nums1 = {1, 3, 3, 2};
//         int[] nums2 = {2, 1, 3, 4};
//         int k = 3;
//         long result = obj.maxScore(nums1, nums2, k);
//         System.out.println("This is the max subsequence score " + result);
//     }
// }















import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q2542MaxSubsequenceScore {

    public long maxScore(int[] nums1, int[] nums2, int k) {

        long ans = 0;
        int N = nums1.length;

        if (k == 1) {
            for (int i = 0; i < N; i++) {
                long cur = (long) nums1[i] * nums2[i];
                ans = Math.max(ans, cur);
            }
            return ans;
        }

        int[][] arr = new int[N][];
        for (int i = 0; i < N; i++) {
            arr[i] = new int[]{nums1[i], nums2[i]};
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        Queue<Integer> queue = new PriorityQueue<>();
        long sum = 0;
        for (int i = N - 1; i >= 0; i--) {
            int num1 = arr[i][0];
            if (i <= N - k) {
                long cur = (sum + num1) * arr[i][1];
                ans = Math.max(ans, cur);
            }
            if (queue.size() < k - 1) {
                queue.add(num1);
                sum += num1;
            } else if (num1 > queue.peek()) {
                sum -= queue.poll();
                sum += num1;
                queue.add(num1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q2542MaxSubsequenceScore obj = new Q2542MaxSubsequenceScore();
        int[] nums1 = {1, 3, 3, 2};
        int[] nums2 = {2, 1, 3, 4};
        int k = 3;
        long result = obj.maxScore(nums1, nums2, k);
        System.out.println("This is the max subsequence score " + result);
    }
}
