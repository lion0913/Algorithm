import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // list : 소 착유 순서
        int[] list = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        // 소 정렬 순서
        int[] orderList = new int[N + 1];
        // 지정 순서부터 차례대로 배치
        for (int i = 1; i < K + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int order = Integer.parseInt(st.nextToken());
            orderList[order] = cow;
        }

        //소 착유 순서에 맞춰 배치
//        System.out.println("소 착유 순서:"+Arrays.toString(list));
//        System.out.println("전체 순서"+Arrays.toString(orderList));
        boolean result = false;
        for(int j = 1; j < N+1; j++) {
//            result = false;
            if(orderList[j] == 0) {
                result = true;
                orderList[j] = 1;

//                System.out.println("소 배치 순서 : "+Arrays.toString(orderList));
//                System.out.println("착유 순서:" +Arrays.toString(list));

                int zerocnt = 0;
                int cnt = 0; //서열 list에서의 카운트
                int bIdx = -1;

                for (int i = 1; i < orderList.length; i++) {
                    //만약에 지정된 자리의 소가 서열소순서 리스트에 들어가 있는 경우
                    int idx = contains(list, orderList[i]);
//                    bIdx= idx;
                    if (idx != -1) {
//                        System.out.println("idx: "+idx);
//                        System.out.println(orderList[i] + "번째 소는 착유순서리스트에 포함되어 있음");
                        //서열 소 순서에 맞지 않게 배치된 경우 바로 -1 리턴 후 종료
                        if (list[cnt] != orderList[i]) {
//                            System.out.println("zerocnt:" + zerocnt);
//                            System.out.printf("idx:%d, bIdx:%d\n",idx,bIdx);
//                            zeroArray.add(idx - bIdx - 1);
//                    bIdx!=0 &&
                            if(bIdx == -1 && (zerocnt == 0)){
//                                System.out.println("case1");
                                result= false;
                                break;
//                                bIdx = idx;
                            } else if (zerocnt >= (idx - bIdx - 1)) {
//                                System.out.println("case2");
                                zerocnt = 0;
                                bIdx = idx;
                            } else {
//                                System.out.println("case3");
//                        System.out.println("-1");
                                result= false;
                                break;
                            }
                        } else { //맞게 배치된 경우
                            bIdx = idx;
                            cnt++;
                        }
                    } else if (orderList[i] == 0) {
                        zerocnt++;
                    }
                }
                if(result == true){
                    System.out.println(j);
                    return;
                } else {
                    orderList[j] = 0;
                }

            }
        }
        System.out.println("-1");
        return;
    }

    static int contains(int[] arr, int key) {
        for(int i = 0; i < arr.length; i++){
            if(arr[i]==key) return i;
        }
        return -1;
    }
    

}
