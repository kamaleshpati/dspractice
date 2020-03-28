import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class standard2 {
    static class Graph {
        Queue<Integer> queue = new LinkedList<>();
        private int V;
        private LinkedList<Integer> adj[];

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        void bfs(int start) {
            boolean[] visited = new boolean[V];
            IntStream.range(0, visited.length).forEach(i -> visited[i] = false);
            queue.add(start);
            visited[start] = true;
            while (!queue.isEmpty()) {
                int item = queue.remove();
                System.out.println(item);
                IntStream.range(0, adj[item].size()).forEachOrdered(i -> {
                    if (visited[adj[item].get(i)] == false)
                        queue.add(adj[item].get(i));
                        visited[adj[item].get(i)] = true;
                });
            }
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.bfs(2);
    }
}
