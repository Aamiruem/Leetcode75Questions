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

public class Q206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        while(curr!= null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next == null){
                break;
            }
            next = next.next;
        }
        return prev;
    }
    public static void main(String[] args) {

        Q206ReverseLinkedList obj = new Q206ReverseLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        System.out.print("Original Linked List: ");
        ListNode current = head;
        while (current!= null) {
            System.out.print(current.val + " ");
            current = current.next;
        }

        System.out.println("\n");

        System.out.print("Reversed Linked List: ");
        ListNode reversedList = obj.reverseList(head);
        while (reversedList!= null) {
            System.out.print(reversedList.val + " ");
            reversedList = reversedList.next;

        }
        // Output: 3 2 1
        // Time complexity: O(n), where n is the number of nodes in the linked list
        // Space complexity: O(1)
        // This solution reverses the linked list in-place, without creating a new list
        // It uses three pointers to swap the next pointers of each node
        // and then moves the pointers forward
        // This approach is efficient and avoids extra memory usage
        // The time complexity is O(n) because we need to traverse the linked list once
        // The space complexity is O(1) because we only use a few pointers to keep track of the nodes
        // The solution also meets the requirement of using constant extra space
    }
}
