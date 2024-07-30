public class Q162FindPeak {

    
    public int findPeak(int[] nums) {
        int start = 0; 
        int end = nums.length - 1; 
        
        while (start < end) { 
            int mid = start + (end - start) / 2;
            if(nums[mid] < nums[mid + 1]){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        return start;
    }
    public static void main(String[] args) {
        Q162FindPeak findPeak = new Q162FindPeak();
        int[] nums = {1, 2, 3, 1};
        int peakIndex = findPeak.findPeak(nums);
        System.out.println("Peak index: " + peakIndex); // Output: 2

        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        peakIndex = findPeak.findPeak(nums2);
        System.out.println("Peak index: " + peakIndex); // Output: 5
    }
}














// public class Q162FindPeak {

//     // Method to find a peak element
//     public int findPeak(int[] nums) {
//         int start = 0; // Starting index of the search range
//         int end = nums.length - 1; // Ending index of the search range
        
//         while (start < end) { 
//             int mid = start + (end - start) / 2; // Calculate the middle index

//             // Compare middle element with its next element
//             if (nums[mid] > nums[mid + 1]) {
//                 // If middle element is greater than the next element,
//                 // then the peak lies on the left half including mid
//                 end = mid;
//             } else {
//                 // If middle element is less than or equal to the next element,
//                 // then the peak lies on the right half excluding mid
//                 start = mid + 1;
//             }
//         }
        
//         // The loop exits when start == end, pointing to the peak element
//         return start;
//     }
    
//     public static void main(String[] args) {
//         Q162FindPeak findPeak = new Q162FindPeak();
        
//         int[] nums1 = {1, 2, 3, 1};
//         System.out.println(findPeak.findPeak(nums1)); // Output: 2 (index of peak element 3)
        
//         int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
//         System.out.println(findPeak.findPeak(nums2)); // Output: 5 (index of peak element 6)
//     }
// }
