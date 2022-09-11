import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Map<String, Integer> map = new HashMap<>();

        for(char c = 'a'; c <= 'z'; c++) {
            map.put(String.valueOf(c), -1);
        }

        for(int i = 0; i < s.length(); i++) {
            String a = String.valueOf(s.charAt(i));
            if(map.get(a) == -1) {
                map.put(a, i);
            }
        }

        for(char c = 'a'; c <= 'z'; c++) {
            int a = map.get(String.valueOf(c));
            System.out.print(a+" ");
        }


    }
}
