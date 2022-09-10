import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if(cmd.equals("top")) {
                if(stack.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(stack.peek() + "\n");
                }
            } else if(cmd.equals("pop")) {
                if(stack.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(stack.pop()+"\n");
                }

            } else if(cmd.equals("size")) {
                sb.append(stack.size()+"\n");
            } else if(cmd.equals("empty")) {
                String s = stack.isEmpty()? "1" : "0";
                sb.append(s +"\n");
            }
        }
        System.out.print(sb.toString());
    }
}