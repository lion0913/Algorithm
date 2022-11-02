
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n, m;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];


        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] combination = new int[3];
        int[] visited = new int[m];

        makeCombination(combination, visited, 0, 0);

        System.out.println(answer);
    }

    public static void makeCombination(int[] combination, int[] visited, int count, int idx) {
        if(count == 3) {
            int max = countMax(combination);
            if(max > answer) {
                answer = max;
            }
            return;
        }

        if(count < 3) {
            for(int i = idx; i < m; i++) {
                if(visited[i] == 0) {
                    visited[i] = 1;
                    combination[count] = i;
                    makeCombination(combination, visited, count+1, i+1);
                    visited[i] = 0;
                }
            }
        }
    }

    public static int countMax(int[] combination) {
        int total = 0;
        for(int i = 0; i < n; i++) {
            int max = 0;
            for(int chicken : combination) {
                if(arr[i][chicken] > max) {
                    max = arr[i][chicken];
                }
            }
            total += max;
        }
        return total;
    }
}
