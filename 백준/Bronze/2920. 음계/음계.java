import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int stand = Integer.parseInt(st.nextToken());
        if(stand == 8) {
            for(int i = 1; i < 8; i++) {
                if(Integer.parseInt(st.nextToken()) != --stand) {
                    System.out.println("mixed");
                    return;
                }
            }
            System.out.println("descending");
        } else if(stand == 1) {
            for(int i = 1; i < 8; i++) {
                if(Integer.parseInt(st.nextToken()) != ++stand) {
                    System.out.println("mixed");
                    return;
                }
            }
            System.out.println("ascending");
        } else {
            System.out.println("mixed");
        }

    }
}