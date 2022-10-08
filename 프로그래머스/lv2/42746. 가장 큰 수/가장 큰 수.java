import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            list.add(Integer.toString(numbers[i]));
            // strList[i] = answer.toString();
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String n1, String n2) {
                return (n2+n1).compareTo(n1+n2);
            }
        });
       
        for(String str : list) {
            answer += str;
        }
        if(answer.charAt(0) == '0'){
            return "0";
        }
        
        return answer;
    }
}