import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++) {
            queue.add(i);
        }
        sb.append("<");
        while(!queue.isEmpty()) {
            for(int i = 0; i < k-1; i++) {
                queue.add(queue.poll());
            }
            int remove = queue.poll();
            sb.append(remove);
            if(!queue.isEmpty()) {
                sb.append(", ");
            }
//            sb.append(!list.isEmpty()? remove+", " : remove);
        }
        sb.append(">");
//        String answer = queue.toString().replace("[","<").replace("]",">");
        System.out.println(sb);
    }
}
// 1 2 3 4 5 6
