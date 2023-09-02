import java.util.*;

class Solution {
    static int[][] map;
    static boolean[][] visited;
    static int finalY, finalX;
    
    public int solution(int[][] maps) {
        int[] routeX = {0, 0, -1, 1};
        int[] routeY = {-1,1,0,0};
        
        finalY = maps.length - 1;
        finalX = maps[0].length - 1;
        map = maps;
        visited = new boolean[maps.length][maps[0].length];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1}); //첫번째가 y, 두번째가 x, 세번째는 cnt
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] values = q.poll();
            int cnt = values[2];

            if(values[0] == finalY && values[1] == finalX) {
                return cnt;
            }
            
            for(int i = 0; i < 4; i++) {
                int newX = values[1]+routeX[i];
                int newY = values[0]+routeY[i];

                if(checkValidate(newX, newY)) {
                    q.offer(new int[]{newY, newX, cnt + 1});
                    visited[newY][newX] = true;
                }
            }
        }
        return -1;
    }
    
    public boolean checkValidate(int x, int y) {
        if(x < 0 || x > finalX || y < 0 || y > finalY) {
            return false;
        } 
        if(map[y][x] == 0 || visited[y][x]) {
            return false;
        }
        return true;
    }
}