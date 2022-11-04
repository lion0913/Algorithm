import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        int[] visited = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = i+1;
        }

//        ArrayList<Integer> list = new ArrayList<>();

        int[] list = new int[m];

        dfs(0, list, visited);
    }

    static void dfs(int cnt, int[] list, int[] visited) {
        if(cnt == m) {
            print(list);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(visited[i] == 0) {
                visited[i] = 1;
                list[cnt] = arr[i];
                dfs(cnt+1, list, visited);
                visited[i] = 0;
            }
        }
    }

    static void print(int[] list) {
        for(int i = 0; i < m; i++) {
            System.out.print(list[i]+" ");
        }
        System.out.println();
    }
}
