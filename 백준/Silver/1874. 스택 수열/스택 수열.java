import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> tmp = new Stack<>();

        StringBuilder answer = new StringBuilder();
//        String answer = "";

        int N = Integer.parseInt(br.readLine());

        int idx = 0;
        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if(input > idx) {
                for(int j = idx+1; j <= input; j++) {
                    tmp.push(j);
//                    System.out.printf("%d %s\n", idx, tmp);
                    answer.append("+\n");
//                    answer += "+\n";
                }
                idx = input;
            } else if (tmp.peek() != input) {
//                System.out.println(answer.trim());
                System.out.println("NO");
                return;
            }

            tmp.pop();
//            System.out.printf("%d %s\n", idx, tmp);
            answer.append("-\n");
        }
        System.out.println(answer);

    }
}