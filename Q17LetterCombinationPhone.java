import java.util.ArrayList;
import java.util.List;

public class Q17LetterCombinationPhone {

    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return ans;
        }
        solve(0, new StringBuilder(), digits);
        return ans;
    }

    public void solve(int index, StringBuilder sb, String digits) {
        if (index == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        String str = findString(digits.charAt(index));
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            solve(index + 1, sb, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public String findString(char ch) {
        if (ch == '2') {
            return "abc";
        }
        if (ch == '3') {
            return "def";
        }
        if (ch == '4') {
            return "ghi";
        }
        if (ch == '5') {
            return "jkl";
        }
        if (ch == '6') {
            return "mno";
        }
        if (ch == '7') {
            return "pqrs";
        }
        if (ch == '8') {
            return "tuv";
        } else {
            return "wxyz";
        }
    }
    public static void main(String[] args) {

        Q17LetterCombinationPhone obj = new Q17LetterCombinationPhone();

        String digits = "23";
        System.out.println(obj.letterCombinations(digits));
        // Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]

        // 2nd
        digits = "2";
        System.out.println(obj.letterCombinations(digits));
        // Output: ["a","b","c"]

        // 3rd
        digits = "";
        System.out.println(obj.letterCombinations(digits));
        // Output: []
        // 4th
        digits = "232";
        System.out.println(obj.letterCombinations(digits));
        // Output: ["adad", "adae", "adaf", "aead", "aeae", "aeaf", "afad", "afae", "afaf"]
    }
}
