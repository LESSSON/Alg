package arrAndLink;

import java.util.ArrayList;

public class SmallerEqualBigger {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node listPartition1(Node head, int pivot) {
        if(head == null || head.next == null) return head;
        Node cur = head;
        int i = 0;
        while(cur != null){
            i++;
            cur = cur.next;
        }
        cur = head;
        Node[] arr = new Node[i];
        for(int j = 0;j < arr.length; j++){
            arr[j] = cur;
            cur = cur.next;
        }
        arrPartition(arr,pivot);

        return arr[0];
    }

    public static void arrPartition(Node[] arr,int target){
        int less = -1;
        int more = arr.length;
        int i = 0;
        while(i != more){
            if(arr[i].value < target){
                swap(arr,i++,++less);
            }else if(arr[i].value == target){
                i++;
            }else {
                swap(arr,i,--more);
            }
        }
        for(int j = 0;j < arr.length - 1;j++){
            arr[j].next = arr[j + 1];
        }
        arr[arr.length - 1].next = null;
    }

    public static void swap(Node[] arr,int i, int j){
        Node tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static Node listPartition2(Node head, int pivot) {
        Node sH = null; // small head
        Node sT = null; // small tail
        Node eH = null; // equal head
        Node eT = null; // equal tail
        Node bH = null; // big head
        Node bT = null; // big tail
        Node next = null; //save next node

        if (head == null || head.next == null) {
            return head;
        }
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = sT.next;
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = eT.next;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = bT.next;
                }
            }
            head = next;

        }
        if (sT != null) {
            if (eH != null) {
                sT.next = eH;
                eT.next = bH;
            } else {
                sT.next = bH;
            }
            return sH;
        } else if (eT != null) {
            eT.next = bH;
            return eH;
        } else {
            return bH;
        }
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        head1 = listPartition1(head1, 5);
        printLinkedList(head1);

        head1 = listPartition2(head1, 5);
        printLinkedList(head1);

    }
}

