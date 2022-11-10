
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        //0 : 소수
        int[] prime = new int[N+1];
        prime[0] = prime[1] = 1;

        for(int i = 2; i*i<=N; i++) {
            if(prime[i] == 0) {
                for(int j = i*i; j <= N; j+=i) {
                    prime[j] = 1;
                }
            }
        }

        for(int i = M; i <= N; i++) {
            if(prime[i] == 0) {
                sb.append("%d\n".formatted(i));
            }
        }
        System.out.println(sb);
    }
}
