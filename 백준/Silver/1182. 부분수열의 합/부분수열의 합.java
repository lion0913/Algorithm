
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] arr; //입력받은 배열의 요소들
    static boolean[] visited; //사용여부
    static int N, S;
    static int answerCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        //두번째 줄
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(S == 0) answerCnt--;
        backtracking(0, 0);
        System.out.print(answerCnt);
    }

    public static void backtracking(int cnt, int sum) {
        if(cnt == N) {
            if(sum == S) {
                answerCnt++;
            }
            return;
        }

        backtracking(cnt+1,sum+arr[cnt]);
        backtracking(cnt+1, sum);

    }
}
