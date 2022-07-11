import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader는 문자열에 최적화되어있음(Scanner보다 훨씬 빠르다 (6배정도))
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int cnt = s.length();
        long num = Long.parseLong(s);
        long max = num;

//        System.out.printf("%s %d",s, cnt);
        for(int i = 0; i < cnt+1; i++) {
            long tmp = (long)Math.pow(10, i);
            //반올림계산
            num = (Math.round(num/(double)tmp)*tmp);
            if(num > max) max = num;

        }
        System.out.println(max);

        return;
    }
}
