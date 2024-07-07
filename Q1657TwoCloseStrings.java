// import java.util.*;


// public class Q1657TwoCloseStrings{
//     public boolean closeStrings(String word1, String word2){
//         int n= word1.length();
//         int m= word2.length();
//         if(n!=m)
//             return false;
//         int[] freq1= new int[26];
//         int[] freq2= new int[26];
//         for(int i=0; i<n; i++){
//             freq1[word1.charAt(i)-'a']++;
//             freq2[word2.charAt(i)-'a']++;
//         }
//         for(int i=0; i<26; i++){
//             if((freq1[i]!=0 && freq2[i]==0) || (freq1[i]==0 && freq2[i]!=0))
//                 return false;
//         }
//         Arrays.sort(freq1);
//         Arrays.sort(freq2);
//         for(int i=0; i<26; i++){
//             if(freq1[i]!=freq2[i])
//                 return false;
//         }
//         return true;
//     }

//     public static void main(String[] args) {

//         Q1657TwoCloseStrings obj = new Q1657TwoCloseStrings();

//         String word1 = "cabbba";

//         String word2 = "abbccc";

//         boolean result = obj.closeStrings(word1, word2);

//         System.out.println("This is first output = " + result);

//     }
// }


import java.util.*;
public class Q1657TwoCloseStrings{
    public boolean closeStrings(String word1, String word2) {
        int n = word1.length();
        if (n != word2.length())  return false;    
        if (word1.equals(word2))  return true;   

        int[] count1 = new int['z' + 1];     
        int[] count2 = new int['z' + 1];    
        byte[] bytes = new byte[n];
        word1.getBytes(0, n, bytes, 0);     // Faster than String.toCharArray().
        for (byte b : bytes)  count1[b]++;
        
        word2.getBytes(0, n, bytes, 0);
        for (byte b : bytes)  count2[b]++;
        
        int maxFreq = 0;
        for (int i = 'a'; i <= 'z'; i++)
            maxFreq = Math.max(maxFreq, Math.max(count1[i], count2[i]));

        byte[] freq = new byte[maxFreq + 1];    
        int count = 0;
        for (int i = 'a'; i <= 'z'; i++) {
            int c1 = count1[i];
            int c2 = count2[i];
            if ((c1 == 0) ^ (c2 == 0))  return false;   
            if (c1 != 0) {
                int f1 = freq[c1]++;
                int f2 = freq[c2]--;
                if (f1 == 0)  count++;  else  if (f1 == -1)  count--;
                if (f2 == 0)  count++;  else  if (f2 ==  1)  count--;
            }
        }
        return count == 0;  
    }
        public static void main(String[] args) {

        Q1657TwoCloseStrings obj = new Q1657TwoCloseStrings();

        String word1 = "abc";

        String word2 = "bca";

        boolean result = obj.closeStrings(word1, word2);

        System.out.println("This is first output = " + result);

    }
}
