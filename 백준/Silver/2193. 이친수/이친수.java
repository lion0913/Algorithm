import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N+1][2];

        dp[1] = new long[]{0,1};

        for(int i = 2; i <= N; i++) {
            long zeroCnt = dp[i-1][0] + dp[i-1][1];
            long oneCnt = dp[i-1][0];
            dp[i] = new long[]{zeroCnt, oneCnt};
        }

        System.out.println(dp[N][0] + dp[N][1]);
    }
}
