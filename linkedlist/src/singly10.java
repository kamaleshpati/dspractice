public class singly10 {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;

    static void add(Node node) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    static void print() {
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
        add(new Node(3));
        add(new Node(4));
        add(new Node(5));
        print();
        find(4);
    }

    private static void find(int i) {
        if (head == null)
            System.out.println("\nnull");
        Node temp = head;
        int count = 1;
        while (count < i && temp.next != null) {
            temp = temp.next;
            count++;
        }
        if (count < i)
            System.out.println("not possible");
        else {
            System.out.println();
            System.out.println(temp.data);
        }
    }
}
