import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
String answer = "";
        Map<Character, Integer> map = new HashMap<>();
        String type = "RTCFJMAN";

        for(int i = 0; i < type.length(); i++) {
            map.put(type.charAt(i), 0);
        }

        for(int i = 0; i < choices.length; i++) {
            if(choices[i] < 4) {
                Character s = survey[i].charAt(0);
                map.put(s, map.get(s) + 4 - choices[i]);
            } else if (choices[i] > 4) {
                Character s = survey[i].charAt(1);
                map.put(s, map.get(s)+choices[i] - 4);
            }
        }

        for(int i = 0; i < type.length(); i+=2) {
            if(map.get(type.charAt(i)) >= map.get(type.charAt(i+1))) {
                answer += String.valueOf(type.charAt(i));
            } else {
                answer += String.valueOf(type.charAt(i+1));
            }
        }
        return answer;
    }
}