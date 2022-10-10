import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] list;
    static int[] isVisited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n];
        isVisited = new int[n];

        for(int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;

            list[u].add(v);
            list[v].add(u);
        }

        for(int i = 0; i < n; i++) {
            if(isVisited[i] == 0) {
                answer++;
                dfs(new ArrayList<>(Arrays.asList(i)), i);
            }
        }
        System.out.println(answer);
    }

    public static void dfs(ArrayList<Integer> cur, int node) {
        for(int i = 0; i < list[node].size(); i++) {
            int newNode = list[node].get(i);
            if(isVisited[newNode] == 0 && cur.contains(newNode) == false) {
                isVisited[newNode] = 1;
                cur.add(newNode);
                dfs(cur, newNode);
            }
        }
    }
}
