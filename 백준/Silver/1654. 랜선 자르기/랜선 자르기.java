
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] lans;
    static int N, K;

    static long answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        lans = new int[K];
        int max = 0;
        for(int k = 0; k < K; k++) {
            lans[k] = Integer.parseInt(br.readLine());
            if(max < lans[k]) {
                max = lans[k];
            }
        }

        binarySearch(1, max);
        System.out.println(answer);
    }

    static void binarySearch(long start, long end) {
        if(start > end)
            return;

        long mid = (end+start) / 2;
//        System.out.println(mid);
        long cnt = 0;
        for(int lan : lans) {
            if(mid == 0) {
                cnt += lan;
            } else {
                cnt += (lan / mid);
            }
        }

        if(cnt >= N) { // cnt 개수가 많다 -> 값을 키워보자
            if(answer < mid)
                answer = mid;
            binarySearch(mid+1, end);
        } else { // cnt 개수가 적다, 값을 줄이기
            binarySearch(start, mid-1);
        }
    }
}