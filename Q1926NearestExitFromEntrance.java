import java.util.LinkedList;
import java.util.Queue;

public class Q1926NearestExitFromEntrance {

    class Pair {
        int first;
        int second;
        int step;

        Pair(int fst, int scnd, int step) {
            this.first = fst;
            this.second = scnd;
            this.step = step;
        }
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;

        int x = entrance[0];
        int y = entrance[1];

        int delRow[] = {1, -1, 0, 0};
        int delCol[] = {0, 0, 1, -1};

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y, 0));

        maze[x][y] = '+';

        while (!q.isEmpty()) {
            Pair current = q.poll();
            int row = current.first;
            int col = current.second;
            int step = current.step;

            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && maze[nrow][ncol] == '.') {
                    if (nrow == 0 || ncol == 0 || nrow == n - 1 || ncol == m - 1) {
                        return step + 1;
                    }
                    maze[nrow][ncol] = '+';
                    q.add(new Pair(nrow, ncol, step + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q1926NearestExitFromEntrance obj = new Q1926NearestExitFromEntrance();

        char[][] maze = {
            {'+', '+', '.', '+'},
            {'.', '.', '.', '+'},
            {'+', '+', '+', '.'}
        };

        int[] entrance = {1, 2};
        System.out.println(obj.nearestExit(maze, entrance)); // Expected Output: 1

        char[][] maze2 = {
            {'+', '+', '+', '+', '+', '+'},
            {'.', '.', '.', '.', '.', '.'},
            {'+', '+', '+', '+', '+', '+'},
            {'+', '.', '.', '.', '.', '.'},
            {'+', '+', '+', '+', '+', '+'}
        };
        int[] entrance2 = {2, 3};
        System.out.println(obj.nearestExit(maze2, entrance2)); // Expected Output: -1


    }
}
