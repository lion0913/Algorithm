
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[][] DP = new long[N+1][10];

        long mod = 1_000_000_000L;
        for(int i = 1; i < 10; i++) {
            DP[1][i] = 1;
        }

        for(int i = 2; i <= N; i++) {

            for(int j = 0; j < 10; j++) {
                if(j == 0) {
                    DP[i][j] = DP[i-1][j+1];
                } else if(j == 9) {
                    DP[i][j] = DP[i-1][j-1];
                } else {
                    DP[i][j] = (DP[i-1][j-1] + DP[i-1][j+1]) % mod;
                }

            }
        }
//        System.out.println(Arrays.toString(DP[N]));
        System.out.println(Arrays.stream(DP[N]).sum() % mod);
    }
}
