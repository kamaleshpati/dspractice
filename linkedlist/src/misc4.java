public class misc4 {
    static class StackNode {
        int data;
        StackNode next;

        StackNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static StackNode head;

    public static void main(String[] args) {
        head = new StackNode(10);
        push(new StackNode(20));
        push(new StackNode(30));
        push(new StackNode(40));
        push(new StackNode(50));
        push(new StackNode(60));
        push(new StackNode(70));
        printStack();
        System.out.println();
        pop();
        printStack();
        System.out.println();
        rev();
        printStack();
    }

    private static void rev() {
        StackNode stackNode = head.next;
        StackNode stackNodeTemp = stackNode.next;
        head.next = null;
        stackNode.next = head;
        head = stackNode;
        while (stackNodeTemp != null) {
            stackNode = stackNodeTemp;
            stackNodeTemp = stackNodeTemp.next;
            stackNode.next = head;
            head = stackNode;
        }
    }

    private static void pop() {
        StackNode temp = head.next;
        head.next = null;
        head = temp;
    }

    private static void printStack() {
        StackNode temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    private static void push(StackNode stackNode) {
        stackNode.next = head;
        head = stackNode;
    }
}
