class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        for(int i = citations.length; i > 0; i--) {
            int up = 0, down = 0;
            boolean flag = false;
            for(int j = 0; j < citations.length; j++) {
                if(up >= i && down <= i) {
                    flag = true;
                    break;
                }
                    
                if(citations[j] >= i) {
                    up++;
                }
                if(citations[j] <= i) {
                    down++;
                }
            }
            if(flag || (up >= i && down <= i)) {
                return i;
            }
        }   
        return answer;
    }
}