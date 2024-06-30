// public class Q1004MaxConsecutiveOnes {
//     public int longestOnes(int[] nums, int k){

//         int left = 0;
//         int right = 0;
//         int maxLen = 0;
//         int count = 0;

//         while(right < nums.length){

//             if(nums[right] == 0){
//                 count++;
//             }

//             if(count > k){
//                 if(nums[left] == 0){
//                     count--;
//                 }
//                 left++;
//             }

//             maxLen = Math.max(maxLen, right - left + 1);

//             right++;
//         }

//         return maxLen;
//     }

//     public static void main(String[] args) {

//         Q1004MaxConsecutiveOnes obj = new Q1004MaxConsecutiveOnes();

//         int[] nums = {1,1,1,0,0,0,1,1,1,1,0};

//         int k = 2;

//         int result = obj.longestOnes(nums, k);

//         System.out.println(result);

//     }
// }






public class Q1004MaxConsecutiveOnes {

    // Method to find the longest subarray with at most k 0's
    public int longestOnes(int[] nums, int k) {
        int start = 0, max = 0; // Initialize the start pointer and max length
        int countZero = 0; // To count the number of 0's in the current window

        // Iterate over the array using the end pointer
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0) {
                countZero++; // Increment count of 0's if the current element is 0
            }

            // If count of 0's exceeds k, shrink the window from the start
            if (countZero > k) {
                while (countZero > k) {
                    if (nums[start] == 0) {
                        countZero--; // Decrement count of 0's if the element at start is 0
                    }
                    start++; // Move the start pointer to the right
                }
            }

            // Calculate the maximum length of the window
            max = Math.max(max, end - start + 1);
        }

        return max; // Return the maximum length found
    }

    public static void main(String[] args) {
        Q1004MaxConsecutiveOnes obj = new Q1004MaxConsecutiveOnes();

        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}; // Sample input array
        int k = 2; // Maximum number of 0's allowed to be flipped

        int result = obj.longestOnes(nums, k); // Get the result

        System.out.println(result); // Print the result
    }
}
