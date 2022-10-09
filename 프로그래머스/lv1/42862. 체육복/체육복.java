import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;

        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length;j++) {
                if(reserve[j] == 0) 
                    continue;
                if(lost[i] == reserve[j]) {
                    lost[i] = 0;
                    reserve[j] = 0;
                    answer++;
                }
            }
        }
        
        Arrays.sort(lost); 
        Arrays.sort(reserve);
        
        for(int i = 0; i < lost.length; i++) {
            if(lost[i] == 0) {
                continue;
            }
            
            for(int j = 0; j < reserve.length; j++) {
                if(answer == n) {
                    return n;
                }
                if(reserve[j] == 0) 
                    continue;
                
                if(Math.abs(lost[i]-reserve[j]) <= 1) {
                    answer++;
                    reserve[j] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}