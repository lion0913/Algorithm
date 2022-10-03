import java.util.LinkedList;
import java.util.Queue;
class Solution {
    
            public static int solution(int[][] maps) {
        int answer = 0;

        int[][] dist = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int[][] isVisited = new int[maps.length][maps[0].length];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1});
        isVisited[0][0] = 1;
        int min = Integer.MAX_VALUE;

        while(!q.isEmpty()) {
            int[] val = q.poll();

            if(val[0] == maps.length -1 && val[1] == maps[0].length-1){
                if(val[2] < min) {
                    min = val[2];
                    continue;
                }
            }

            for(int i = 0; i < 4; i++) {
                int newX = val[0] + dist[i][0];
                int newY = val[1] + dist[i][1];

                if(newX >= 0 && newY >= 0 && newX < maps.length && newY < maps[0].length && isVisited[newX][newY] == 0 && maps[newX][newY] == 1) {
                    // System.out.printf("%d %d \n", newX, newY);
                    isVisited[newX][newY] = 1;
                    q.add(new int[]{newX, newY, val[2]+1});
                }
            }
        }
        answer = (min == Integer.MAX_VALUE)? -1 : min;
        System.out.println(answer);
        return answer;
    }
}