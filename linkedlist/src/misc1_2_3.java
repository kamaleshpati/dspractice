public class misc1_2_3 {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node head;

    static class SkipNode {
        Node down;
        SkipNode next;

        SkipNode(Node node) {
            this.down = node;
            this.next = null;
        }
    }

    static SkipNode sHead;

    public static void main(String[] args) {
        Node node = new Node(1);
        head = node;
        add(new Node(2));
        add(new Node(3));
        Node node1 = new Node(4);
        add(node1);
        add(new Node(5));
        add(new Node(6));
        Node node2 = new Node(7);
        add(node2);
        add(new Node(8));
        add(new Node(9));
        printDouble();
        sHead = new SkipNode(node);
        sHead.next = new SkipNode(node1);
        sHead.next.next = new SkipNode(node2);
        insert(new Node(5));
        System.out.println();
        printDouble();
        delete(new Node(5));
        System.out.println();
        printDouble();
    }

    private static void delete(Node node) {
        while (sHead.next.down.data < node.data && sHead.next != null) {
            sHead = sHead.next;
        }
        Node temp = sHead.down;
        while (temp.next.data != node.data) {
            temp = temp.next;
        }
        Node n = temp.next;
        temp.next = temp.next.next;
        n.next = null;
    }

    private static void insert(Node node) {
        while (sHead.next.down.data < node.data && sHead.next != null) {
            sHead = sHead.next;
        }
        Node temp = sHead.down;
        while (temp.next.data < node.data) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
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
    }
}
