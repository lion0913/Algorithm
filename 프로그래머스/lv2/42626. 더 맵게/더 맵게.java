import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
    
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }
        
        while(queue.peek() < K) {
            if(queue.size() < 2) return -1;
            int newScoville = queue.poll() + queue.poll()*2;
            queue.add(newScoville);
           
            answer++;
        }
        return answer;
    }
}