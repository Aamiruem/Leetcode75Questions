//Heap sort 


// import java.util.PriorityQueue;

// public class Q215KthLargestElement{
//     public int findKthLargest(int[] nums, int k) {
//           PriorityQueue<Integer>minHeap = new PriorityQueue<>();
//         for(int i = 0; i<k; i++){
//             minHeap.offer(nums[i]);
//         }
//         for(int i = k; i<nums.length; i++){
//             if(nums[i] > minHeap.peek()){
//                 minHeap.poll();
//                 minHeap.offer(nums[i]);
//             }
//         }
//         return minHeap.peek();
//     }
//     public static void main(String[] args) {
//         Q215KthLargestElement obj = new Q215KthLargestElement();
//         int[] nums = {3,2,3,1,2,4,5,5,6};
//         int k = 4;
//         System.out.println(obj.findKthLargest(nums, k));
//     }
// }







//array function sort

// import java.util.Arrays;
// public class Q215KthLargestElement{
//     public int findKthLargest(int[] nums, int k) {
//         Arrays.sort(nums);
//         return nums[nums.length - k];
//     }
//     public static void main(String[] args) {
//         Q215KthLargestElement obj = new Q215KthLargestElement();
//         int[] nums = {3,2,1,5,6,4};
//         int k = 2;
//         System.out.println(obj.findKthLargest(nums, k));
//     }
// }











//Quick Select sort algorithms
import java.util.Random;

public class Q215KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        Random rand = new Random();
        while (true) {
            int pivot_index = left + rand.nextInt(right - left + 1);
            int new_pivot_index = partition(nums, left, right, pivot_index);
            if (new_pivot_index == nums.length - k) {
                return nums[new_pivot_index];
            } else if (new_pivot_index > nums.length - k) {
                right = new_pivot_index - 1;
            } else {
                left = new_pivot_index + 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right, int pivot_index) {
        int pivot = nums[pivot_index];
        swap(nums, pivot_index, right);
        int stored_index = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, stored_index);
                stored_index++;
            }
        }
        swap(nums, right, stored_index);
        return stored_index;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        Q215KthLargestElement obj = new Q215KthLargestElement();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(obj.findKthLargest(nums, k));
    }
}
