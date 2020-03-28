import java.util.Stack;

public class impl1 {
    private Stack<Integer> stack1=new Stack<>();
    private Stack<Integer> stack2=new Stack<>();
    void enqueue(int item){
        stack1.push(item);
    }
    int dqueue(){
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int item=stack2.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        System.out.println();
        System.out.println(stack1);
        return item;
    }

    public static void main(String[] args) {
        impl1 impl1=new impl1();
        impl1.enqueue(1);
        impl1.enqueue(10);
        impl1.enqueue(11);
        impl1.enqueue(12);
        impl1.enqueue(13);
        System.out.println(impl1.dqueue());
        System.out.println(impl1.dqueue());
        System.out.println(impl1.dqueue());
    }
}
