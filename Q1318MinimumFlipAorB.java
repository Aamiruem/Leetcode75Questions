
public class Q1318MinimumFlipAorB {

    public int minFlips(int a, int b, int c) {
        int flips = 0;
        int or = a | b;

        for (int i = 0; i < 32; i++) {
            if ((or & (1 << i)) != (c & (1 << i))) {

                System.out.println((or&(1<<i)) +" "+ (c&(1<<i)));
                if ((or & (1 << i)) == 0) {
                    flips++;
                } else {
                    if ((a & (1 << i)) != 0) {
                        flips++;
                    }
                    if ((b & (1 << i)) != 0) {
                        flips++;
                    }
                }
            }
        }
        return flips;
    }

    public static void main(String[] args) {

        Q1318MinimumFlipAorB obj = new Q1318MinimumFlipAorB();
        int a = 2, b = 6, c = 5;
        System.out.println(obj.minFlips(a, b, c));

        System.out.println();

        int a1 = 4, b1 = 2, c1 = 7;
        System.out.println(obj.minFlips(a1, b1, c1));


    }
}
