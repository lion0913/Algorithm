
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int[] remain = new int[]{1,3,5,7,9};
    static int n;

    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int size = (int) Math.pow(10, n);
        int[] first = new int[]{2,3,5,7};


        for(int i = 0; i < first.length; i++) {
            dfs(first[i]);
        }

        Collections.sort(answer);
        for(int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }

    public static void dfs(int num) {
        if((int)Math.log10(num)+1 == n) {
            answer.add(num);
            return;
        }

        for(int i = 0; i < remain.length; i++) {
            int newNum = num * 10 + remain[i];
            if(isPrime(newNum)) {
                dfs(newNum);
            }
        }

    }

    public static boolean isPrime(int num) {
        for(int i = 2; i < num/2; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
