public class dll7 {

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int d) {
            data = d;
            prev = null;
            next = null;
        }
    }

    static Node head;

    public static void main(String[] args) {
        Node node = new Node(1);
        head = node;
        add(new Node(2));
        add(new Node(3));
        add(new Node(4));
        add(new Node(5));
        printDouble();
        System.out.println();
        swapKth(2);
        System.out.println();
        printDouble();
    }

    private static void swapKth(int i) {
        Node temp = head;
        Node temp1 = head;
        while (temp1.next != null) {
            temp1 = temp1.next;
        }
        int count = 0;
        while (count < i - 1) {
            temp = temp.next;
            temp1 = temp1.prev;
            count++;
        }
        if (temp.equals(temp1)) {
            return;
        } else {
            Node temp_ = temp.prev;
            Node temp1_ = temp1.prev;
            temp_.next = temp1;
            temp1_.next = temp;
            Node node = temp.next;
            temp.next = temp1.next;
            temp1.next = node;
        }

    }


    private static void printDouble() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
    }

    private static void add(Node node) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
    }
}
