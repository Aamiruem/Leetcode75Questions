import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

public class Q399EvaluateDivision {
    // instance variable to store the result of the DFS
    double val;

    // DFS function to find the path from src to dst and calculate the value
    public void dfs(Map<String, List<Pair<String, Double>>> adj, String src, String dst, double curVal, Set<String> visited) {
        // if we reach the destination, store the result in the instance variable
        if (src.equals(dst)) {
            val = curVal;
            return;
        }
        // mark the current node as visited
        visited.add(src);
        // iterate over the neighbors of the current node
        for (Pair<String, Double> p : adj.get(src)) {
            // if the neighbor is not visited, recursively call the DFS function
            if (!visited.contains(p.getKey())) {
                dfs(adj, p.getKey(), dst, curVal * p.getValue(), visited); // multiply the current value with the edge value
            }
        }
    }

    // main function to calculate the equations
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        // create an adjacency list to store the graph
        Map<String, List<Pair<String, Double>>> adj = new HashMap<>();
        // iterate over the equations and build the graph
        for (int i = 0; i < n; i++) {
            List<String> eq = equations.get(i);
            String u = eq.get(0);
            String v = eq.get(1);
            double w = values[i];
            // add an edge from u to v with weight w
            adj.putIfAbsent(u, new ArrayList<>());
            adj.get(u).add(new Pair<>(v, w));
            // add an edge from v to u with weight 1/w (inverse of w)
            adj.putIfAbsent(v, new ArrayList<>());
            adj.get(v).add(new Pair<>(u, 1 / w));
        }
        int m = queries.size();
        // create an array to store the results
        double[] ans = new double[m];
        // iterate over the queries
        for (int i = 0; i < m; i++) {
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);
            // if the graph does not contain u, there is no path from u to v
            if (!adj.containsKey(u)) {
                ans[i] = -1.0;
                continue;
            }
            // reset the result variable
            val = -1.0;
            // perform DFS from u to v
            dfs(adj, u, v, 1.0, new HashSet<>());
            ans[i] = val;
        }
        return ans;
    }

    public static void main(String[] args) {
        Q399EvaluateDivision evaluateDivision = new Q399EvaluateDivision();
        List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c"));
        double[] values = new double[]{2.0, 3.0};
        List<List<String>> queries = List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("b", "e"), List.of("c", "e"));
        double[] result = evaluateDivision.calcEquation(equations, values, queries);
        System.out.println(result); // [6.0, 0.5, -1.0, -1.0, 1.0]
    }
}










// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Map;
// import java.util.Set;

// class Pair<K, V> {
//     private K key;
//     private V value;

//     public Pair(K key, V value) {
//         this.key = key;
//         this.value = value;
//     }

//     public K getKey() {
//         return key;
//     }

//     public V getValue() {
//         return value;
//     }
// }

// public class Q399EvaluateDivision {

//     private double val;

//     public void dfs(Map<String, List<Pair<String, Double>>> adj, String src, String dst, double curVal, Set<String> visited) {
//         if (src.equals(dst)) {
//             val = curVal;
//             return;
//         }

//         visited.add(src);

//         for (Pair<String, Double> p : adj.get(src)) {
//             if (!visited.contains(p.getKey())) {
//                 dfs(adj, p.getKey(), dst, curVal * p.getValue(), visited);
//             }
//         }
//     }

//     public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

//         int n = equations.size();

//         Map<String, List<Pair<String, Double>>> adj = new HashMap<>();

//         for (int i = 0; i < n; i++) {
//             List<String> eq = equations.get(i);
//             String u = eq.get(0);
//             String v = eq.get(1);
//             double w = values[i];

//             adj.putIfAbsent(u, new ArrayList<>());
//             adj.get(u).add(new Pair<>(v, w));
//             adj.putIfAbsent(v, new ArrayList<>());
//             adj.get(v).add(new Pair<>(u, 1 / w));
//         }

//         int m = queries.size();
//         double[] ans = new double[m];

//         for (int i = 0; i < m; i++) {
//             String u = queries.get(i).get(0);
//             String v = queries.get(i).get(1);

//             if (!adj.containsKey(u)) {
//                 ans[i] = -1.0;
//                 continue;
//             }

//             val = -1.0;
//             dfs(adj, u, v, 1.0, new HashSet<>());
//             ans[i] = val;
//         }

//         return ans;
//     }

//     public static void main(String[] args) {
//         Q399EvaluateDivision evaluateDivision = new Q399EvaluateDivision();
//         List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c"));
//         double[] values = {2.0, 3.0};
//         List<List<String>> queries = List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("b", "c"));
//         double[] results = evaluateDivision.calcEquation(equations, values, queries);
//         System.out.println("Results: ");
//         for (double result : results) {
//             System.out.println(result);
//         }
//     }
// }
