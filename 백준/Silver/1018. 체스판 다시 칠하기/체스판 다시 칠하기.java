import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //W:1, B:0
        arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j)-'W' == 0?1:0;
            }
        }

        int answer = Integer.MAX_VALUE;

        for(int i = 0; i < n-8+1; i++) {
            for(int j = 0; j < m-8+1; j++) {
                int cnt = count(i, j);
                if(cnt < answer) {
                    answer = cnt;
                }
            }
        }
        System.out.println(answer);
    }


    public static int count(int y, int x) {
        // 0,0 -> 0, 0,1 -> 1, 0,2 -> 0
        // 1,0 -> 1, 1,1 -> 0
        int cnt = 0;

        for(int i = y; i < y+8; i++) {
            for(int j = x; j < x+8; j++) {
                int match = (i+j)%2;
                if(match == arr[i][j]) {
                    cnt++;
                }
            }
        }
        return cnt < 64-cnt ? cnt : 64-cnt;
    }
}
