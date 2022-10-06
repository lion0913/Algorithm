import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] isVisited;
    static int answer = 0;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int computerCnt = Integer.parseInt(br.readLine());
        int pairCnt = Integer.parseInt(br.readLine());

        arr = new int[computerCnt][computerCnt];
//        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        isVisited = new int[computerCnt];

        //인접한 컴퓨터끼리 그래프 형성
        for(int i = 0; i < pairCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken())-1;
            int n2 = Integer.parseInt(st.nextToken())-1;

            arr[n1][n2] = 1;
            arr[n2][n1] = 1;
        }

//        isVisited[0] = 1;
        dfs(0);

        System.out.println(answer-1);
    }

    static void dfs(int n) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[n][i] == 1 && isVisited[i] == 0) {
                isVisited[i] = 1;
//                System.out.println(i);
                answer++;
                dfs(i);
            }
        }
    }
}