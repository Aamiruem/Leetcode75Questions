public class Q374GuessNumberHigherORlower {
    
    // Mock implementation of the guess API
    // This method should be implemented in accordance with the problem's requirements
    // For this example, let's assume the target number to be guessed is 6
    private int guess(int num) {
        int target = 6;
        if (num < target) {
            return 1; // The guess is lower than the target number
        } else if (num > target) {
            return -1; // The guess is higher than the target number
        } else {
            return 0; // The guess is correct
        }
    }

    public int guessNumber(int n) {
        int start = 1; // Start of the range
        int end = n;   // End of the range
        int middle;
        int answer = 0;

        // Binary search loop to find the correct number
        while (start <= end) {
            middle = start + (end - start) / 2; // Calculate the middle of the range

            // Use the guess API to check the middle value
            if (guess(middle) == -1) {
                end = middle - 1; // The target number is lower, adjust the end of the range
            } else if (guess(middle) == 1) {
                start = middle + 1; // The target number is higher, adjust the start of the range
            } else if (guess(middle) == 0) {
                answer = middle; // The guess is correct
                break; // Exit the loop
            }
        }
        return answer; // Return the correct number
    }

    public static void main(String[] args) {
        Q374GuessNumberHigherORlower solution = new Q374GuessNumberHigherORlower();
        int n = 10;
        int guessNumber = solution.guessNumber(n);
        System.out.println("The number is: " + guessNumber);
    }
}
