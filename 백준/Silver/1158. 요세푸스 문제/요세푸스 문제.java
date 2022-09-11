import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++) {
            list.add(i);
        }
        while(!list.isEmpty()) {
            for(int i = 0; i < k-1; i++) {
                list.add(list.remove(0));
            }
            queue.add(list.remove(0));
        }
        String answer = queue.toString().replace("[","<").replace("]",">");
        System.out.println(answer);
    }
}