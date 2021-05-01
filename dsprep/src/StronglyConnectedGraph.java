import java.util.LinkedList;
import java.util.Stack;

public class StronglyConnectedGraph {
    private int V;
    private LinkedList[] adj;

    StronglyConnectedGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        int n;

        for (Integer integer : (Iterable<Integer>) adj[v]) {
            n = integer;
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    StronglyConnectedGraph getTranspose() {
        StronglyConnectedGraph g = new StronglyConnectedGraph(V);
        for (int v = 0; v < V; v++) {
            for (Integer integer : (Iterable<Integer>) adj[v]) g.adj[integer].add(v);
        }
        return g;
    }

    void fillOrder(int v, boolean visited[], Stack stack) {
        visited[v] = true;
        for (int n : (Iterable<Integer>) adj[v]) {
            if (!visited[n])
                fillOrder(n, visited, stack);
        }
        stack.push(v);
    }

    void printSCCs() {
        Stack stack = new Stack();

        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                fillOrder(i, visited, stack);
        StronglyConnectedGraph gr = getTranspose();
        for (int i = 0; i < V; i++)
            visited[i] = false;

        while (!stack.empty()) {
            int v = (int) stack.pop();

            if (!visited[v]) {
                gr.DFSUtil(v, visited);
                System.out.println();
            }
        }
    }

    public static void main(String args[]) {
        StronglyConnectedGraph g = new StronglyConnectedGraph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println("Following are strongly connected components " +
                "in given graph ");
        g.printSCCs();
    }

}
