import java.util.*;

public class Q2215FindDiffOf2Arrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2){
        List<List<Integer>> ans = new ArrayList<>();
        
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        
        for (int num : nums1) {
            set1.add(num);
        }
        
        for (int num : nums2) {
            set2.add(num);
        }
        
        HashSet<Integer> diff1 = new HashSet<>(set1);
        HashSet<Integer> diff2 = new HashSet<>(set2);
        
        diff1.removeAll(set2);  // Elements in set1 but not in set2
        diff2.removeAll(set1);  // Elements in set2 but not in set1
        
        ans.add(new ArrayList<>(diff1));
        ans.add(new ArrayList<>(diff2));
        
        return ans;
    }
    
    public static void main(String[] args) {
        Q2215FindDiffOf2Arrays obj = new Q2215FindDiffOf2Arrays();
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};
        List<List<Integer>> result = obj.findDifference(nums1, nums2);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
