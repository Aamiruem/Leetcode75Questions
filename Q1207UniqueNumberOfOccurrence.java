import java.util.*;

public class Q1207UniqueNumberOfOccurrence {
    public boolean uniqueOccurrences(int[] arr){
        Map<Integer, Integer> countMap = new HashMap<>(arr.length);
        Set<Integer> set = new HashSet<>(arr.length);
        for(int i: arr){
            Integer count = countMap.get(i);
            if(count == null){
                count = 1;
            }else{
                count++;
            }
            countMap.put(i, count);
        }
        for(int count: countMap.values()){
            if(!set.add(count)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Q1207UniqueNumberOfOccurrence obj = new Q1207UniqueNumberOfOccurrence();

        int[] arr = {1, 2, 2, 1, 1, 3};

        boolean result = obj.uniqueOccurrences(arr);

        System.out.println("This is first output = " + result);

    }
}
