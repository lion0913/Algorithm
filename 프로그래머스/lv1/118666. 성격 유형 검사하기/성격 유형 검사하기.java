import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Character[][] types = {{'R', 'T'},{'C', 'F'}, {'J','M'},{'A', 'N'}};

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < survey.length; i++) {
            String s = survey[i];
            int choice = choices[i];
            if(choice < 4) {
                Integer num = map.getOrDefault(s.charAt(0), 0);
                map.put(s.charAt(0), num+ (4-choice));
            } else if(choice > 4) {
                int num = map.getOrDefault(s.charAt(1), 0);
                map.put(s.charAt(1), num+ (choice-4));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 4; i++) {
            int t1 = map.getOrDefault(types[i][0], 0);
            int t2 = map.getOrDefault(types[i][1], 0);

            if(t1 > t2) {
                sb.append(types[i][0]);
            } else if(t1 < t2) {
                sb.append(types[i][1]);
            } else {
                char c = types[i][0]-types[i][1] < 0? types[i][0] : types[i][1];
                sb.append(c);
            }
        }

        return sb.toString();
    }
}