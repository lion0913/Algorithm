
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

//        System.out.println(Arrays.toString(arr));
        int answer = Integer.MAX_VALUE;
        int n1 = -1;
        int n2 = -1;
        for(int i = 0; i < n; i++) {
            int num = arr[i];
            int min = Integer.MAX_VALUE;
            int minVal = -1;

            int L = i+1;
            int R = n-1;

            while(L <= R) {
                int mid = (L+R)/2;

                int sum = arr[mid] + num;
//                System.out.printf("num : %d,L : %d, R : %d, abs : %d, min : %d\n",num, L, R, sum, min);
                if(sum > 0) {
                    R = mid -1;
                } else if(sum < 0) {
                    L = mid + 1;
                }
                if(Math.abs(sum) < Math.abs(min)) {
                    min = sum;
                    minVal = arr[mid];
                    if(sum == 0) {
                        break;
                    }
                }
            }
            if(Math.abs(min) < Math.abs(answer)) {
                answer = min;
                n1 = num;
                n2 = minVal;
            }
        }
        System.out.printf("%d %d",n1,n2);

    }
}