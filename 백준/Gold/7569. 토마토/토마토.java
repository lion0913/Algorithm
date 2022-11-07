
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][][] arr;
    static int M, N, H;

    static int[] xDir = {0,0,0,0,-1,1};
    static int[] yDir = {0,0,-1,1,0,0};
    static int[] zDir = {-1,1,0,0,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][N][M];
        int zeroCnt = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int h = 0; h < H; h++) {
            for(int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for(int m = 0; m < M; m++) {
                    arr[h][n][m] = Integer.parseInt(st.nextToken());
                    if(arr[h][n][m] == 1) {
                        queue.add(new int[]{h, n, m, 0});
                    } else if(arr[h][n][m] == 0) {
                        zeroCnt++;
                    }
                }
            }
        }

        int day = 0;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int i = 0; i < 6; i++) {
                int newZ = cur[0] + zDir[i];
                int newY = cur[1] + yDir[i];
                int newX = cur[2] + xDir[i];

                if(newX >= 0 && newX < M && newY >= 0 && newY < N && newZ >= 0 && newZ < H) {
                    if(arr[newZ][newY][newX] == 0) {
                        arr[newZ][newY][newX] = 1;
                        day = cur[3] + 1;
                        queue.add(new int[]{newZ, newY, newX, day});
                        zeroCnt--;
                    }
                }
            }
        }
        if(zeroCnt > 0) {
            System.out.println("-1");
        } else {
            System.out.println(day);
        }

    }

}
