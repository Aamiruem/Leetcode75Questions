// package Leetcode150Qusetions;
// import java.util.Arrays;
// public class Q88MergeSortedArrays {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int i = m-1;
//         int j = n-1;
//         int k = m+n-1;
//         while(i>=0 && j>=0){
//             if(nums1[i] > nums2[j]){
//                 nums1[k--] = nums1[i--];
//             }else{
//                 nums1[k--] = nums2[j--];
//             }
//         }
//         while(j>=0){
//             nums1[k--] = nums2[j--];
//         }
//     }
//     public static void main(String[] args) {
//         Q88MergeSortedArrays obj = new Q88MergeSortedArrays();
//         int[] nums1 = {1,2,3,0,0,0};
//         int m = 3;
//         int[] nums2 = {2,5,6};
//         int n = 3;
//         obj.merge(nums1, m, nums2, n);
//         System.out.println(Arrays.toString(nums1));
//     }
// }









package Leetcode150Qusetions;

public class Q88MergeSortedArrays {

    // Function to find the GCD of two numbers
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // Function to find the GCD of an array
    public static int findGCD(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must contain at least one element.");
        }
        
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);

            // If at any point GCD becomes 1, return 1
            if (result == 1) {
                return 1;
            }
        }
        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] arr = {24, 36, 48, 60};  // Example array
        System.out.println("GCD of the array: " + findGCD(arr));  // Expected Output: 12
    }
}
