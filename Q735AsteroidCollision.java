// import java.util.*;

// public class Q735AsteroidCollision{
//     public int[] asteroidCollision(int[] asteroids){
//         List<Integer> list = new ArrayList<>();
//         for(int asteroid : asteroids){
//             while(!list.isEmpty() && asteroid < 0 && list.get(list.size() - 1) > 0){
//                 if(Math.abs(asteroid) > Math.abs(list.get(list.size() - 1))){
//                     list.remove(list.size() - 1);
//                 }else{
//                     break;
//                 }
//             }
//             if(!list.isEmpty() || asteroid > 0){
//                 list.add(asteroid);
//             }
//         }
//         return list.stream().mapToInt(Integer::intValue).toArray();
//     }
    
//     public static void main(String[] args){
//         Q735AsteroidCollision asteroidCollision = new Q735AsteroidCollision();
//         int[] asteroids = {5, 10, -5};
//         int[] result = asteroidCollision.asteroidCollision(asteroids);
//         System.out.println(Arrays.toString(result)); // Output: [5, 10]
//     }
// }











// import java.util.*;

// public class Q735AsteroidCollision{
// public int[] asteroidCollision(int[] asteroids) {
    //         int dom[] = null;
    //         Stack<Integer> ans = new Stack();
    //         for(int i = 0; i<asteroids.length; i++){
    //             if(!ans.isEmpty() && asteroids[i] < 0){
    //                 if(ans.peek() == Math.abs(asteroids[i])){
    //                     ans.pop();
    //                     continue;
    //                 }
    //                 while(!ans.isEmpty() && ans.peek() > 0 && ans.peek()<Math.abs(asteroids[i]) ){
    //                     ans.pop();
    //                 }
    //                 if(!ans.isEmpty() && ans.peek() > 0){
    //                     if(ans.peek() == Math.abs(asteroids[i])){
    //                         ans.pop();
    //                     }
    //                 } else{
    //                     ans.add(asteroids[i]);
    //                 }
    //             } else{
    //                 ans.add(asteroids[i]);
    //             }
    //         }
    //         dom = new int[ans.size()];
    //         for(int i = 0; i<ans.size(); i++){
    //             dom[i] = ans.get(i);
    //         }
    //         return dom;
    //     }
//     public static void main(String[] args) {
//         Q735AsteroidCollision obj = new Q735AsteroidCollision();
//         int[] asteroids = {5, 10, -5};
//         int[] result = obj.asteroidCollision(asteroids);
//         System.out.println(Arrays.toString(result)); // Output: [5, 10]

//     }
// }
    












import java.util.*;

public class Q735AsteroidCollision{
    public int[] asteroidCollision(int[] asteroids){
        Stack<Integer> stack = new Stack<>();
        for(int a : asteroids){
            if(a>0){
                stack.push(a);
            } else{
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -a){
                    stack.pop();
                }
                if(!stack.isEmpty() || stack.peek() <0){
                    stack.push(a);
                } 
                if(stack.peek() == -a){
                    stack.pop();
                }
            }
        }
        int res[] = new int[stack.size()];
        int i = stack.size() - 1;
        while(!stack.isEmpty()){
            res[i--] = stack.pop();
        }
        return res;
    }
    public static void main(String[] args) {
        Q735AsteroidCollision obj = new Q735AsteroidCollision();
        int[] asteroids = {5, 10, -5};
        int[] result = obj.asteroidCollision(asteroids);
        System.out.println(Arrays.toString(result)); // Output: [5, 10]

    }
}
