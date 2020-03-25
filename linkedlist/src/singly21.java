public class singly21 {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;
    static Node head1;

    private static void add(Node head, Node node) {
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
        add(head, new Node(2));
        add(head, new Node(3));
        add(head, new Node(4));
        add(head, new Node(5));
        Node node1 = new Node(3);
        head1 = node1;
        add(head1, new Node(4));
        add(head1, new Node(5));
        add(head1, new Node(6));
        add(head1, new Node(7));
        findIntersec();
    }

    private static void findIntersec() {
        Node temp = head;
        Node temp1 = head1;
        while (temp != null && temp1 != null) {
            if (temp.data == temp1.data) {
                while (temp.data == temp1.data) {
                    System.out.println(temp.data + " " + temp1.data);
                    temp = temp.next;
                    temp1 = temp1.next;
                    if (temp == null || temp1 == null)
                        break;
                }
            } else if (temp.data > temp1.data) {
                temp1 = temp1.next;
            } else if (temp.data < temp1.data) {
                temp = temp.next;
            }
        }
    }
}
