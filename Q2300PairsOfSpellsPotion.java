
import java.util.Arrays;

public class Q2300PairsOfSpellsPotion {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        // sorting potions so that if we find the least potion we don't have to search
        // more O(m Log m)
        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {
            // for each spell finding the number and storing without using any extra space
            spells[i] = binarySearch(spells[i], potions, success);

        }
        return spells;

    }

    public int binarySearch(int num, int[] potions, long success) {

        int left = 0;
        int n = potions.length;
        int right = n - 1;
        // BINARY SEARCH O(Log nm)
        while (left < right) {
            int mid = (left + right) / 2;
            if ((long) num * potions[mid] < success) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // if last element check if its included cause aur algo can come and stop here
        // even if its not included
        if (left == n - 1) {
            if ((long) num * potions[left] < success) {
                return 0;
            }
        }
        // return the number of elements to the right of pointer
        return n - left;

    }

    public static void main(String[] args) {

        Q2300PairsOfSpellsPotion s = new Q2300PairsOfSpellsPotion();
        int[] spells = { 5, 1, 3 };
        int[] potions = { 1, 2, 3, 4, 5 };
        long success = 7;
        System.out.println(Arrays.toString(s.successfulPairs(spells, potions, success)));
    }
}
