import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static boolean[] check;
    static int[][] graph;

    static int N, M, V;
    static String answer1 = "";
    static String answer2 = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        check = new boolean[N];
        graph = new int[N][N];

        for(int i = 0; i < M; i++) {
            //각 간선의 포인트값 받아옴
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(V-1);
        check = new boolean[N];
        bfs(V-1);

        System.out.println(answer1.trim());
        System.out.println(answer2.trim());
    }

    static void dfs(int x) {
        answer1 += (x+1)+" ";
        check[x] = true;
        for(int i = 0; i < N; i++) {
            if(graph[x][i] == 1 && !check[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        check[x] = true;
        q.add(x);
        while(!q.isEmpty()) {
            int n = q.poll();
            answer2 += (n+1)+" ";
            for(int i = 0; i < N; i++) {
                if(!check[i] && graph[n][i] == 1) {
                    check[i] = true;
                    q.add(i);
                }
            }
        }
    }


}
