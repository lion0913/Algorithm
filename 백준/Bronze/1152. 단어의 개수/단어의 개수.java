import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        List<String> split = Arrays.asList(s.trim().split(" "));
        if(split.size() == 1 && split.get(0).equals("")) {
            System.out.println("0");
        } else {
            System.out.println(split.size());
        }

//        System.out.println(Arrays.toString(split));
//        System.out.println(split.length);
    }
}
