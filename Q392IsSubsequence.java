public class Q392IsSubsequence {
    public boolean isSubsequence(String s, String t){
        int sp = 0;
        int tp = 0;

        while(sp < s.length() && tp < t.length()){
            if(s.charAt(sp) == t.charAt(tp)){
                sp++;
            }
            tp++;
        }

        return sp == s.length();
    }

    public static void main(String[] args) {

        Q392IsSubsequence obj = new Q392IsSubsequence();

        String s = "abc";
        String t = "ahbgdc";

        boolean result = obj.isSubsequence(s, t);

        System.out.println("This is first output = " + result);

    }
}
