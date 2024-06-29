public class Q1456MaxNumOfVowelsLength {
    // This method calculates the maximum number of vowels in any substring of length k
    public int maxVowels(String s, int k) {
        int maxLen = 0; // This variable keeps track of the maximum number of vowels found in any k-length substring

        // Array to mark vowels. Each index corresponds to a letter ('a' to 'z').
        // If a character is a vowel, its corresponding index in this array will be 1, otherwise 0.
        int[] vowels = new int[26];
        vowels['a' - 'a'] = 1; // Mark 'a' as a vowel
        vowels['e' - 'a'] = 1; // Mark 'e' as a vowel
        vowels['i' - 'a'] = 1; // Mark 'i' as a vowel
        vowels['o' - 'a'] = 1; // Mark 'o' as a vowel
        vowels['u' - 'a'] = 1; // Mark 'u' as a vowel

        int count = 0; // This variable keeps track of the number of vowels in the current window of size k
        int left = 0;  // This is the start index of the current window

        // Loop through the string with 'right' as the end index of the current window
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right); // Get the current character at the end of the window
            count += vowels[ch - 'a']; // If it's a vowel, increment the count

            // Check if the window size has reached k
            if (right >= k - 1) {
                maxLen = Math.max(maxLen, count); // Update the maximum length of vowels found

                // Remove the character at the start of the window from the count as we slide the window
                char leftChar = s.charAt(left);
                count -= vowels[leftChar - 'a'];
                left++; // Move the start of the window to the right
            }
        }
        return maxLen; // Return the maximum number of vowels found in any k-length substring
    }

    public static void main(String[] args) {
        Q1456MaxNumOfVowelsLength obj = new Q1456MaxNumOfVowelsLength(); // Create an instance of the class

        // First test case
        String s = "abciiidef"; // Input string
        int k = 3; // Length of the substring
        int result = obj.maxVowels(s, k); // Call the method and store the result
        System.out.println(result); // Output the result, should be 3 (substring "iii" has 3 vowels)

        // Second test case
        String s1 = "aeiou"; // Input string
        int k1 = 2; // Length of the substring
        result = obj.maxVowels(s1, k1); // Call the method and store the result
        System.out.println(result); // Output the result, should be 2 (any substring of length 2 has 2 vowels)
    }
}



















// public class Q1456MaxNumOfVowelsLength {
//     public int maxVowels(String s, int k) {
//         int maxLen = 0;

//         int[] vowels = new int[26];

//         vowels['a' - 'a'] = 1;
//         vowels['e' - 'a'] = 1;
//         vowels['i' - 'a'] = 1;
//         vowels['o' - 'a'] = 1;
//         vowels['u' - 'a'] = 1;
//         int count = 0;
//         int left = 0;

//         for (int right = 0; right < s.length(); right++) {
//             char ch = s.charAt(right);
//             count += vowels[ch-'a'];
//             if(right >= k-1){
//                 maxLen = Math.max(maxLen, count);
//                 char leftChar = s.charAt(left);
//                 if(vowels[leftChar-'a'] != 1){
//                     count--;
//                 }
//                 left++;
//             }
//         }
//         return maxLen;
//     }

//     public static void main(String[] args) {

//         Q1456MaxNumOfVowelsLength obj = new Q1456MaxNumOfVowelsLength();

//         String s = "abciiidef";

//         int k = 3;

//         int result = obj.maxVowels(s, k);

//         System.out.println(result);


//         //2nd
//         String s1 = "aeiou";
//         int k1 = 2;
//         result = obj.maxVowels(s1, k1);
//         System.out.println(result);
//     }
// }




















// public class Q1456MaxNumOfVowelsLength {
//     public int maxVowels(String s, int k) {
//         int maxLen = 0;
//         int count = 0;

//         for (int i = 0; i < s.length(); i++) {
//             if (i >= k) {
//                 char charToRemove = s.charAt(i - k);
//                 if (charToRemove == 'a' || charToRemove == 'e' || charToRemove == 'i' || charToRemove == 'o' || charToRemove == 'u') {
//                     count--;
//                 }
//             }
//             char charToAdd = s.charAt(i);
//             if (charToAdd == 'a' || charToAdd == 'e' || charToAdd == 'i' || charToAdd == 'o' || charToAdd == 'u') {
//                 count++;
//             }
//             if (count > maxLen) {
//                 maxLen = count;
//             }
//         }
//         return maxLen;
//     }

//     public static void main(String[] args) {
//         Q1456MaxNumOfVowelsLength obj = new Q1456MaxNumOfVowelsLength();
//         System.out.println(obj.maxVowels("abceefghijklmnopqrstuvwxyz", 5)); // Output: 3
//         System.out.println(obj.maxVowels("leetcode", 3)); // Output: 2
//     }
// }
