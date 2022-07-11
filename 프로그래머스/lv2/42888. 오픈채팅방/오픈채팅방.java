import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[][] list = new String[record.length][2];
        int cnt = 0;
        HashMap<String, String> nameList = new HashMap<>();
        
        for(String msg : record) {
            String[] rList = msg.split(" ");
            //타입 별로 분기
            if(rList[0].equals("Enter")) {
                nameList.put(rList[1], rList[2]);
                list[cnt][0] = rList[1];
                list[cnt++][1] = "in";
            } else if(rList[0].equals("Change")) {
                nameList.put(rList[1], rList[2]);
            } else {
                list[cnt][0] = rList[1];
                list[cnt++][1] = "out";
            }
        }
        
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < cnt; i++) {
            String nickname = nameList.get(list[i][0]);
            String ment = nickname+"님이 ";
            if(list[i][1].equals("out")) {
                ment += "나갔습니다.";
            } else {
                ment += "들어왔습니다.";
            }
            answer.add(ment);
        }
        return answer.toArray(String[]::new);
    }
}