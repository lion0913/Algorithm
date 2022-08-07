import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String K = st.nextToken();

        int cnt = 0;
        for(int i = 0; i < (N+1)*3600; i++) {
            String time = String.valueOf(i / 3600);
            String min = String.valueOf((i / 60) % 60);
            String sec = String.valueOf(i % 60);
            
            if(time.length() == 1) time += "0";
            if(min.length() == 1) min += "0";
            if(sec.length() == 1) sec += "0";
            

            if(time.contains(K) || min.contains(K) || sec.contains(K)) {
                cnt++;
            }

        }
        System.out.println(cnt);
    }
}
