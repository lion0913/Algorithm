
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] dist = new long[N+1];
        for(int i = 2; i < N+1; i++) {
            dist[i] = INF;
        }
        dist[1] = 0;

        Edge[] edges = new Edge[M];
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            edges[m] = new Edge(s,e,v);
        }

        for(int n = 1; n < N; n++) {
            for(int m = 0; m < M; m++) {
                Edge edge = edges[m];
                if(dist[edge.s] != INF) {
                    if(dist[edge.e] > dist[edge.s] + edge.value) {
                        dist[edge.e] = dist[edge.s] + edge.value;
                    }
                }
            }
        }

        //음수 가중치 체크
        for(int m = 0; m < M; m++) {
            Edge edge = edges[m];
            if(dist[edge.s] != INF) {
                if(dist[edge.e] > dist[edge.s] + edge.value) {
                    System.out.println("-1");
                    return;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= N; i++) {
            if(dist[i] == INF) {
                sb.append("-1\n");
            } else {
                sb.append(dist[i]+"\n");
            }
        }

        System.out.println(sb);
    }
}

class Edge {
    int s, e, value;

    public Edge(int s, int e, int value) {
        this.s = s;
        this.e = e;
        this.value = value;
    }
}
