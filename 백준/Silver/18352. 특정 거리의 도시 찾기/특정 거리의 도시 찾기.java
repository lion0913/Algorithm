import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static HashMap<Integer, ArrayList<Integer>> map;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int m = 1; m <= M; m++) {
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            ArrayList<Integer> list =map.getOrDefault(c1, new ArrayList<>());
            list.add(c2);
            map.put(c1, list);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);
        dist[X] = 0;
        while(!queue.isEmpty()) {
            int n = queue.poll();
            ArrayList<Integer> nList = map.get(n);
            if(nList != null) {
                for (int i : nList) {
                    if(dist[i] == Integer.MAX_VALUE) {
                        dist[i] = dist[n] + 1;
                        queue.add(i);
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i = 1; i <= N; i++) {
            if(dist[i] == K) {
                sb.append(i+"\n");
            }
        }
        if(sb.isEmpty()) {
            System.out.println("-1");
        } else {
            System.out.println(sb);
        }
    }
}
