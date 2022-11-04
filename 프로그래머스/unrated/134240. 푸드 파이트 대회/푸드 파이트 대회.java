import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i < food.length; i++) {
            int cnt = food[i]/2;
            sb.append(Integer.toString(i).repeat(cnt));
        }
        
        return sb.toString() + "0" + sb.reverse().toString();

    }
}