public class Q334IncreasingTripletSubsequence {
    public boolean increasingTriplet(int nums[]){
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= first){
                first = nums[i];
            }else if(nums[i] <= second){
                second = nums[i];
            }else{
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Q334IncreasingTripletSubsequence q = new Q334IncreasingTripletSubsequence();
        int[] nums = {1,2,3,4,5};
        System.out.println(q.increasingTriplet(nums));

        System.out.println(q.increasingTriplet(new int[]{5,4,3,2,1}));

        // System.out.println(q.increasingTriplet(new int[]{5,1,5,5,2,5,4}));

        
    }
}
