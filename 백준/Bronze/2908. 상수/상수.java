import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String s1 = st.nextToken();
        String s2 = st.nextToken();

        String newS1 = "";
        String newS2 = "";

        for(int i = 2; i >= 0; i--) {
            newS1 += String.valueOf(s1.charAt(i));
            newS2 += String.valueOf(s2.charAt(i));
        }

        int a = Integer.parseInt(newS1);
        int b = Integer.parseInt(newS2);
        if(a > b) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }
}
