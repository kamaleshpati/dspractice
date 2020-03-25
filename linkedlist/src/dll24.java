public class dll24 {
    static class Node {
        int data;
        int priority;
        Node prev;
        Node next;

        Node(int data, int priority) {
            this.data = data;
            this.priority = priority;
            prev = null;
            next = null;
        }
    }

    static Node front;
    static Node rear;

    public static void main(String[] args) {
        Node node = new Node(1, 10);
        front = node;
        rear = node;
        add(new Node(2, 0));
        add(new Node(8, 9));
        System.out.println();
        printPQ();
        add(new Node(3, 15));
        add(new Node(4, 7));
        System.out.println();
        printPQ();
    }

    private static void printPQ() {
        Node temp = rear;
        while (temp != null) {
            System.out.print(temp.data+"=>");
            temp = temp.next;
        }
    }

    private static void add(Node node) {
        if (node.priority <= front.priority) {
            node.next=front;
            front.prev=node.next;
            front=node;
        } else if (node.priority > rear.priority) {
            node.next = null;
            rear.next = node;
            node.prev=rear.next;
            rear = node;
        } else {
            Node temp = front.next;
            while (temp.priority > node.priority) {
                temp = temp.next;
            }
            (temp.prev).next=node;
            node.next = temp.prev;
            node.prev = (temp.prev).next;
            temp.prev = node.next;
        }

    }
}
