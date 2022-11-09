import java.util.ArrayList;
import java.util.Arrays;

class Solution {
   static int[] solution(String[][] places) {

        int[] answer = new int[places.length];
        for(int i = 0; i < places.length; i++) {
            ArrayList<int[]> list = new ArrayList<>();
            String[] place = places[i];
            char[][] arr = new char[place.length][place[0].length()];
            for(int j = 0; j < place.length; j++) {
                for(int k = 0; k < place[0].length(); k++) {
                    arr[j][k] = place[j].charAt(k);
                    if(arr[j][k] == 'P') {
                        list.add(new int[]{j, k});
                    }
                }
            }
            answer[i] = check(arr,list);
//            System.out.println(Arrays.deepToString(arr));
//            System.out.println(check(arr, list));
        }

//        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static int check(char[][] place, ArrayList<int[]> pList) {
        for(int[] p : pList) {
            for(int[] pp : pList) {
                if(Arrays.equals(p, pp)) {
                    continue;
                }

                int length = Math.abs(p[1]-pp[1])+Math.abs(p[0]-pp[0]);
                if(length > 2) {
                    continue;
                } else if(length == 2) {
                    if(Math.abs(p[1]-pp[1]) == 1 && Math.abs(p[0]-pp[0]) == 1) {
                        if(!(place[pp[0]][p[1]] == 'X' && place[p[0]][pp[1]] == 'X')) {
                            return 0;
                        }
                    } else if(Math.abs(p[1]-pp[1]) == 2 || Math.abs(p[0]-pp[0]) == 2) {
                        int midY = (pp[0] + p[0])/2;
                        int midX = (pp[1] + p[1])/2;
                        if(place[midY][midX] == 'O') {
                            return 0;
                        }
                    }
                } else if(length < 2) {
                    return 0;
                }
            }
        }
        return 1;
    }
}