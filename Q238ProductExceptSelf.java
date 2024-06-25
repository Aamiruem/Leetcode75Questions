
import java.util.*;
public class Q238ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];

        for (int i = 0; i < n; i++) {
            int pro = 1;
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                pro *= nums[j];
            }
            ans[i] = pro;
        }

        return ans;
    }

    public static void main(String[] args) {
        Q238ProductExceptSelf ps = new Q238ProductExceptSelf();
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(nums));
        
        int[] ans = ps.productExceptSelf(nums);
        System.out.println(Arrays.toString(ans));

        System.out.println(" ");

        //2nd
        int[] nums2 = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(nums2));
        
        int[] ans2 = ps.productExceptSelf(nums2);
        System.out.println(Arrays.toString(ans2));

    }
}
