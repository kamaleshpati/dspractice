import java.util.Stack;

public class opereration5 {
    public static void main(String args[]) {
        Stack<Integer> st =
                new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        st.push(7);

        deleteMid(st, st.size(), 0);
        while (!st.empty()) {
            System.out.print(st.pop() + " ");
        }
    }

    private static void deleteMid(Stack<Integer> st, int size, int i) {
        if (st.isEmpty()) {
            return;
        } else {
            int x = st.pop();
            deleteMid(st, size, i+1);
            if (i != (size / 2)) {
                st.push(x);
            }

        }
    }
}
