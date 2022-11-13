
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();
        for(int n = 0; n < N; n++) {
            String s = br.readLine();
            list.add(s);
        }
        Comparator<String> strComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        };
        Collections.sort(list, strComparator);

        StringBuilder sb = new StringBuilder();
        String before = "";
        for(String s : list) {
            if(s.equals(before)) {
                continue;
            }
            sb.append(s+"\n");
            before = s;
        }
        System.out.println(sb);
    }
}
