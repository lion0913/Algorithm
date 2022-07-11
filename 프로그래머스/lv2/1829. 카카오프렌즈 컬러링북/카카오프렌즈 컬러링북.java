import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 1;
        
        int[][] tmp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                tmp[i][j] = picture[i][j];
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int result = sizeOfArea(tmp, tmp[i][j], i, j);
                if(result == 0) {
                    continue;
                } else {
                    numberOfArea++;
                    if(result > maxSizeOfOneArea) {
                        maxSizeOfOneArea = result;
                    }
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
    
    public int sizeOfArea(int[][] picture, int num, int x, int y) {
        
        if(x >= picture.length || y >= picture[0].length || x < 0 || y < 0 || (picture[x][y] == 0) || (picture[x][y] != num)) 
            return 0;
        picture[x][y] = 0;
        return 1 
            + sizeOfArea(picture, num, x+1, y) 
            + sizeOfArea(picture, num, x-1, y) 
            + sizeOfArea(picture, num, x, y+1) 
            + sizeOfArea(picture, num, x, y-1);
    }
    
}