import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
//        int[] input = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int input = Integer.parseInt(st.nextToken());

            System.out.println(binarySearch(input));
        }

    }

    static int binarySearch(int n) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int midIndex = (start+end)/2;
            int mid = arr[midIndex];
            if(n > mid) {
                start = midIndex+1;
            } else if(n < mid) {
                end = midIndex-1;
            } else {
                return 1;
            }
        }

        return 0;
    }
}