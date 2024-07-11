import java.util.*;

public class Q949Dota2Senate {

    public String predictPartyVictory(String senate) {

        int n = senate.length();

        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dir = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.add(i);
            } else {
                dir.add(i);
            }
        }

        while (!radiant.isEmpty() && !dir.isEmpty()) {
            if (radiant.peek() < dir.peek()) {
                radiant.add(n++); // add = poll
            } else {
                dir.add(n++);
            }
            radiant.poll();
            dir.poll();
        }

        return radiant.isEmpty() ? ("Dire") : ("Radiant");
    }

    public static void main(String[] args) {

        Q949Dota2Senate obj = new Q949Dota2Senate();

        String senate = "RD";

        System.out.println(obj.predictPartyVictory(senate));


        String senate1 = "RDD";

        System.out.println(obj.predictPartyVictory(senate1));

    }
}
