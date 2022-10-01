class Solution {
    static int[] numList;
    static int t, answer = 0;

     public int solution(int[] numbers, int target) {
        numList = numbers;
        t = target;


        bfs(0, 0);

        // System.out.println(answer);
        return answer;
    }

    public static void bfs(int level, int result) {
        if(level == numList.length) {
            if(result == t) {
                answer++;
            }
            return;
        }

        bfs(level+1, result+numList[level]);
        bfs(level+1, result-numList[level]);
    }
}