import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int min = Integer.MAX_VALUE;
        int num = Integer.parseInt(N);

        for(int i = 1; i < num; i++) {
            String s = String.valueOf(i);
            int tmp = i;

            for(int j = 0; j < s.length(); j++) {
                tmp += s.charAt(j) - '0';
            }
            if(tmp == num && tmp < min) {
                min = i;
            }
        }
        if(min == Integer.MAX_VALUE) {
            System.out.println(0);
        } else 
            System.out.println(min);
    }
}
