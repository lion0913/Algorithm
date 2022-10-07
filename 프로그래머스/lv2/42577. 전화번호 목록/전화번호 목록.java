import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        System.out.println(Arrays.toString(phone_book));
        Arrays.sort(phone_book);
        System.out.println(Arrays.toString(phone_book));
        for(int i = 0; i < phone_book.length; i++) {
            String base = phone_book[i];
            for(int j = 0; j < phone_book.length; j++) {
                if(i == j) continue;
                if(phone_book[j].startsWith(base)){
                    return false;
                }
            }
        }
        return answer;
    }
}