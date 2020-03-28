import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class misc11 {
    static class Graph {
        int V;
        LinkedList<Integer>[] adj;

        Graph(int V) {
            this.V = V;
            adj = new LinkedList[V];
            for (int i = 0; i < adj.length; i++)
                adj[i] = new LinkedList<>();
        }

        void add(int v, int w) {
            adj[v].add(w);
        }

        void dfs(int ele) {
            boolean[] list = new boolean[this.V];
            IntStream.range(0, this.V)
                    .forEach(i -> list[i] = false);
            Stack<Integer> stack = new Stack<>();
            stack.push(ele);
            while (!stack.isEmpty()) {
                int s = stack.pop();
                if (list[s] == false) {
                    list[s] = true;
                    System.out.println(s + "visited");
                }
                adj[s].stream().forEachOrdered(stack::push);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.add(1, 0);
        g.add(0, 2);
        g.add(2, 1);
        g.add(0, 3);
        g.add(1, 4);
        g.dfs(0);
    }
}
