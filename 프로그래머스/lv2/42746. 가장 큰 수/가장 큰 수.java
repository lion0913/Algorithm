import java.util.*;

class Solution { 
    public String solution(int[] numbers) {
        String answer = "";
        
        ArrayList<String> list = new ArrayList<>();
        for(int num : numbers) {
            list.add(Integer.toString(num));
        }
        
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String n1, String n2) {
                return (n2+n1).compareTo(n1+n2);
            }
        });
        
        for(String s : list) {
            answer += s;
        }
        
        return answer.charAt(0) == '0'? "0" : answer;
    }
}