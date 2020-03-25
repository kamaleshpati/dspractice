public class singly17 {
    static class Node {
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

    private static void print() {
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
        print();
        removeDuplicate();
        System.out.println();
        print();
    }

    private static void removeDuplicate() {
        Node temp = head;
        while (temp != null) {
            Node temp1 = temp;
            while (temp1.next != null) {
                if (temp.data == temp1.next.data) {
                    temp1.next = temp1.next.next;
                } else {
                    temp1 = temp1.next;
                }
            }
            temp = temp.next;
        }
    }
}
