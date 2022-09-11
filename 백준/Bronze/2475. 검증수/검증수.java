import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int total = 0;
        for(int i = 0; i < 5; i++) {
            total += Math.pow(Integer.parseInt(st.nextToken()), 2);
        }
        System.out.println(total % 10);
    }
}