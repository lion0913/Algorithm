import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Graph>> list;
    static int A, B, N;

    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        dist = new int[N+1];

        for(int i = 0; i < N+1; i++) {
            list.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list.get(s).add(new Graph(e,d));
        }

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        dijkstra(A);

        System.out.println(dist[B]);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Graph> queue = new PriorityQueue<>();

        int[] visited = new int[N+1];
        queue.add(new Graph(start, 0));

        while(!queue.isEmpty()) {
            Graph cur = queue.poll();
            visited[cur.end] = 1;

            if(cur.end == B) {
                break;
            }

            //연결되어있는 도시를 탐색
            for(Graph graph : list.get(cur.end)) {
                //가능한지 확인
                if(visited[graph.end] == 1) {
                    continue;
                }

                //최솟값이 되는지 확인 후 dist 배열 갱신
                if(cur.dist + graph.dist < dist[graph.end]) {
                    dist[graph.end] = cur.dist + graph.dist;
                    queue.add(new Graph(graph.end, dist[graph.end]));
                }

            }
        }
    }
}

class Graph implements Comparable<Graph> {
    int end, dist;

    Graph(int end, int dist) {
        this.end = end;
        this.dist = dist;
    }

    @Override
    public int compareTo(Graph graph) {
        if(this.dist == graph.dist) {
            return this.end - graph.end;
        }

        return this.dist - graph.dist;
    }
}
