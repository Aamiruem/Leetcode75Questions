
// import java.util.*;

// public class Q2336SmallestNumberInfiniteSet {

//     PriorityQueue<Integer> pq;

//     public void SmallestInfiniteSet() {
//         pq = new PriorityQueue<>();
//         for (int i = 1; i <= 1000; i++) {
//             pq.add(i);
//         }
//     }

//     public int popSmallest() {
//         // return pq.poll();
//         int element = pq.remove();
//         return element;
//     }

//     public void addBack(int num) {
//         if (!pq.contains(num)) {
//             pq.remove(num);
//             pq.add(num);
//         }
//     }

//     public int getCount() {
//         return pq.size();
//     }

//     public static void main(String[] args) {
//         Q2336SmallestNumberInfiniteSet obj = new Q2336SmallestNumberInfiniteSet();
//         obj.SmallestInfiniteSet();
//         System.out.println(obj.popSmallest()); // 1
//         System.out.println(obj.getCount()); // 1000
//         obj.addBack(1000);
//         System.out.println(obj.getCount()); // 1001
//         System.out.println(obj.popSmallest()); // 1000
//         System.out.println(obj.getCount()); // 1000
//         System.out.println(obj.popSmallest()); // 1
//         System.out.println(obj.getCount()); // 999
//     }
// }










import java.util.PriorityQueue;

public class Q2336SmallestNumberInfiniteSet {

    PriorityQueue<Integer> pq;

    public Q2336SmallestNumberInfiniteSet() {
        pq = new PriorityQueue<>();
        for (int i = 1; i <= 1000; i++) {
            pq.add(i);
        }
    }

    public int popSmallest() {
        return pq.poll();
    }

    public void addBack(int num) {
        if (!pq.contains(num)) {
            pq.add(num);
        }
    }

    public int getCount() {
        return pq.size();
    }

    public static void main(String[] args) {
        Q2336SmallestNumberInfiniteSet obj = new Q2336SmallestNumberInfiniteSet();
        
        System.out.println(obj.popSmallest()); // Should print 1
        System.out.println(obj.popSmallest()); // Should print 2
        obj.addBack(1);
        System.out.println(obj.popSmallest()); // Should print 1
        System.out.println(obj.getCount()); // Should print the remaining count
    }
}
