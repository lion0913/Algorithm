
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] arr;
    static boolean[] visited;

    static int answerCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, 0);
        System.out.print(answerCnt);
    }

    public static void backtracking(int cnt, int sum) {
        if(sum < 0) {
            return;
        }
        if(cnt == N) {
            answerCnt++;
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                backtracking(cnt+1, sum+arr[i]-K);
                visited[i] = false;
            }
        }
    }
}
