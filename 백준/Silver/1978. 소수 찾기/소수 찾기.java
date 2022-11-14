
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int max = 0;
        for(int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
            if(max < arr[n]) {
                max = arr[n];
            }
        }

        int[] prime = new int[max+1];
        prime[0] = prime[1] = 1;
        for(int i = 2; i * i <= max; i++) {
            if(prime[i] == 0) {
                for(int j = i*i; j <= max; j+=i) {
                    prime[j] = 1;
                }
            }
        }

        int answer = 0;
        for(int n = 0; n < N; n++) {
            if(prime[arr[n]] == 0) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}