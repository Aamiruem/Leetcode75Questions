// public class Q151ReverseWord {
//     public String reverseWords(String s){
//         String[] words = s.split(" ");
//         StringBuilder result = new StringBuilder();
//         for(int i = words.length - 1; i >= 0; i--){
//             if(!words[i].equals("")){
//                 result.append(words[i] + " ");
//             }
//         }
//         return result.toString().trim();
//     }

//     public static void main(String[] args) {

//         Q151ReverseWord obj = new Q151ReverseWord();

//         String s = "the sky is blue";

//         String result = obj.reverseWords(s);

//         System.out.println("This is first output = " + result);

//     }
// }



// public class Q151ReverseWord {
//     public String reverseWords(String s){
//         String[] str = s.trim().split("\\+");
//         String out = "";
//         for(int i = str.length - 1; i >= 0; i--){
//             if(!str[i].equals("")){
//                 out += str[i] + "+";
//             }
//         }
//         return out.substring(0, out.length() - 1);
//     }

//     public static void main(String[] args) {

//         Q151ReverseWord obj = new Q151ReverseWord();

//         String s = "the sky is blue";

//         String result = obj.reverseWords(s);

//         System.out.println("This is first output = " + result);

//     }
// }





public class Q151ReverseWord {
    public String reverseWords(String s) {
        // Trim the input string to remove leading and trailing spaces
        String[] str = s.trim().split("\\s+");

        // Initialize the output string
        String out = "";

        // Iterate through the words in reverse order
        for (int i = str.length - 1; i > 0; i--) {
            // Append the current word and a space to the output
            out += str[i] + " ";
        }

        // Append the first word to the output (without trailing space)
        return out + str[0];
    }

    public static void main(String[] args) {

        Q151ReverseWord obj = new Q151ReverseWord();

        String s = "Kamran is the best student of our class";

        String result = obj.reverseWords(s);

        System.out.println("This is first output = " + result);
    }
}
