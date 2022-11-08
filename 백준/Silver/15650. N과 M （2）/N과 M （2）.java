
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[M+1];
        for(int i = 1; i <= N; i++) {
            arr[1] = i;
            backtracking(i, 1, arr);
        }

    }

    static void backtracking(int start, int length, int[] arr) {
        if(length == M) {
            StringBuffer sb = new StringBuffer();
            for(int i = 1; i <= M; i++) {
                sb.append("%d ".formatted(arr[i]));
            }
            System.out.println(sb);
            return;
        }

        for(int i = start+1; i <= N; i++) {
            arr[length+1] = i;
            backtracking(i, length+1, arr);
        }
    }
}
