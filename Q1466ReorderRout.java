
// import java.util.LinkedList;
// public class Q1466ReorderRout {
//     public int minReorder(int n, int[][] connections) {
//         @SuppressWarnings("unchecked")
//         LinkedList<int[]>[] g = new LinkedList[n];
//         for (int i = 0; i != n; ++i) {
//             g[i] = new LinkedList<>();  //create graph   
//                 }for (int[] c : connections) {             //put all edges 
//             g[c[0]].add(new int[]{c[1], 1});     //index[1] == 1 - road is present
//             g[c[1]].add(new int[]{c[0], 0});     //index[1] == 0 - road is absent
//         }
//         int[] vis = new int[n];
//         int reorderRoads = 0;
//         LinkedList<Integer> q = new LinkedList<>();             //queue for BFS
//         q.add(0);
//         while (!q.isEmpty()) {                                   //BFS  
//             int city = q.poll();
//             if (vis[city] == 1) {
//                 continue;
//             }
//             vis[city] = 1;
//             for (int[] neib : g[city]) {
//                 if (vis[neib[0]] == 0) {
//                     q.add(neib[0]);
//                     if (neib[1] == 1) {
//                         ++reorderRoads;
//                     }
//                 }
//             }
//         }
//         return reorderRoads;
//     }
//     public static void main(String[] args) {
//         Q1466ReorderRout obj = new Q1466ReorderRout();
//         int n = 6;
//         int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
//         System.out.println(obj.minReorder(n, connections)); // Output: 3
//     }
// }











import java.util.LinkedList;
public class Q1466ReorderRout {

    public int minReorder(int n, int[][] connections) {
        @SuppressWarnings("unchecked")
        LinkedList<int[]>[] g = new LinkedList[n];
        for (int i = 0; i != n; ++i) {
            g[i] = new LinkedList<>();  //create graph   

                }for (int[] c : connections) {             //put all edges 
            g[c[0]].add(new int[]{c[1], 1});     //index[1] == 1 - road is present
            g[c[1]].add(new int[]{c[0], 0});     //index[1] == 0 - road is absent
        }

        int[] vis = new int[n];
        int reorderRoads = 0;
        LinkedList<Integer> q = new LinkedList<>();             //queue for BFS
        q.add(0);
        while (!q.isEmpty()) {                                   //BFS  
            int city = q.poll();
            if (vis[city] == 1) {
                continue;
            }
            vis[city] = 1;

            for (int[] neib : g[city]) {
                if (vis[neib[0]] == 0) {
                    q.add(neib[0]);
                    if (neib[1] == 1) {
                        ++reorderRoads;
                    }
                }
            }
        }

        return reorderRoads;
    }
    public static void main(String[] args) {
        Q1466ReorderRout obj = new Q1466ReorderRout();
        int n = 6;
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        System.out.println(obj.minReorder(n, connections)); // Output: 3

        // Test Case 2
        n = 5;
        int[][] connections1 = {{1, 0}, {1, 2}, {3, 2}, {3, 4}};
        System.out.println(obj.minReorder(n, connections1)); // Output: 2
        // Test Case 3
        n = 3;
        int[][] connections2 = {{1, 0}, {2, 0}};
        System.out.println(obj.minReorder(n, connections2)); // Output: 0
    }
}
