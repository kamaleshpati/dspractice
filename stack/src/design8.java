import java.util.Stack;

public class design8 {
    Stack<Integer> stack = new Stack<>();
    static int small=-1;
    public void push(int a,Stack<Integer> s)
    {
        //add code here.
        s.add(a);
        int top = s.peek();
        while(!s.isEmpty()){
            int temp=s.pop();
            if(temp<top)
                top=temp;
            stack.push(temp);
        }
        while(!stack.isEmpty()){
            s.push(stack.pop());
        }
        small=top;
    }
    public int pop(Stack<Integer> s)
    {
        //add code here.
        if(s.isEmpty())
            small=-1;
        int top=s.peek();
        int temp1=s.pop();
        while(!s.isEmpty()){
            int temp=s.pop();
            if(temp<top)
                top=temp;
            stack.push(temp);
        }
        while(!stack.isEmpty()){
            s.push(stack.pop());
        }
        small=top;
        return temp1;
    }
    public int min(Stack<Integer> s)
    {
        return small;
    }

    public static void main(String[] args) {
        design8 design=new design8();
        Stack<Integer> stack=new Stack<>();
        design.push(1,stack);
        design.push(2,stack);
        design.push(3,stack);
        System.out.println(design.pop(stack));
        System.out.println(design.small);

    }
}
