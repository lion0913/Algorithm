import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int last= 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("push")) {
                last = Integer.parseInt(st.nextToken());
                queue.add(last);
            } else if(cmd.equals("pop")) {
                if(queue.isEmpty()) {
                     sb.append("-1\n");
                } else {
                    sb.append(queue.poll()+"\n");
                }
            } else if(cmd.equals("size")) {
                sb.append(queue.size()+"\n");
            } else if(cmd.equals("empty")) {
                if(queue.isEmpty()) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if(cmd.equals("front")) {
                if(queue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(queue.peek()+"\n");
                }
            } else if(cmd.equals("back")) {
                if(queue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(last + "\n");
                }
            }
        }
        System.out.print(sb);
    }
}
