package arrAndLink;

import java.util.Stack;

public class IsPalindromeList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    //need n extra space
    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(head);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.value != stack.pop().value) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    //need n/2 extra space
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node cur = head; // slow
        Node fast = head.next; //fast
        Stack<Node> stack = new Stack<>();
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            cur = cur.next;
        }
        cur = cur.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
        }
        return true;
    }

    // Only need O(1) space
    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = n1.next; // n2 --> right part first node
        n1.next = null; // mid.next -> null
        Node n3 = null;
        while (n2.next != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1; // 保存最后一个节点，以后还原
        n2 = head; // 去第一个节点
        boolean res = true;
        while (n1 != null && n2 != null) {
            if(n1.value != n2.value){ // 不能直接return因为链表还未还原
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        // 还原过程
        n1 = n3.next;
        n3 = null;
        while (n1.next!=null){
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }
}
