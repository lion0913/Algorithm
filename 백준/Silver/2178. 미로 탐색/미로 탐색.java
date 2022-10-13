import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}}; //좌, 우, 하, 상

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int[][] isVisited = new int[n][m];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j)-'0';
            }
        }

//        System.out.println(Arrays.deepToString(arr));
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0, 1});
        isVisited[0][0] = 1;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(cur[0] == n-1 && cur[1] == m-1) {
                System.out.println(cur[2]);
                return;
            }
            for(int i = 0; i < 4; i++) {
                int newX = cur[0] + dir[i][0];
                int newY = cur[1] + dir[i][1];

                if(newX < 0 || newY < 0 || newX >= n || newY >= m) {
                    continue;
                }
                if(isVisited[newX][newY] == 0 && arr[newX][newY] == 1) {
                    isVisited[newX][newY] = 1;
                    queue.add(new int[]{newX, newY, cur[2]+1});
                }
            }
        }

    }
}
