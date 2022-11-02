
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[][] sec;

    static int[] xPos = {0,0,1,-1};
    static int[] yPos = {1,-1,0,0};
    static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[r][c];
        sec = new int[r][c];

        for(int i = 0; i < r; i++) {
            String s = br.readLine();
            for(int j = 0; j < c; j++) {
                arr[i][j] = s.charAt(j);
                if(arr[i][j] == 'O') {
                    sec[i][j] = 3;
                }
            }
        }

        int now = 1;
        while(now < n) {
            now++;
            add(now);

            if(now == n)
                break;
            now++;
            bomb(now);
        }

        for(int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(Character.toChars(arr[i][j]));
            }
            System.out.println();
        }
    }

    public static void bomb(int now) {
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(sec[i][j] == now) {
                    arr[i][j] = '.';
                    for(int k = 0; k < 4; k++) {
                        int newX = j + xPos[k];
                        int newY = i + yPos[k];

                        if(newX >= 0 && newX < c && newY >= 0 && newY < r) {
                            arr[newY][newX] = '.';
                        }
                    }
                }
            }
        }
    }

    public static void add(int time) {
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(arr[i][j] == '.') {
                    arr[i][j] = 'O';
                    sec[i][j] = time+3;
                }
            }
        }
    }
}