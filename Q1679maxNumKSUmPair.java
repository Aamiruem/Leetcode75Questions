public class Q1679maxNumKSUmPair {
    public int maxOperations(int[] nums, int k){

        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == -1) continue;
            for(int j = i+1; j < nums.length; j++){
                if(nums[j] == -1) continue;
                if(nums[i] + nums[j] == k){
                    nums[i] = -1;
                    nums[j] = -1;
                    count++;
                    break;
                }
            }
        }  

        return count;
    }

    public static void main(String[] args) {

        Q1679maxNumKSUmPair obj = new Q1679maxNumKSUmPair();

        int[] nums = {1,2,3,4};

        int k = 5;

        int count = obj.maxOperations(nums, k);

        System.out.println(count);

    }
}
