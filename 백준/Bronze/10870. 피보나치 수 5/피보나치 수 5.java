
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N < 2){
            System.out.println(N);
            return;
        }
        int[] arr = new int[N + 1];
        arr[0] = 0;
        arr[1] = 1;

        for (int cnt = 2; cnt < N + 1; cnt++) {
            arr[cnt] = arr[cnt - 2] + arr[cnt - 1];
        }
        System.out.print(arr[N]);
    }
}
