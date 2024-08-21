import java.util.ArrayList;

class Edge {
    int src, dest;

    Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
}

public class TarjanBridge {

    public static void dfs(ArrayList<Edge> graph[], int curr, int par, boolean vis[], int dt[], int low[], int time) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (e.dest == par) {
                continue;
            }

            if (vis[e.dest]) {
                low[curr] = Math.min(low[curr], dt[e.dest]);
            } else {
                dfs(graph, e.dest, curr, vis, dt, low, time);
                low[curr] = Math.min(low[curr], low[e.dest]);

                if (dt[curr] < low[e.dest]) {
                    System.out.println("BRIDGE : " + curr + " --- " + e.dest);
                }
            }
        }
    }

    public static void getBridge(ArrayList<Edge> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, -1, vis, dt, low, time);
            }
        }
    }

    public static void addEdge(ArrayList<Edge> graph[], int u, int v) {
        graph[u].add(new Edge(u, v));
        graph[v].add(new Edge(v, u));  // Since the graph is undirected
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 3, 4);

        getBridge(graph, V);
    }
}
