public class circular2_7_8_15_16 {
    static class Node {
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

    public static void main(String[] args) {
        Node node = new Node(1);
        head = node;
        add(new Node(2));
        add(new Node(3));
        add(new Node(4));
        add(new Node(5));
        node = new Node(6);
        add(node);
        node.next = head;
        //printCircular();
        addFirst(new Node(11));
        printCircular();
        addLast(new Node(12));
        printCircular();
        add(new Node(13), 3);
        printCircular();
        exchangeLastfirst();
        printCircular();
        deleteFirst();
        printCircular();
        deleteLast();
        printCircular();
    }

    private static void deleteLast() {
        Node temp =head;
        while ( temp.next.next!=head){
            temp=temp.next;
        }
        Node temp1=temp.next;
        temp.next=temp.next.next;
        temp1.next=null;
    }

    private static void deleteFirst() {
        Node temp =head;
        while ( temp.next!=head){
            temp=temp.next;
        }
        temp.next=head.next;
        head=temp.next;
    }

    private static void exchangeLastfirst() {
        Node temp = head;
        while (temp.next.next != head)
            temp = temp.next;
        temp.next.next = head.next;
        head.next = temp.next;
        temp.next = head;
        head = head.next;
    }

    private static void add(Node node, int i) {
        Node temp = head;
        int count = 1;
        while (count <= i) {
            temp = temp.next;
            count++;
        }
        Node temp1= temp.next;
        temp.next=node;
        node.next=temp1;
    }

    private static void addLast(Node node) {
        Node temp = head;
        Node temp1 = head;
        while (!temp.next.equals(temp1)) {
            temp = temp.next;
        }
        temp.next = node;
        node.next = head;
    }

    private static void addFirst(Node node) {
        Node temp = head;
        Node temp1 = head;
        while (!temp.next.equals(temp1)) {
            temp = temp.next;
        }
        temp.next = node;
        head = node;
        node.next = temp1;
    }

    private static void printCircular() {
        Node temp = head;
        Node temp1 = head;
        while (!temp.next.equals(temp1)) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
}
