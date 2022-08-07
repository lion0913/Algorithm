import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()); // 피로도
        int B = Integer.parseInt(st.nextToken()); // 할수있는 일
        int C = Integer.parseInt(st.nextToken()); //한시간 쉴때 피로도
        int M = Integer.parseInt(st.nextToken()); // M넘으면 안됨

        int tiredSum = 0;
        int workSum = 0;

        if(A > M) {
            System.out.println("0");
            return;
        }

        for(int i = 0; i < 24; i++) {
            //피로도를 초과할 경우
            if(tiredSum + A > M) {
                tiredSum -= C;
                if(tiredSum < 0) tiredSum = 0;
            } else { //피로도 초과 안할 경우
                workSum += B;
                tiredSum += A;
            }
        }
        System.out.println(workSum);

        //할 수 있는 일 3 3   0 0 0 3 0 0 3  0 0 0 3 0 0 3  0 0 0 3 0 0 0 3
        // 피로도      5 10  8 6 4 9 7 5 10 8 6 4 9 7 5 10 8 6 4 9 7 5


    }
}
