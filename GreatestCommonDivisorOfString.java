// 1071. Greatest Common Divisor of Strings
// Easy




public class GreatestCommonDivisorOfString {
    public String gcdOfString(String str1, String str2){
        if(!(str1 + str2).equals(str1 + str2)){
            return "";
        }
        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }
    private int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a % b); //<= same as this code in short form  return b == 0 ? a : gcd(b, a % b);
    }
    public static void main(String[] args) {

        GreatestCommonDivisorOfString obj = new GreatestCommonDivisorOfString();
        System.out.println(obj.gcdOfString("ABCABC", "ABC"));
        System.out.println(obj.gcdOfString("ABABAB", "ABAB"));
        System.out.println(obj.gcdOfString("LEET", "CODE"));
        System.out.println(obj.gcdOfString("ABCDEF", "ABC"));
    }
}
