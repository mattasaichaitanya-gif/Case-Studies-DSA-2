import java.util.*;
public class BMTCBellmanFord {
    static class Edge {
        int u;
        int v;
        int weight;
        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }
    static int[] bellmanFord(int n,
                             List<Edge> edges,
                             int source) {

        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[source] = 0;

        // V - 1 iterations
        for (int iter = 0; iter < n - 1; iter++) {

            boolean updated = false;

            for (Edge e : edges) {

                // Relaxation Step
                if (dist[e.u] != Integer.MAX_VALUE
                        && dist[e.u] + e.weight < dist[e.v]) {

                    dist[e.v] =
                            dist[e.u] + e.weight;

                    updated = true;
                }
            }

            // Print distances after iteration
            System.out.println(
                    "Iteration " + (iter + 1));

            printDistances(dist);

            // Early convergence
            if (!updated) {
                System.out.println(
                        "Algorithm converged early.");
                break;
            }
        }

        // Negative Cycle Detection
        for (Edge e : edges) {

            if (dist[e.u] != Integer.MAX_VALUE
                    && dist[e.u] + e.weight < dist[e.v]) {

                throw new RuntimeException(
                        "Negative cycle reachable from source");
            }
        }

        return dist;
    }

    // Print Distance Array
    static void printDistances(int[] dist) {

        String[] hubs = {
                "MJC",
                "KEM",
                "JAY",
                "KOR",
                "WHF",
                "HBR",
                "MRT"
        };

        for (int i = 0; i < dist.length; i++) {

            System.out.println(
                    hubs[i]
                    + " = "
                    + dist[i]);
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // Number of vertices
        int V = 7;

        // Hub Index Mapping
        // 0 = MJC
        // 1 = KEM
        // 2 = JAY
        // 3 = KOR
        // 4 = WHF
        // 5 = HBR
        // 6 = MRT

        List<Edge> edges = new ArrayList<>();

        // Graph Edges
        edges.add(new Edge(0, 1, 8));   // MJC -> KEM
        edges.add(new Edge(0, 2, 5));   // MJC -> JAY
        edges.add(new Edge(0, 3, 12));  // MJC -> KOR

        edges.add(new Edge(1, 5, 7));   // KEM -> HBR
        edges.add(new Edge(1, 4, 10));  // KEM -> WHF

        edges.add(new Edge(2, 3, 4));   // JAY -> KOR

        edges.add(new Edge(3, 4, 6));   // KOR -> WHF
        edges.add(new Edge(3, 6, 9));   // KOR -> MRT

        edges.add(new Edge(4, 5, 3));   // WHF -> HBR
        edges.add(new Edge(4, 6, -3));  // WHF -> MRT

        edges.add(new Edge(5, 6, 11));  // HBR -> MRT

        System.out.println(
                "BMTC Bellman-Ford Shortest Path");

        System.out.println(
                "Source Hub = MJC");

        System.out.println();

        // Run Bellman-Ford
        int[] shortest =
                bellmanFord(V, edges, 0);

        // Final Distances
        System.out.println(
                "Final Shortest Distances");

        printDistances(shortest);

        // Time Complexity
        System.out.println(
                "Time Complexity of Bellman-Ford");

        System.out.println(
                "O(V * E)");

        int operations =
                V * edges.size();

        System.out.println(
                "Approximate Operations = "
                + operations);

        // Dijkstra Comparison
        System.out.println();

        System.out.println(
                "Dijkstra with Binary Heap");

        System.out.println(
                "Time Complexity = O(E log V)");

        double dijkstraOps =
                edges.size()
                * (Math.log(V) / Math.log(2));

        System.out.println(
                "Approximate Operations = "
                + Math.ceil(dijkstraOps));

        // Dispatcher Query Comparison
        System.out.println();

        int queriesPerMinute = 36000;

        int bellmanFordPerQuery =
                V * edges.size();

        int totalBellmanFord =
                bellmanFordPerQuery
                * queriesPerMinute;

        int floydWarshallPrecompute =
                V * V * V;

        System.out.println(
                "Dispatcher Product-Code Comparison");

        System.out.println(
                "Bellman-Ford 36000 Queries Operations = "
                + totalBellmanFord);

        System.out.println(
                "Floyd-Warshall Precompute Operations = "
                + floydWarshallPrecompute);

        System.out.println(
                "Floyd-Warshall serves each query in O(1)");
    }
}