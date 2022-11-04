
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arr;
    static int[] list;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new int[n];

        list = new int[m];

        for(int i = 0; i < n; i++) {
            arr[i] = i+1;
        }

        backtracking(0);
    }

    static void backtracking(int cnt) {
        if(cnt == m) {
            print();
            return;
        }

        for(int i = 0; i < n; i++) {
            if(visited[i] == 0) {
                visited[i] = 1;
                list[cnt] = arr[i];
                backtracking(cnt+1);
                visited[i] = 0;
            }
        }
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            sb.append("%d ".formatted(list[i]));
        }
        System.out.println(sb);
    }
}
