public class singly13_14 {
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
        Node node = new Node(10);
        head = node;
        Node node1 = new Node(20);
        Node node2 = new Node(30);
        Node node3 = new Node(40);
        Node node4 = new Node(50);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node1;
        findLoop(head);
    }

    private static void findLoop(Node head) {
        Node temp1 = head;
        Node temp2 = head;
        int count = 1;
        temp1 = temp1.next;
        temp2 = temp2.next.next;

        while (temp1.next != null || temp2.next != null) {
            temp1 = temp1.next;
            temp2 = temp2.next.next;
            if (temp1.equals(temp2)) {
                System.out.println("loop");
                temp1 = temp2;
                System.out.println(temp2.data);
                temp1 =temp1.next;
                while (!temp1.equals(temp2)) {
                    System.out.println(temp1.data);
                    temp1=temp1.next;
                    count++;
                }
                break;
            }
        }
        System.out.println(count);
    }
}
