
//  * Definition for singly-linked list.
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

public class Q328OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = odd.next;
        ListNode oddTail = odd;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            oddTail = oddTail.next;

            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        Q328OddEvenLinkedList oddEvenLinkedList = new Q328OddEvenLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        System.out.println("Original List:");
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
        System.out.println("List after odd-even rearrangement:");

        ListNode result = oddEvenLinkedList.oddEvenList(head);
        while (result!= null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        // Output: 1 2 3 4
        // Explanation: The odd nodes are 1, 3, and 5.
        // The even nodes are 2, 4.

    }
}
