//leetcode 75 question compile
public class Q1MergeString1768 {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < word1.length() || i < word2.length()) {
            if (i < word1.length()) {
                result.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                result.append(word2.charAt(i));
            }
            i++;
        }
        return result.toString();
    }
    public static void main(String[] args) {

        Q1MergeString1768 obj = new Q1MergeString1768();

        String word1 = "abc";
        String word2 = "pqr";

        System.out.println(obj.mergeAlternately(word1, word2));

    }
}
