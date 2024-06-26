// import java.util.*;

// public class Q283MoveZeros {
//     public void moveZeros(int[] nums){
//         int left = 0;

//         for(int right = 0; right < nums.length; right++){
//             if(nums[right] != 0){
//                 int temp = nums[right];
//                 nums[right] = nums[left];
//                 nums[left] = temp;
//                 left++;
//             }
//         }
//     }

//     public static void main(String[] args) {

//         Q283MoveZeros obj = new Q283MoveZeros();

//         int[] nums = {0,1,0,3,12};

//         obj.moveZeros(nums);

//         System.out.println(Arrays.toString(nums));

//     }
// }






import java.util.*; // Importing the Java utilities package, which includes the Arrays class

public class Q283MoveZeros { // Defining a public class named Q283MoveZeros
    // Method to move all zeros in the array to the end while maintaining the order of non-zero elements
    public void moveZeros(int[] nums){
        int count = 0; // Initializing a counter to keep track of the position to place non-zero elements

        // Loop through the array to move non-zero elements to the front
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){ // Check if the current element is not zero
                nums[count++] = nums[i]; // Place the non-zero element at the current count index and increment count
            }
        }

        // Fill the remaining positions in the array with zeros
        while(count < nums.length){
            nums[count++] = 0; // Place zero at the current count index and increment count
        }
    }

    // Main method to test the moveZeros method
    public static void main(String[] args) {
        Q283MoveZeros obj = new Q283MoveZeros(); // Creating an instance of the Q283MoveZeros class

        int[] nums = {0, 1, 0, 3, 12}; // Initializing an array with some elements

        obj.moveZeros(nums); // Calling the moveZeros method to move all zeros to the end

        System.out.println("All zero move from right side = " + Arrays.toString(nums)); // Printing the modified array
    }
}
