public class singly22 {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head1;
    static Node head2;


    public static void main(String[] args) {
        head1 = new Node(3);
        head1.next = new Node(6);
        head1.next.next = new Node(9);
        head1.next.next.next = new Node(15);
        head1.next.next.next.next = new Node(30);
        head2 = new Node(10);
        head2.next = new Node(15);
        head2.next.next = new Node(30);
        getIntersect();
    }

    private static void getIntersect() {
        Node temp = head1;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        temp = head2;
        int count1 = 0;
        while (temp != null) {
            count1++;
            temp = temp.next;
        }
        int c = count - count1 >= 0 ? count - count1 : count1 - count;
        Node node = count>count1?head1:head2;
        for(int i=0;i<=c;i++)
        {
            node=node.next;
        }
        System.out.println(node.data);
    }
}
