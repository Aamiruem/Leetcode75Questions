// import java.util.Arrays;
// import java.util.HashMap;

// public class Q2352EqualRowAndCol{
    // public boolean helper(int []row , int []col)
//     {
//         for( int i = 0 ;  i  < row.length ; i++)
//         {
//              if(row[i] != col[i]) return false;
//         }
//         return true;
//     }
//     public int equalPairs(int[][] row) {
//         int col [][]= new int [row.length][row.length];
//         for ( int i = 0 ; i < row.length ; i++)
//         {   int tem[] = new int [row.length];
//             for ( int j = 0 ; j< row.length ; j++)
//             {
//                 tem[j] = row[j][i];
//             }
//             col[i] =tem;
//         }
//         int count =0;
//         for ( int i = 0 ; i < row.length ; i++)
//         {
//             for( int j =0 ; j < row.length ; j++)
//             {
//                 if (helper(row[i],col[j]))
//                 {
//                     count++;
//                 }
//             }
//         }
//         return count;
        
//     }
// }










import java.util.Arrays;
import java.util.HashMap;

public class Q2352EqualRowAndCol{
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        HashMap<Integer, int[]> r = new HashMap<>();
        HashMap<Integer, int[]> c = new HashMap<>();
        for(int i = 0; i < n; i++){
            r.put(i, grid[i]);
        }
        for (int i = 0; i < n; i++) {
            int[] column = new int[n];
            for (int j = 0; j < n; j++) {
                column[j] = grid[j][i];
            }
            c.put(i, column);
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                if(Arrays.equals(r.get(i), c.get(j))){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Q2352EqualRowAndCol obj = new Q2352EqualRowAndCol();
        int grid[][] = {{3,2,1},{1,7,6},{2,7,7}};
        System.out.println(obj.equalPairs(grid));
        // Expected output: 1
        grid = new int[][] {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        System.out.println(obj.equalPairs(grid));
        // Expected output: 3
        grid = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(obj.equalPairs(grid));
        // Expected output: 0
        grid = new int[][] {{1,1,1},{1,1,1},{1,1,1}};
        System.out.println(obj.equalPairs(grid));
        // Expected output: 9
        
    }
}
