public class Q933NumberOfRecentCalls {
    private static final int[] records = new int[10000];
    private int start;
    private int end;

    public void RecentCounter(){
        start = 0;
        end = 0;
    }


    public int ping(int t){
        while(start< end && (t - records[start]> 3000)){
            start++;
        }

        records[end++] = t;

        return end - start;
    }

    public static void main(String[] args) {

        Q933NumberOfRecentCalls obj = new Q933NumberOfRecentCalls();

        obj.ping(1);

        obj.ping(100);

        obj.ping(3001);

        obj.ping(3002);

        System.out.println(obj.ping(3010));
        System.out.println(obj.ping(3011));
        System.out.println(obj.ping(3020));

    }
}
