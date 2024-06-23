// 1431 Kids With Greatest Number Of Candies

import java.util.*;

public class Q1431KidsWithGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies){
        int maxCandies = 0;
        for(int candy : candies){
            maxCandies = Math.max(maxCandies, candy);
        }
        List<Boolean> result = new ArrayList<>();
        for(int candy : candies){
            result.add(candy + extraCandies >= maxCandies);
        }
        return result;
    }
    public static void main(String[] args) {

        Q1431KidsWithGreatestNumberOfCandies obj = new Q1431KidsWithGreatestNumberOfCandies();

        int[] candies = {2,3,5,1,3};

        int extraCandies = 3;
        List<Boolean> result = obj.kidsWithCandies(candies, extraCandies);
        System.out.println("This is first output = " + result);

        // System.out.println(Arrays.toString(result.toArray()));
        // System.out.println(Arrays.toString(result.toArray(new Boolean[result.size()])));

        // 2nd
        int[] candie = {4,2,1,1,2};extraCandies = 1;
        List<Boolean> result2 = obj.kidsWithCandies(candie, extraCandies);
        System.out.println("This is second output = " + result2);

        // 3rd
        int[] candi = {12,1,12}; extraCandies = 10;
        List<Boolean> result3 = obj.kidsWithCandies(candi, extraCandies);
        System.out.println("This is third output = " + result3);

    }
}
