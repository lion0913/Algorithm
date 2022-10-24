
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        for(int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        int idx = n-1;
        while(k > 0 && idx >= 0) {
            if(k < coin[idx]) {
                idx--;
            }

            int share = k / coin[idx];
            int remain = k % coin[idx];

            answer += share;
            k = remain;

            idx--;
        }
        System.out.println(answer);
    }
}