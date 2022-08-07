import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());

        int result = 0;

        for(int i = 0; i < n; i++) {
            int m = i;
            int sum = m;
            while(m != 0) {
                sum += m % 10;
                m /= 10;
            }
            if(sum == n) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
