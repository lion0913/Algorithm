
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 31;
    private static int[][] dp = new int[MAX][MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i = 0; i < MAX; i++) {
            dp[i][0] = 1;
            dp[i][1] = i;
        }

        for(int m = 2; m < MAX; m++) {
            for(int n = 2; n < MAX; n++) {
                dp[m][n] = dp[m-1][n-1] + dp[m-1][n];
            }
        }

        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            System.out.println(dp[M][N]);
        }
    }
}
