// import java.util.*;

// public class Q443StringCompression {
//     public int compress(char[] chars){
//         int count = 1;
//         int index = 0;
//         for(int i = 1; i < chars.length; i++){
//             if(chars[i] == chars[i-1]){
//                 count++;
//             }else{
//                 chars[index++] = chars[i-1];
//                 if(count > 1){
//                     for(char c : String.valueOf(count).toCharArray()){
//                         chars[index++] = c;
//                     }
//                 }
//                 count = 1;
//             }
//         }
//         chars[index++] = chars[chars.length-1];
//         if(count > 1){
//             for(char c : String.valueOf(count).toCharArray()){
//                 chars[index++] = c;
//             }
//         }
//         return index;
//     }
//     public static void main(String[] args) {

//         Q443StringCompression obj = new Q443StringCompression();
//         char[] chars = new char[]{'a','a','b','b','c','c','c'};
//         int index = obj.compress(chars);

//         System.out.println(Arrays.toString(chars));
//         System.out.println(index);
//         System.out.println(Arrays.toString(Arrays.copyOfRange(chars, 0, index)));
//         System.out.println(Arrays.toString(Arrays.copyOfRange(chars, 0, index+1)));

//     }
// }




// import java.util.*;
// class Solution {
//     public int compress(char[] chars) {
//         int i = 1;
//         int ans = 0;
        
//         int count = 1;
//         char v = chars[0];
//         while(i < chars.length){
//             if(v == chars[i]){
//                 count++;
//             }else{
//                 v = chars[i];
//                 chars[ans++] = chars[i-1];
//                 if(count > 1){
//                     String str = String.valueOf(count);
//                     for(char digit : str.toCharArray()){
//                         chars[ans++] = digit;
//                     }
//                 }
//                 count = 1;
//             }
//             i++;
//         }

//         chars[ans++] = chars[i-1];
//                 if(count > 1){
//                     String str = String.valueOf(count);
//                     for(char digit : str.toCharArray()){
//                         chars[ans++] = digit;
//                     }
//                 }

//         return ans;
//     }
//     public static void main(String[] args) {
//         Solution obj = new Solution();
//         char[] chars = new char[]{'a','a','b','b','c','c','c'};
//         int index = obj.compress(chars);
//         System.out.println(Arrays.toString(chars));
//         System.out.println(index);
//         System.out.println(Arrays.toString(Arrays.copyOfRange(chars, 0, index)));
//     }
// }






import java.util.*;
class Solution {
    public int compress(char[] chars) {
        int i = 0, res = 0;
        while (i < chars.length) {
            int groupLength = 1;
            while (i + groupLength < chars.length && chars[i + groupLength] == chars[i]) {
                groupLength++;
            }
            chars[res++] = chars[i];
            if (groupLength > 1) {
                for (char c : Integer.toString(groupLength).toCharArray()) {
                    chars[res++] = c;
                }
            }
            i += groupLength;
        }
        return res;
    }
    public static void main(String[] args) {
        Solution obj = new Solution();
        char[] chars = new char[]{'a','a','b','b','c','c','c'};
        int index = obj.compress(chars);
        System.out.println(Arrays.toString(chars));
        System.out.println(index);
        System.out.println(Arrays.toString(Arrays.copyOfRange(chars, 0, index)));
    }
}
