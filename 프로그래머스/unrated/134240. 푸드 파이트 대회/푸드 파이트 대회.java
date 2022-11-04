import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i < food.length; i++) {
            int cnt = food[i]/2;
            for(int j = 0; j < cnt; j++) {
                sb.append(String.valueOf(i));
            }
        }
        sb.append("0");
        
        String s = sb.toString();
        for(int i = sb.toString().length()-2; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        // System.out.println(sb.toString());
        return sb.toString();
    }
}