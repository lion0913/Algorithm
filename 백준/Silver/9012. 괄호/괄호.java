import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int size = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++) {
            Stack<String> stack = new Stack<>();
            String line = br.readLine();
            boolean end = false;
            for(int n = 0; n < line.length(); n++) {
                String s = String.valueOf(line.charAt(n));
                if(s.equals("(")) {
                    stack.push("(");
//                    System.out.println(stack.toString());
                } else {
                    if(stack.isEmpty()) {
                        sb.append("NO\n");
                        end = true;
                        break;
                    } else if(stack.peek().equals("(")) {
                        stack.pop();
//                        System.out.println(stack.toString());
                    } else {
                        sb.append("NO\n");
                        end = true;
                        break;
                    }
                }
            }
            if(!end) {
                if (stack.isEmpty() == false) {
                    sb.append("NO\n");
                } else {
                    sb.append("YES\n");
                }
            }
        }
        System.out.print(sb);

    }
}
