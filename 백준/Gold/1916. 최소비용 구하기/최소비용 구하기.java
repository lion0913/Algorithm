
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Graph> graphs;
    static int B, N;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graphs = new ArrayList<>();
        dist = new int[N+1];
        for(int i = 0; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        StringTokenizer st;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graphs.add(new Graph(s, e, d));
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        dijkstra(A);
        System.out.println(dist[B]);
    }

    public static void dijkstra(int a) {
        PriorityQueue<Graph> queue = new PriorityQueue<>();
        int[] visited = new int[N+1];

        queue.add(new Graph(a, a,0));
        while(!queue.isEmpty()) {
            Graph cur = queue.poll();
            if(cur.end == B) {
                break;
            }
            if(visited[cur.end] == 0) {
                visited[cur.end] = 1;
                for(Graph graph : graphs) {

                    if (graph.start == cur.end) {
                        if ((visited[graph.end] == 0) && (cur.dist + graph.dist < dist[graph.end])) {
                            dist[graph.end] = cur.dist + graph.dist;
                            queue.add(new Graph(graph.start, graph.end, dist[graph.end]));
                        }
                    }
                }
            }
        }
    }
}

class Graph implements Comparable<Graph> {
    int start, end, dist;

    Graph(int start, int end, int dist) {
        this.start = start;
        this.end = end;
        this.dist = dist;
    }

    @Override
    public int compareTo(Graph g) {
        if(this.dist == g.dist) {
            return this.start - g.start;
        }
        return this.dist - g.dist;
    }
}
