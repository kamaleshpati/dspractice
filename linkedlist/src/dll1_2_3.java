public class dll1_2_3 {
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
        deleteFirst();
        System.out.println();
        printDouble();
        deleteLast();
        System.out.println();
        printDouble();
        delete(2);
        System.out.println();
        printDouble();
        add(new Node(2));
        add(new Node(3));
        add(new Node(4));
        add(new Node(5));
        System.out.println();
        printDouble();
        System.out.println();
        rev();
        System.out.println();
        printDouble();
    }

    private static void rev() {
        Node cur = head;
        Node temp = null;
        while (cur != null) {
            temp = cur.prev;
            cur.prev = cur.next;
            cur.next = temp;
            cur = cur.prev;
        }
        head = temp.prev;
    }

    private static void delete(int i) {
        Node temp = head;
        int count = 1;
        while (count < i - 1) {
            temp = temp.next;
            count++;
        }
        Node temp1 = temp.next;
        temp.next = temp.next.next;
        temp1.next = null;
        temp1.prev = null;
    }

    private static void deleteLast() {
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        Node temp1 = temp.next;
        temp.next = null;
        temp1.prev = null;
    }

    private static void deleteFirst() {
        Node temp = head;
        temp = temp.next;
        temp.prev = null;
        head = temp;
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
