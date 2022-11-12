import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] DP = new int[N+1];

        if(N == 1) {
            System.out.println("1");
            return;
        }
        DP[1] = 1;
        DP[2] = 2;
        for(int n = 3; n <= N; n++) {
            DP[n] = (DP[n-1] + DP[n-2])%10007;
        }

        System.out.println(DP[N]);

    }
}