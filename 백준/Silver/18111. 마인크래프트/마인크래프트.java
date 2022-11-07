
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

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());

            for(int m = 0; m < M; m++) {
                int num = Integer.parseInt(st.nextToken());
                if(num > max) {
                    max = num;
                } else if(num < min) {
                    min = num;
                }
                int value = map.getOrDefault(num, 0);
                map.put(num, value + 1);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int answerHeight = Integer.MIN_VALUE;
        for(int i = min; i <= max; i++) {
            int sec = 0;
            int b = B;
            for(Map.Entry<Integer, Integer> e : map.entrySet()) {
                int k = i - e.getKey();
                if(k < 0) {
                    b += (k*-1) * e.getValue();
                    sec += (k * -2) * e.getValue();
                } else if (k > 0) {
                    b -= k*e.getValue();
                    sec += (k) * e.getValue();
                }

            }
//            System.out.printf("높이 %d일때 sec %d, b는 %d\n", i, sec, b);
            if(b < 0) {
                continue;
            }
            if(sec < minTime) {
                minTime = sec;
                answerHeight = i;
            } else if (sec == minTime && i > answerHeight) {
                answerHeight = i;
            }
        }

        System.out.printf("%d %d\n", minTime, answerHeight);

    }
}