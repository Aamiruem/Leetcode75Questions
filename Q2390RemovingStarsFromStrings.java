// public class Q2390RemovingStarsFromStrings {
//     public String removeStars(String s){
//         StringBuilder sb = new StringBuilder();

//         for(int i = 0; i < s.length(); i++){
//             if(s.charAt(i) == '*'){
//                 sb.deleteCharAt(sb.length() - 1);
//             }else{
//                 sb.append(s.charAt(i));
//             }
//         }

//         return sb.toString();
//     }

//     public static void main(String[] args) {

//         Q2390RemovingStarsFromStrings obj = new Q2390RemovingStarsFromStrings();

//         String s = "leet**cod*e";

//         String result = obj.removeStars(s);

//         System.out.println("This is first output = " + result);

//     }
// }





public class Q2390RemovingStarsFromStrings {
    public String removeStars(String s){
        char[] arr = s.toCharArray();
        int n = arr.length;
        char[] arr2 = new char[n];
        int j =- 1;
        for(int i = 0; i<n; i++){
            if(arr[i]!= '*'){
                j++;
                arr2[j] = arr[i];
            }
            else{
                j--;
            }
        }
        String s2 = "";
        for(int i = 0; i<=j; i++){
            s2 = s2 + arr2[i];
        }
        return s2;
    }
    public static void main(String[] args) {

        Q2390RemovingStarsFromStrings obj = new Q2390RemovingStarsFromStrings();

        String s = "leet**cod*e";

        String result = obj.removeStars(s);

        System.out.println("This is first output = " + result);
        System.out.println();
    }
}
