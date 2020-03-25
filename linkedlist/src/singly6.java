public class singly6 {
    private static class  Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static Node head;
    static void add(Node node)
    {
        Node temp = head;
        while (temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=node;
    }
    static void print()
    {
        if(head==null)
            System.out.println("\nnull");
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        Node node=new Node(1);
        head = node;
        singly6.add(new Node(2));
        singly6.add(new Node(3));
        singly6.add(new Node(4));
        singly6.add(new Node(5));
        print();
        delete();
        print();
    }

    private static void delete() {
        head = null;
    }
}
