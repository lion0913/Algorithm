import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        String s = br.readLine();

        for(int i = 0; i < s.length(); i++) {
            String a = String.valueOf(s.charAt(i)).toUpperCase();
            if(map.get(a) == null) {
                map.put(a, 1);
            } else {
                map.put(a, map.get(a)+1);
            }
        }

        int max = 0;
        String answer = "?";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > max) {
                max = entry.getValue();
                answer = entry.getKey();
            } else if (entry.getValue() == max) {
                answer = "?";
            }
        }

        System.out.println(answer);
    }
}
