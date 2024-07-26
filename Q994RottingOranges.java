import java.util.LinkedList;
import java.util.Queue;

public class Q994RottingOranges{
     public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> rotten=new LinkedList<>();
        int freshCount =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    rotten.offer(new int[]{i,j});
                }
                if(grid[i][j]==1)freshCount++;
            }
        }
        int rottenTime=0;
        int madeRotten=0;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!rotten.isEmpty()&& freshCount>0){
            rottenTime++;
            int queueSize = rotten.size();
            for(int i=0;i<queueSize;i++){
                int[] curr = rotten.poll();
                
                int x=curr[0];
                int y = curr[1];
                
                
                    
                    for(int j=0;j<4;j++){
                        int nx=x+dir[j][0];
                        int ny=y+dir[j][1];
                        if(nx>=0 && ny>=0 && nx<n && ny<m && grid[nx][ny]==1){
                            grid[nx][ny]=2;
                            rotten.offer(new int[]{nx,ny});
                            freshCount--;
                        }
                        
                    }
                
            }
        
        }
        return freshCount==0 ? rottenTime:-1 ;
    }
    public static void main(String[] args) {
        Q994RottingOranges rottenOranges = new Q994RottingOranges();
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(rottenOranges.orangesRotting(grid));
        
        grid = new int[][]{{2,1,1},{0,1,1},{1,0,1}};
        System.out.println(rottenOranges.orangesRotting(grid));
    }
}
