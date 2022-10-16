import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 레슨 수
        int m = Integer.parseInt(st.nextToken()); // 블루레이 크기

        array = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            sum += array[i];
            if(array[i] > max) {
                max = array[i];
            }
        }

        // 최소값의 시작범위 : 블루레이의 가장 큰 값
        int start = max;
        int end = sum;

        int answer = 0;
        while(start <= end) {
            int mid = (start+end)/2;
            int cnt = getCnt(mid);

//            System.out.printf("mid : %d일때 cnt : %d\n", mid, cnt);
            // cnt가 m의 개수보다 많은 경우
            if(cnt > m) {
                start = mid+1;
            } else if (cnt <= m) {
                end = mid - 1;
                answer = mid;

            }
        }
        System.out.println(answer);

    }

    static int getCnt(int standard) {
        int cnt = 1;
        int idx = 0;
        int sum = 0;
        while(idx <= array.length-1) {
            if(sum+array[idx] > standard) {
                sum = 0;
                cnt++;
            }

            sum += array[idx++];
        }
        return cnt;
    }
}