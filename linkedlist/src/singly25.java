public class singly25 {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;

    private static void add(Node node) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    private static void print(Node head) {
        if (head == null)
            System.out.println("\nnull");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        head = node;
        add(new Node(2));
        add(new Node(2));
        add(new Node(3));
        add(new Node(3));
        add(new Node(3));
        add(new Node(4));
        add(new Node(4));
        add(new Node(4));
        add(new Node(2));
        add(new Node(2));
        add(new Node(3));
        add(new Node(3));
        add(new Node(3));
        add(new Node(4));
        add(new Node(4));
        add(new Node(4));
        print(head);
        reverse();
    }

    private static void reverse() {
        Node temp = head;
        Node rev = null;
        System.out.println();
        while (temp != null) {
            Node curr = temp;
            temp = temp.next;
            curr.next = rev;
            rev = curr;
        }
        print(rev);
    }
}
