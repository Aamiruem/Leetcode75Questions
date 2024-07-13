import java.util.*;
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// class Solution {
// public int pairSum(ListNode head) {
// List<Integer> values = new ArrayList<>();
// ListNode current = head;
// while(current != null){
// values.add(current.val);
// current = current.next;
// }
// List<Integer> twinSums = new ArrayList<>();
// int start = 0;
// int end = values.size() - 1;
// while(start <= end){
// twinSums.add(values.get(start++) + values.get(end--));
// }
// int maxTwinSum = 0;
// for(int sum : twinSums){
// if(sum> maxTwinSum){
// maxTwinSum = sum;
// }
// }
// return maxTwinSum;
// }
// }

public class Q2130MaximumTwinSum {

    public int pairSum(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode curr = head;
        int i = 0;

        while (curr != null) {
            map.put(i, curr.val);
            curr = curr.next;
            ++i;
        }

        int maxSum = 0;
        int start = 0, end = i - 1;
        while (start < end) {
            maxSum = Math.max(maxSum, map.get(start) + map.get(end));
            ++start;
            --end;
        }

        return maxSum;
    }
    public static void main(String[] args) {

        Q2130MaximumTwinSum obj = new Q2130MaximumTwinSum();
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(obj.pairSum(head)); // Output: 6

        head.next.next.next.next = new ListNode(1);
        System.out.println(obj.pairSum(head)); // Output: 10

        head.next.next.next.next.next = new ListNode(6);
        System.out.println(obj.pairSum(head)); // Output: 11
    }
}
