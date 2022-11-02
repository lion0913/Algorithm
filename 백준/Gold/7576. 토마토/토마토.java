
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n, m;
    static int zeroCnt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0) {
                    zeroCnt++;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        int[] xPos = {0,0,-1,1};
        int[] yPos = {-1,1,0,0};

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 1) {
                    queue.add(new int[]{i,j,0});
                }
            }
        }

        int day = 0;
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int k = 0; k < 4; k++) {
                int newX = now[1]+xPos[k];
                int newY = now[0]+yPos[k];
                if(newX >= 0 && newX < m && newY >= 0 && newY < n && arr[newY][newX] == 0) {
                    day = now[2]+1;
                    arr[newY][newX] = 1;
                    queue.add(new int[]{newY, newX, now[2]+1});
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    System.out.println("-1");
                    return;
                }
            }
        }
        System.out.println(day);
    }

}
