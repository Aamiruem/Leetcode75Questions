

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
        Q238ProductExceptSelf q238ProductExceptSelf = new Q238ProductExceptSelf();
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(nums));
        
        int[] ans = q238ProductExceptSelf.productExceptSelf(nums);
        System.out.println(Arrays.toString(ans));

    }
}
