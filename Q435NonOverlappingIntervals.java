import java.util.Arrays;

public class Q435NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int prev = 0;
        int count  = 1;

        for(int i = 1; i< n; i++){
            if(intervals[i][0] >= intervals[prev][1]){
                prev = i;
                count ++;

            }
        }
        return n - count;
    }
    public static void main(String[] args) {
        Q435NonOverlappingIntervals obj = new Q435NonOverlappingIntervals();
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(obj.eraseOverlapIntervals(intervals));

        int[][] intervals1 = {{1,2},{1,2},{1,2}};
        System.out.println(obj.eraseOverlapIntervals(intervals1));

        int[][] intervals2 = {{1,2},{2,3}};
        System.out.println(obj.eraseOverlapIntervals(intervals2));


    }  
}
