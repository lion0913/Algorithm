import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] nArr = new int[n];
            int[] mArr = new int[m];

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                nArr[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                mArr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(mArr);

            bSort(nArr, mArr);
        }
    }

    public static void bSort(int[] nArr, int[] mArr) {
        int total = 0;
        int start, end, mid;
        for(int n : nArr) {
            int answer = 0;
//            System.out.println("n:"+n);
            start = 0;
            end = mArr.length-1;
            while(start <= end) {
                mid = (start + end) / 2;

                if (n <= mArr[mid]) {
                    end = mid - 1;
                } else if(n > mArr[mid]) {
                    answer = mid+1;
                    start = mid + 1;

                }
            }
            total += answer;
        }
        System.out.println(total);
    }
}