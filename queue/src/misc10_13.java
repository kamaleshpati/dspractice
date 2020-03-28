import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class misc10_13 {
    static Queue<Node> queue = new LinkedList<>();
    static Queue<Node> queue1 = new LinkedList<>();

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right;
        }
    }

    static Node root;

    public static void main(String args[]) {
        root = new Node(1);
        root.left        = new Node(2);
        root.right       = new Node(3);
        root.left.left  = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(8);
        root.right.right.left  = new Node(6);
        root.right.right.right  = new Node(7);
        System.out.println( maxLevelSum(root));
    }

    private static int maxLevelSum(Node root) {
        queue.add(root);
        int max=root.data;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp.left != null)
                queue1.add(temp.left);
            if (temp.right != null)
                queue1.add(temp.right);
            if(queue.isEmpty()){
                int sum=findSum(queue1);
                if(sum>max){
                    max=sum;
                }
                Queue<Node> tempQ=queue;
                queue=queue1;
                queue1=tempQ;
            }
        }
        return max;
    }

    private static int findSum(Queue<Node> queue1) {
        Iterator iterator=queue1.iterator();
        int max=0;
        System.out.println();
        while (iterator.hasNext()){
            int temp = ((Node)iterator.next()).data;
            max+=temp;
            System.out.print(temp+" ");
        }
        return max;
    }
}
