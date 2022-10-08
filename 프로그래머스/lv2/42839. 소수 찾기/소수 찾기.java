import java.util.*;
import java.lang.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    static String num="";
    
    public int solution(String numbers) {
        // numbers = "123432";
        num = numbers;
        // System.out.println(numbers.length());
        int[] isVisited;
        for(int i = 0; i < numbers.length(); i++) {
            isVisited = new int[numbers.length()];
            isVisited[i] = 1;
            set.add(num.charAt(i)-'0');
            dfs(Character.toString(num.charAt(i)), isVisited, 1);
        }
        
        // System.out.println(set);
        int answer = 0;
        
        for(int n : set) {
            if(isPrime(n))
                answer++;
        }
        return answer;
    }
    
    static boolean isPrime(int n) {
        if(n == 0 || n == 1) return false;
        
        for(int i = 2; i < n; i++) {
            if(n % i == 0)
                return false;
        }
        System.out.println(n);
        return true;
    }
    
    static void dfs(String s, int[] isVisited, int cnt) {
        if(cnt == num.length()) {
            return;
        }
        for(int i = 0; i < num.length(); i++) {
            if(isVisited[i] == 0) {
                String newS = s + Character.toString(num.charAt(i));
                set.add(Integer.parseInt(newS));
                // System.out.println(s);
                isVisited[i] = 1;
                dfs(newS, isVisited, cnt+1);
                isVisited[i] = 0;
            }
        }
    }
}