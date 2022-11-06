
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
//            ArrayList<Integer> arr = new ArrayList<>();
            int[] arr = new int[n+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int amount = Integer.parseInt(br.readLine());

            int[] dp = new int[amount+1];

            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= amount; k++) {
                    if(k == arr[j]) {
                        dp[k]++;
                    } else if(k-arr[j] > 0) {
                        dp[k] = dp[k] + dp[k-arr[j]];
                    }
                }
            }
            sb.append(dp[amount]+"\n");
        }

        System.out.println(sb);
    }


}
