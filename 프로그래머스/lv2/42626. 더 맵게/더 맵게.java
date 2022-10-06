import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
    
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < scoville.length; i++) {
            // list.add(scoville[i]);
            queue.add(scoville[i]);
        }
        // Collections.sort(list);
        
        while(queue.peek() < K) {
            if(queue.size() < 2) return -1;
            int newScoville = queue.poll() + queue.poll()*2;
            queue.add(newScoville);
            // list.add(1, newScoville);
             // System.out.println(list);
            // list.remove(0);
            // list.remove(1);
            
            // System.out.println(queue);
            // Collections.sort(queue);
           
            answer++;
        }
        return answer;
    }
}