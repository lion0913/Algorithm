
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[][] isVisited;
    static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};

    static int totalCnt = 0;
    static int houseCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        isVisited = new int[n][n];

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j)-'0';
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(isVisited[i][j] == 0 && arr[i][j] == 1) {
                    isVisited[i][j] = 1;
                    totalCnt++;
                    houseCnt = 1;
                    dfs(i, j);
                    list.add(houseCnt);
                }
            }
        }

        System.out.println(totalCnt);
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
//        System.out.println(list);
    }

    static void dfs(int x, int y) {
        for(int i = 0; i < direction.length; i++) {
            int[] dir = direction[i];
            int newX = x+dir[0];
            int newY = y+dir[1];
            if(newX < 0 || newY < 0 || newX >= arr.length || newY >= arr.length ||isVisited[newX][newY] == 1 ) {
                continue;
            }

            if(arr[newX][newY] == 1) {
                houseCnt++;
                isVisited[newX][newY] = 1;
                dfs(newX, newY);
            }
        }
    }
}
