public class Q605CanPlaceFlower {
    public boolean canPlaceFlowers(int[] flowerbed, int n){
        if(n == 0){
            return true;
        }

        for(int i = 0; i < flowerbed.length; i++){
            if(flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)){
                flowerbed[i] = 1;
                n--;
            }
            if(n == 0){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Q605CanPlaceFlower obj = new Q605CanPlaceFlower();

        int[] flowerbed = {1,0,0,0,1};

        int n = 1;

        boolean result = obj.canPlaceFlowers(flowerbed, n);

        System.out.println("This is first output = " + result);


        // 2nd

        int[] flowerbed2 = {1,0,0,0,1};

        int n2 = 2;

        boolean result2 = obj.canPlaceFlowers(flowerbed2, n2);

        System.out.println("This is second output = " + result2);
    }
}
