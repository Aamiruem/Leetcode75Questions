import java.util.*;

public class Q443StringCompression {
    public int compress(char[] chars){
        int count = 1;
        int index = 0;
        for(int i = 1; i < chars.length; i++){
            if(chars[i] == chars[i-1]){
                count++;
            }else{
                chars[index++] = chars[i-1];
                if(count > 1){
                    for(char c : String.valueOf(count).toCharArray()){
                        chars[index++] = c;
                    }
                }
                count = 1;
            }
        }
        chars[index++] = chars[chars.length-1];
        if(count > 1){
            for(char c : String.valueOf(count).toCharArray()){
                chars[index++] = c;
            }
        }
        return index;
    }
    public static void main(String[] args) {

        Q443StringCompression obj = new Q443StringCompression();
        char[] chars = new char[]{'a','a','b','b','c','c','c'};
        int index = obj.compress(chars);
        
        System.out.println(Arrays.toString(chars));
        System.out.println(index);
        System.out.println(Arrays.toString(Arrays.copyOfRange(chars, 0, index)));
        System.out.println(Arrays.toString(Arrays.copyOfRange(chars, 0, index+1)));

    }
}
