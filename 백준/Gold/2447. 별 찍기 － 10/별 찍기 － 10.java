import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] pattern;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        pattern = new int[N][N];
        StringBuilder sb = new StringBuilder();

        start(N,0,0);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(pattern[i][j] == 0) {
                    sb.append("*");
//                    System.out.print("*");
                } else {
                    sb.append(" ");
//                    System.out.print(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void start(int n, int startX, int startY) {
        if(n == 1) return;
        int range = n/3;


        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {

                if(i == 1 && j == 1) {
                    for(int k = startX+range; k < startX+range * 2; k++) {
                        for(int l = startY+range; l < startY+range * 2; l++) {
                            pattern[k][l] = 1;
                        }
                    }
                } else {
                    start(range, startX+i*range, startY+j*range);
                }
            }
        }
    }
}