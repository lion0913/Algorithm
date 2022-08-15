import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int t = scanner.nextInt();
		int type = scanner.nextInt();
		
		int round = 1;
		int ffun = 0;
		int degi = 0;
		loop:while(true) {
			
			for(int i = 0; i<4; i++) {
				if(i%2==0) {
					ffun++;
				}
				else {
					degi++;
				}
				if(type==0) {
					if(ffun == t) {
						break loop;
					}
				}
				else {
					if(degi == t) {
						break loop;
					}
				}
			}
			
			for(int i = 0; i<=round; i++) {
				ffun++;
				if(type == 0 && ffun == t)
					break loop;
			}
			for(int i = 0; i<=round; i++) {
				degi++;
				if(type == 1 && degi ==t)
					break loop;
			}
			round++;
		}
		
		int total = ffun + degi;
		int ans = total % n;
		
		if(ans == 0) {
			System.out.println(n-1);
		}
		else {
			System.out.println(ans-1);
		}
		
	}
}