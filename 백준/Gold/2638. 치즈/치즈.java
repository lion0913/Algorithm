import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] grid;
    static boolean[][] air; //노공기존 0: 체크X, 1:공기, 2: 노공기
    static int[] r = {0,0,1,-1};
    static int[] c = {-1,1,0,0};
    static boolean[][] isVisited;

    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        int airCnt = 1;
        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m = 0; m < M; m++) {
                grid[n][m] = Integer.parseInt(st.nextToken());
                if(grid[n][m] == 0) airCnt++;
            }
        }

        while(airCnt <= N*M) {
            int[][] gridTmp = new int[N][M];
            air = new boolean[N][M];
            isVisited = new boolean[N][M];

            answer++;
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    gridTmp[n][m] = grid[n][m];
                }
            }
            airZone();

            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (grid[n][m] != 0 && isMelt(n, m)) {
                        airCnt++;
                        gridTmp[n][m] = 0;
                    }
                }
            }
            grid = gridTmp;
        }
        System.out.println(answer);

    }


    static void airZone() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0,0});
        isVisited[0][0] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i = 0; i < 4; i++) {
                int nextX = cur[0] + r[i];
                int nextY = cur[1] + c[i];

                if(nextX >=0 && nextX < N && nextY >= 0 && nextY < M && !isVisited[nextX][nextY]) {
                    isVisited[nextX][nextY] = true;

                    if(grid[nextX][nextY] == 0){
                        air[nextX][nextY] = true;
                        q.offer(new int[] {nextX,nextY});
                    }

                }
            }
        }
    }


    static boolean isMelt(int n, int m) {
        int cnt = 0;

        if(m-1 >= 0 && grid[n][m-1] == 0 && air[n][m-1]) {
            cnt++;
        }
        if(m+1 < M && grid[n][m+1] == 0 && air[n][m+1]) {
            cnt++;
        }
        if(n+1 < N && grid[n+1][m] == 0 && air[n+1][m]) {
            cnt++;
        }
        if(n-1 >= 0 && grid[n-1][m] == 0 && air[n-1][m]) {
            cnt++;
        }

        if(cnt < 2) return false;
            // 외부 공기로부터 차단된 치즈인지 확인
        else return true;
    }

}
