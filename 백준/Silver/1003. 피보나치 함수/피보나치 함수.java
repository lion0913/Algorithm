
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        answer = new int[T][2];

        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            answer[t] = fibonacci(N);
        }

        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            sb.append("%d %d\n".formatted(answer[t][0], answer[t][1]));
        }
        System.out.println(sb);
    }

    public static int[] fibonacci(int n) {
        int[][] count = new int[n+1][2];

        count[0] = new int[]{1,0};
        if(n == 0) return count[0];

        count[1] = new int[]{0,1};
        if(n == 1) return count[1];

        for(int i = 2; i <= n; i++) {
            count[i] = new int[]{count[i-1][0]+count[i-2][0], count[i-1][1]+count[i-2][1]};
        }

        return count[n];
    }
}