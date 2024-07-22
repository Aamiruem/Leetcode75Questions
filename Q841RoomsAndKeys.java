
import java.util.*;

//Q841RoomsAndKey
public class Q841RoomsAndKeys {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> keys = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        for (int ele : rooms.get(0)) {
            keys.push(ele);

        }
        while (!keys.isEmpty()) {
            int key = keys.pop();
            if (!visited.contains(key)) {
                visited.add(key);
            }
            for (int ele : rooms.get(key)) {
                if (!visited.contains(ele)) {
                    keys.push(ele);
                }
            }
        }
        if(visited.size() == rooms.size()){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {

        Q841RoomsAndKeys roomsAndKeys = new Q841RoomsAndKeys();

        List<List<Integer>> rooms = new ArrayList<>();


        rooms.add(Arrays.asList(1, 3));
        rooms.add(Arrays.asList(3, 0, 1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(0));

        System.out.println(roomsAndKeys.canVisitAllRooms(rooms));

        


        
        // Expected output: true
        rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(Arrays.asList());
        
        System.out.println(roomsAndKeys.canVisitAllRooms(rooms));
        
    }
}
