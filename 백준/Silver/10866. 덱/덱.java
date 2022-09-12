import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if(cmd.equals("push_front")) {
                deque.addFirst(Integer.parseInt(st.nextToken()));
            } else if(cmd.equals("push_back")){
                deque.addLast(Integer.parseInt(st.nextToken()));
            } else if(cmd.equals("pop_front")) {
                if(deque.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(deque.pollFirst());
                }
            } else if(cmd.equals("pop_back")) {
                if(deque.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(deque.pollLast());
                }
            } else if(cmd.equals("size")) {
                System.out.println(deque.size());
            } else if(cmd.equals("empty")) {
                if(deque.isEmpty()) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            } else if(cmd.equals("front")) {
                if(deque.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(deque.peekFirst());
                }
            } else if(cmd.equals("back")) {
                if(deque.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(deque.peekLast());
                }
            }
        }


    }
}
