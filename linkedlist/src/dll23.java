public class dll23 {
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
        rotate(3);
        System.out.println();
        printDouble();
    }

    private static void rotate(int count) {
        Node curr = head;
        Node temp = head;
        int c = 1;
        while (c < count) {
            curr = curr.next;
            c++;
        }
        head = curr;
        curr.prev.next = null;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
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
