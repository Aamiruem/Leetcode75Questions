// public class Q1493LongestSubarray {
//     public int longestSubarray(int[] nums){
//         int[] prefixSum = new int[nums.length + 1];
//         prefixSum[0] = 0;
//         for(int i = 1; i <= nums.length; i++){
//             prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
//         }

//         int maxLength = 0;
//         for(int i = 1; i <= nums.length; i++){
//             for(int j = 0; j < i; j++){
//                 int sum = prefixSum[i] - prefixSum[j];
//                 if(sum % 3 == 0){
//                     maxLength = Math.max(maxLength, i - j);
//                 }
//             }
//         }

//         return maxLength;
//     }

//     public static void main(String[] args) {

//         Q1493LongestSubarray obj = new Q1493LongestSubarray();
//         int[] nums = {1,1,1,1,1};

//         int result = obj.longestSubarray(nums);

//         System.out.println("This is first output = " + result);

//     }
// }















public class Q1493LongestSubarray {

    public int longestSubarray(int[] nums) {
        int leftLen = 0, rightLen = 0, pos = 0, max = 0;
        while (pos < nums.length) {
            if (nums[pos] == 1) {
                pos++;
                leftLen++;
            } else if (nums[pos] == 0) {
                rightLen = 0;
                pos++;
                while (pos < nums.length && nums[pos] == 1) {
                    pos++;
                    rightLen++;
                }
                max = Math.max(max, leftLen + rightLen);
                leftLen = rightLen;
            }
        }
        if (leftLen == nums.length)
            max = nums.length - 1;
        return max;
    }

    public static void main(String[] args) {

        Q1493LongestSubarray obj = new Q1493LongestSubarray();
        int[] nums = {1, 1, 0, 1};

        int result = obj.longestSubarray(nums);

        System.out.println("This is first output = " + result);

    }
}
