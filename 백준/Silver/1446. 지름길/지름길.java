
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static Graph[] graphs;
    static int[] dist;

    static int D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        graphs = new Graph[N];
        dist = new int[D+1];

        for(int d = 1; d <= D; d++) {
            dist[d] = d;
        }

        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graphs[n] = new Graph(s,e,d);
        }

        dijkstra(0);
        System.out.println(dist[D]);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Graph> queue = new PriorityQueue<>();

        queue.add(new Graph(start,0,0));
        while(!queue.isEmpty()) {
            Graph cur = queue.poll();

            for(Graph graph : graphs) {
                // 그래프의 시작이 현재에서의 종료값보다 커야 한다.
                if(graph.start >= cur.end) {
                    // 그래프 종료값이 D(도착지)보다 크다면 더 볼필요 없음
                    if(graph.end > D) {
                        continue;
                    }
                    if(dist[graph.end] > dist[cur.end] + graph.dist + graph.start - cur.end) {
                        dist[graph.end] = dist[cur.end] + graph.dist + graph.start - cur.end;
                        queue.add(new Graph(0, graph.end, dist[graph.end]));
                    }
                }
            }
            dist[D] = Math.min(dist[D], dist[cur.end] + D - cur.end);
        }
    }
}

class Graph implements Comparable<Graph> {
    int start, end, dist;

    public Graph(int start, int end, int dist) {
        this.start = start;
        this.end = end;
        this.dist = dist;
    }

    @Override
    public int compareTo(Graph g) {
        return this.dist - g.dist;
    }
}
