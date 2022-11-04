
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][m+1];
        int[][] dp = new int[n+1][m+1];

        for(int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < m+1; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken()) + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }
        int k = Integer.parseInt(br.readLine());

        for(int i = 0;  i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());

            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());

            int sum = dp[e1][e2] - dp[s1-1][e2] - dp[e1][s2-1] + dp[s1-1][s2-1];
            System.out.println(sum);
        }
    }
}
