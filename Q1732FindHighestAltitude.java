// public class Q1732FindHighestAltitude {
//     public int largestAltitude(int[] gain){
//         int maxAltitude = 0;

//         for(int i = 0; i < gain.length; i++){
//             maxAltitude = Math.max(maxAltitude, gain[i] + i);
//         }

//         return maxAltitude;
//     }

//     public static void main(String[] args) {

//         Q1732FindHighestAltitude obj = new Q1732FindHighestAltitude();

//         int[] gain = {-5,1,5,0,-7};

//         int result = obj.largestAltitude(gain);

//         System.out.println("This is first output = " + result);

//     }
// }







public class Q1732FindHighestAltitude {
    public int largestAltitude(int[] gain) {
        int highestAltitude = 0;
        int altitude = 0;
        
        for (int i = 0; i < gain.length; i++) {
            altitude += gain[i];
            if (altitude > highestAltitude) {
                highestAltitude = altitude;
            }
        }
        
        return highestAltitude;
    }

    public static void main(String[] args) {
        Q1732FindHighestAltitude obj = new Q1732FindHighestAltitude();
        
        int[] gain = {-5, 1, 5, 0, -7};
        
        int result = obj.largestAltitude(gain);
        
        System.out.println("This is the first output = " + result);
    }
}
