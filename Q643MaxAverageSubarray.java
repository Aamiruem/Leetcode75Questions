public class Q643MaxAverageSubarray {

    public double findMaxAverage(int[] nums, int k) {
        double res = -1111;
        int i = 0;
        int j = 0;
        double sum = 0;
        while (j <= nums.length - 1) {
            sum += nums[j];
            if (j - i + 1 == k) {
                res = Math.max(res, (sum / k));
                sum -= nums[i++];
            }
            j++;
        }
        return res;
    }

    public static void main(String[] args) {

        Q643MaxAverageSubarray obj = new Q643MaxAverageSubarray();

        int[] nums = {1, 12, -5, -6, 50, 3};

        int k = 4;

        double result = obj.findMaxAverage(nums, k);

        System.out.println(result);

    }
}



