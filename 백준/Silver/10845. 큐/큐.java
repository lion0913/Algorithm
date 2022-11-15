
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InaccessibleObjectException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        Deque<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int n = 0; n < N; n++) {
            String s = br.readLine();
            if(s.contains("push")) {
                int num = Integer.parseInt(s.split(" ")[1]);
                queue.add(num);
            } else if(s.equals("front")) {
                if(queue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(queue.getFirst()+"\n");
                }
            } else if(s.equals("back")) {
                if(queue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(queue.getLast()+"\n");
                }
            } else if(s.equals("size")) {
                sb.append(queue.size()+"\n");
            } else if(s.equals("pop")) {
                if(queue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(queue.poll()+"\n");
                }
            } else if(s.equals("empty")) {
                if(queue.isEmpty()) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            }
        }
        System.out.println(sb);
    }
}