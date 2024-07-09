// import java.util.*;

// public class Q394DecodeString {
//     public String decodeString(String s){
//         Stack<Integer> st = new Stack<>();
//         Stack<StringBuilder> st1 = new Stack<>();
//         StringBuilder sb = new StringBuilder();
//         int num = 0;
        
//         for(char c : s.toCharArray()){
//             if(Character.isDigit(c)){
//                 num = num * 10 + c - '0';
//             } else if(Character.isLetter(c)){
//                 sb.append(c);
//             } else if(c == '['){
//                 st.push(num);
//                 st1.push(sb);
//                 sb = new StringBuilder();
//                 num = 0;
//             } else if(c == ']'){
//                 StringBuilder temp = st1.pop();
//                 int repeat = st.pop();
//                 for(int i = 0; i < repeat; i++){
//                     temp.append(sb);
//                 }
//                 sb = temp;
//             }
//         }
        
//         return sb.toString();
//     }
    
//     public static void main(String[] args) {
//         Q394DecodeString solution = new Q394DecodeString();
//         String s = "3[a2[c]]";
//         System.out.println(solution.decodeString(s)); // Output: accaccacc

//     }
// }




import java.util.*;

public class Q394DecodeString {
    public String decodeString(String s) {
        Stack<Integer> st = new Stack<>();
        Stack<StringBuilder> st1 = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = 0;

        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                n = n*10 + (c - '0');
            } else if (c == '['){
                st.push(n);
                n = 0;
                st1.push(sb);
                sb = new StringBuilder();
            } else if (c == ']'){
                int k = st.pop();
                StringBuilder temp = sb;
                sb = st1.pop();
                while(k-- > 0){
                    sb.append(temp);
                }
            } else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Q394DecodeString obj = new Q394DecodeString();
        String s = "3[a2[c]]";
        System.out.println(obj.decodeString(s)); // Output: accaccacc

        // 2nd
        s = "3[a]2[bc]";
        System.out.println(obj.decodeString(s)); // Output: abcabcbc
        
        // 3rd
        s = "2[abc]3[cd]ef";
        System.out.println(obj.decodeString(s)); // Output: cdefcdcdefcdc
    }
}
