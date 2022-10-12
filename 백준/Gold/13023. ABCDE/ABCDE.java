import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] list;
//    static int arr[][];
    static int result = 0;
    static int isVisited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n];
//        arr = new int[n][n];
        isVisited = new int[n];

        for(int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            list[n1].add(n2);
            list[n2].add(n1);
        }

        for(int i = 0; i < n; i++) {
            isVisited[i] = 1;
            dfs(i, 1);
            isVisited[i] = 0;
            if(result == 1) {
                break;
            }
        }

//        System.out.println(Arrays.deepToString(arr));
        System.out.println(result);
    }

    static void dfs(int now, int depth) {
        if(depth == 5) {
            result = 1;
            return;
        }

        for(int n : list[now]) {
            if(isVisited[n] == 0) {
                isVisited[n] = 1;
//                System.out.println(depth+1);
                dfs(n, depth+1);
                isVisited[n] = 0;
            }
        }

    }
}
