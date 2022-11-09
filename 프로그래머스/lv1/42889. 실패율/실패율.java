import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 1; i <= N+1; i++) {
            map.put(i, 0);
        }

        int total = stages.length;

        for(int stage : stages) {
            int num = map.get(stage);
            map.put(stage, num+1);
        }

        PriorityQueue<Stage> queue = new PriorityQueue<>();
        for(int i = 1; i < N+1; i++) {
            double failRate = map.get(i) == 0? 0: (double)map.get(i)/total;
            queue.add(new Stage(i, failRate));
            total -= map.get(i);
        }

        int[] answer = new int[N];
        for(int i = 0; i < N; i++) {
            answer[i] = queue.poll().level;
        }
        return answer;
    }
}

class Stage implements Comparable<Stage> {
    int level;
    double failRate;

    Stage(int level, double failRate) {
        this.level = level;
        this.failRate = failRate;
    }

    @Override
    public int compareTo(Stage s) {
        if(s.failRate == this.failRate) {
            return this.level- s.level;
        }
        return (s.failRate - this.failRate < 0)?-1:1;
    }


}