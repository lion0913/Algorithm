import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(arr);

    }

    static void recursive(int[][] arr) {
        if(arr.length == 1) {
            System.out.println(arr[0][0]);
            return;
        }
        int size = arr.length / 2;
        int[][] newArr = new int[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                List<Integer> list = Arrays.asList(arr[i*2][j*2], arr[i*2][j*2+1], arr[i*2+1][j*2], arr[i*2+1][j*2+1]);
                Collections.sort(list);
                newArr[i][j] = list.get(2);
            }
        }
        recursive(newArr);
    }
}
