import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        for(String c : completion) {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        // System.out.println(map);
        for(String p : participant) {
            int i = map.getOrDefault(p, 0);
            if(i == 0) 
                return p;
            map.put(p, i-1);
        }
       
        return "a";
    }
}