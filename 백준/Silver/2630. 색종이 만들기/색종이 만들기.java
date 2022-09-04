
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int N;
    static int[] answer = {0,0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check(N, 0, 0);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    static void check(int n, int startX, int startY) {
        if( n == 1) {
            int color = board[startX][startY];
            answer[color]++;
            return;
        }

        int color = board[startX][startY];
        for(int i = startX; i < startX + n; i++) {
            for(int j = startY; j < startY + n; j++) {
                if(color != board[i][j]) {
                    check(n/2, startX, startY);
                    check(n/2, startX+n/2, startY);
                    check(n/2, startX, startY+n/2);
                    check(n/2, startX+n/2, startY+n/2);
                    return;
                }
            }
        }
        answer[color]++;
    }
}
