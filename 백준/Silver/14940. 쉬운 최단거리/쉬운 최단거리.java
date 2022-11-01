
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[][] distArr;

    static int[][] visited;
    static int[][] distance = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int startX=0, startY=0;

        arr = new int[n][m];
        distArr = new int[n][m];
        visited = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2) {
                    startX = j;
                    startY = i;
                }
            }
        }

        bfs(startX, startY);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(visited[i][j] == 0 && arr[i][j] == 1) {
                    sb.append("-1 ");
                } else {
                    sb.append(distArr[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();

        visited[startY][startX] = 1;

        queue.add(new int[] {startX, startY});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int i = 0; i < distance.length; i++) {
                int newX = now[0] + distance[i][1];
                int newY = now[1] + distance[i][0];

                if(newX < 0 || newY < 0 || newX >= distArr[0].length || newY >= distArr.length || arr[newY][newX] != 1) {
                    continue;
                }

                if(visited[newY][newX] != 0) {
                    continue;
                }

                distArr[newY][newX] = distArr[now[1]][now[0]]+1;
                visited[newY][newX] = 1;
                queue.add(new int[]{newX, newY});
            }
        }
    }

}