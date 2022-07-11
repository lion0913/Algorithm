import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int x1, y1, r1, x2, y2, r2;
        int result;

        for(int i = 0; i < num; i++) {
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            r1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            r2 = sc.nextInt();

            double d = Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1,2));
            if(d == r1+r2) {
                result = 1;
            } else if(x1==x2 && y1 == y2 && r1 == r2) {
                result = -1;
            } else if(d == r1-r2 || d == r2-r1) {
                result = 1;
            } else if(d < r1-r2 || d < r2-r1) {
                result = 0;
            } else if(d > r1+r2) {
                result = 0;
            } else if(d < r1+r2) {
                result = 2;
            } else {
                result = 0;
            }
            System.out.println(result);
        }
        return;
    }
}
