import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] list = new String[N];

        for(int i = 0; i < N; i++) {
            list[i] = br.readLine();
        }

        int answer = 0;
        String s = "";
        for(int i = 0; i < M; i++) {
            int[] cntList = new int[4]; // A, C, G, T 각각의 숫자 저장
            for(int j = 0; j < N; j++) {
                switch(list[j].charAt(i)) {
                    case 'A' :
                        cntList[0]++;
                        break;
                    case 'C' :
                        cntList[1]++;
                        break;
                    case 'G' :
                        cntList[2]++;
                        break;
                    case 'T' :
                        cntList[3]++;
                        break;
                }
            }
            int idx = max(cntList); //최댓값인덱스
//            System.out.println("max idx:"+idx);
            if(idx == 0) {
                s += "A";
            } else if (idx == 1) {
                s += "C";
            } else if (idx == 2) {
                s += "G";
            } else {
                s += "T";
            }
            answer += (N-cntList[idx]);
        }
        System.out.println(s);
        System.out.println(answer);
        
    }

    static int max(int[] list) {
        int max = 0;
        int idx = -1;
        for(int i = 0; i < list.length; i++) {
            if(list[i] == 0) continue;
            if(list[i] > max) {
                max = list[i];
                idx = i;
            }
        }
        return idx;
    }
}
