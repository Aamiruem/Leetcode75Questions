
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q901StockSpanner {

    Stack<Integer> st;
    List<Integer> list;

    public void StockSpanner() {
        st = new Stack<>();
        list = new ArrayList<>();
    }

    //Simple approach :  We will calculate the previous greatest element....
    public int next(int price) {
        list.add(price);
        while (!st.isEmpty() && list.get(st.peek()) <= price) {
            st.pop();
            //remove index because the index will never become a 
            //previous greatest element as it is smaller       
            //than the current element itself hence we found a bigger 
            //number than the number present at that particular index...
        }
        int PGI;
        if (!st.isEmpty()) {
            PGI = st.peek();//if previous greaters element exist......
        } else {
            PGI = -1;//if no previous greatest element present...
        }
        st.push(list.size() - 1);//add the current price to the list.....
        return (list.size() - 1) - PGI;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner(); int param_1 = obj.next(price);
 */
