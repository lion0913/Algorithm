import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            ArrayList<Integer> arr = new ArrayList<>();
            for(int j = command[0]-1; j < command[1]; j++) {
                arr.add(array[j]);
            }
            
            Collections.sort(arr);
            answer[i] = arr.get(command[2]-1);
        }
        
        return answer;
    }
}