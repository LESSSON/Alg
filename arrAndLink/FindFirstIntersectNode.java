package arrAndLink;

public class FindFirstIntersectNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }

        return null;

    }

    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node n1 = head.next; // n1 --> slow
        Node n2 = head.next.next; // n2 --> fast
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head; // h2 walk again from head
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node n1 = head1;
        Node n2 = head2;
        int n = 0;
        while (n1.next != null) {
            n++;
            n1 = n1.next;
        }
        while (n2.next != null) {
            n--;
            n2 = n2.next;
        }
        if (n1 != n2) {
            return null;
        }
        n1 = n > 0 ? head1 : head2;
        n2 = n1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n != 0) {
            n1 = n1.next;
            n--;
        }
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;


    }

    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        if (loop1 == loop2) {
            Node n1 = head1;
            Node n2 = head2;
            int n = 0;
            while (n1.next != loop1) {
                n++;
                n1 = n1.next;
            }
            while (n2.next != loop2) {
                n--;
                n2 = n2.next;
            }
            n1 = n > 0 ? head1 : head2;
            n2 = n1 == head1 ? head2 : head1;
            while (n != 0) {
                n1 = n1.next;
                n--;
            }
            while (n1 != n2) {
                n1 = n1.next;
                n2 = n2.next;
            }
            return n1;
        } else {
            Node n1 = loop1.next;
            while (n1 != loop1) {
                if (n1 == loop2) {
                    return n1;
                }
                n1 = n1.next;
            }

            return null;
        }
    }

    public static void main(String[] args) {
        Node[] nodes1 = new Node[10];
        Node[] nodes2 = new Node[8];
        for (int i = 0; i < nodes1.length; i++) {
            nodes1[i] = new Node(i);
        }
        for (int i = 0; i < nodes2.length; i++) {
            nodes2[i] = new Node(i * i);
        }
        for(int i = 0;i < nodes1.length - 1;i++){
            nodes1[i].next = nodes1[i+1];
        }
        for (int i = 0; i < nodes2.length - 1;i++){
            nodes2[i].next = nodes2[i+1];
        }
        nodes1[7] = nodes1[2];
        nodes2[3].next = nodes1[6];
        Node re = getIntersectNode(nodes1[0],nodes2[0]);
        if(re == null) System.out.println(re);
        else System.out.println(re.value);

    }
}
