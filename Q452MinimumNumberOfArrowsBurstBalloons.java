// Greedy Algo
// TC: O 1 , SC: O 1
import java.util.Arrays;

public class Q452MinimumNumberOfArrowsBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b)-> Integer.compare(a[1], b[1]));
        int arrows= 1;
        int end=points[0][1];
        for(int i=1; i< points.length; i++){
            if(points[i][0] > end){
                arrows++;
                end= points[i][1];
            }
        }
        return arrows;
    }
    public static void main(String[] args) {
        Q452MinimumNumberOfArrowsBurstBalloons obj = new Q452MinimumNumberOfArrowsBurstBalloons();
        
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(obj.findMinArrowShots(points));

        int[][] points2 = {{1,2},{3,4},{5,6},{7,8}};
        System.out.println(obj.findMinArrowShots(points2));

        int[][] points3 = {{1,2},{2,3},{3,4},{4,5}};
        System.out.println(obj.findMinArrowShots(points3));
    }
}

// 1,6  2,8  7,12  10,16
