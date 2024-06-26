public class Q11ContainerWithMostwater { // Defining a public class named Q11ContainerWithMostwater
    // Method to find the maximum area of water that can be contained
    public int maxArea(int[] height){

        int left = 0; // Initializing the left pointer to the start of the array
        int right = height.length - 1; // Initializing the right pointer to the end of the array

        int maxArea = 0; // Variable to store the maximum area found

        // Loop until the left pointer is less than the right pointer
        while(left < right){

            // Calculate the current area using the shorter height and the distance between the pointers
            int currentArea = Math.min(height[left], height[right]) * (right - left);

            // Update maxArea if the current area is greater than the previously found maximum area
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointers to try and find a larger area
            if(height[left] < height[right]){
                left++; // If the left height is less, move the left pointer to the right
            } else {
                right--; // If the right height is less or equal, move the right pointer to the left
            }
        }

        return maxArea; // Return the maximum area found
    }

    // Main method to test the maxArea method
    public static void main(String[] args) {

        Q11ContainerWithMostwater obj = new Q11ContainerWithMostwater(); // Creating an instance of the Q11ContainerWithMostwater class

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7}; // Initializing an array with some heights

        int maxArea = obj.maxArea(height); // Calling the maxArea method to find the maximum area

        System.out.println(maxArea); // Printing the maximum area
    }
}
