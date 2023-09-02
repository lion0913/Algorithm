import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Food> q = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++) {
            q.add(new Food(scoville[i]));
        }
        
        while(!q.isEmpty()) {
            int first = q.poll().getScoville();
            if(first >= K) {
                return answer;
            }
            
            if(q.isEmpty()) {
                return -1;
            }
            int second = q.poll().getScoville();
            
            q.add(new Food(first+second*2));
            answer++;
        }
        return -1;
    }
}

class Food implements Comparable<Food> {
    private int scoville;
    
    public Food(int scoville) {
        this.scoville = scoville;
    }
    
    public int getScoville(){
        return this.scoville;
    }
    
    @Override
    public int compareTo(Food food) {
        return this.scoville - food.scoville;
    }
    
}