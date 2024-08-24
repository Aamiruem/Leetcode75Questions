import java.util.Stack;
import java.util.Arrays;
public class Q739DailyTemperature {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }

        return result;        
    }
    public static void main(String[] args) {

        Q739DailyTemperature obj = new Q739DailyTemperature();

        int[] temperatures = {73,74,75,71,69,72,76,73};

        System.out.println(Arrays.toString(obj.dailyTemperatures(temperatures)));

    }
}
