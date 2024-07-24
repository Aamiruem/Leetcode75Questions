
// import java.util.ArrayList;
// import java.util.List;
// public class Q547NumberOfProvinces {
//     @SuppressWarnings({ "unchecked", "rawtypes" })
//     public int findCircleNum(int[][] isConnected) {
//         int m = isConnected.length;
//         int n = isConnected[0].length;
//         List<List<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i < m; i++) {
//             adj.add(new ArrayList());
//         }
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (i == j) {
//                     continue;
//                 }
//                 if (isConnected[i][j] == 1) {
//                     adj.get(i).add(j);
//                 }
//             }
//         }
//         int[] vis = new int[m];
//         int count = 0;
//         for (int i = 0; i < m; i++) {
//             if (vis[i] != 1) {
//                 count++;
//                 dfs(i, adj, vis);
//             }
//         }
//         return count;
//     }
//     public void dfs(int v, List<List<Integer>> list, int[] vis) {
//         vis[v] = 1;
//         for (int i : list.get(v)) {
//             if (vis[i] != 1) {
//                 dfs(i, list, vis);
//             }
//         }
//     }
//     public static void main(String[] args) {
//         Q547NumberOfProvinces numberOfProvinces = new Q547NumberOfProvinces();
//         int[][] isConnected = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
//         System.out.println(numberOfProvinces.findCircleNum(isConnected)); //3
//         int[][] isConnected2 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
//         System.out.println(numberOfProvinces.findCircleNum(isConnected2)); //2
//         int[][] isConnected3 = {{1, 0, 0}, {0, 1, 1}, {0, 1, 1}};
//         System.out.println(numberOfProvinces.findCircleNum(isConnected3)); //2
//     }
// }











public class Q547NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        visited[i] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j);
            }
        }
    }
    public static void main(String[] args) {

        Q547NumberOfProvinces numberOfProvinces = new Q547NumberOfProvinces();
        int[][] isConnected = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        System.out.println(numberOfProvinces.findCircleNum(isConnected)); //3
        
        int[][] isConnected2 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(numberOfProvinces.findCircleNum(isConnected2)); //2
    }
}
