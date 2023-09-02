import java.util.*;

class Solution {
    static int totalCnt;
    static int targetNum;
    static int answer;
    static int[] numberArr;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        totalCnt = numbers.length;
        targetNum = target;
        numberArr = numbers;
        
        //경우의 수 구하기
        dfs(0, 0);
        return answer;
    }
    
    public void dfs(int cnt, int sum) { //cnt: 현재까지의 숫자 
        if(cnt == totalCnt) {
            if(sum == targetNum) {
                answer++;
            }
            return;
        }
            
        dfs(cnt + 1, sum + numberArr[cnt]);
        dfs(cnt + 1, sum - numberArr[cnt]);
    }
}