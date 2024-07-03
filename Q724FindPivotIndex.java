// public class Q724FindPivotIndex {

//     public int pivotIndex(int[] nums) {

//         int sum = 0;

//         for (int i = 0; i < nums.length; i++) {
//             sum += nums[i];
//         }
//         int leftSum = 0;

//         for (int i = 0; i < nums.length; i++) {

//             if (leftSum == sum - leftSum - nums[i]) {
//                 return i;
//             }
//             leftSum += nums[i];
//         }
//         return -1;
//     }

//     public static void main(String[] args) {

//         Q724FindPivotIndex obj = new Q724FindPivotIndex();

//         int[] nums = { 1, 7, 3, 6, 5, 6 };

//         int result = obj.pivotIndex(nums);

//         System.out.println("This is first output = " + result);

//     }
// }






// Runtime: 1 ms, faster than 92.94% of Java online submissions for Find Pivot Index.
// Time Complexity : O(n)
public class Q724FindPivotIndex {
    public int pivotIndex(int[] nums) {
        
        // Initialize total sum of the given array...
        int totalSum = 0;

        // Initialize 'leftSum' as sum of first i numbers, not including nums[i]...
        int leftSum = 0;

        // Traverse the elements and add them to store the totalSum...
        for (int ele : nums)
            totalSum += ele;

        // Again traverse all the elements through the for loop and store the sum of i numbers from left to right...
        for (int i = 0; i < nums.length; leftSum += nums[i++])

            // sum to the left == leftSum.
            // sum to the right === totalSum - leftSum - nums[i]..
            // check if leftSum == totalSum - leftSum - nums[i]...
            if (leftSum * 2 == totalSum - nums[i])

                return i;       // Return the pivot index...

        return -1;      // If there is no index that satisfies the conditions in the problem statement...
    }

    public static void main(String[] args) {

        Q724FindPivotIndex obj = new Q724FindPivotIndex();

        int[] nums = { 1, 7, 3, 6, 5, 6 };

        int result = obj.pivotIndex(nums);

        System.out.println("This is first output = " + result);

    }
}
