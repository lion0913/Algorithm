
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Node>[] list;

    public static class Node {
        int e;
        int value;
        public Node(int e, int value) {
            this.e = e;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        list = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            list[i] = new ArrayList<Node>();
        }

        for(int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            int k = Integer.parseInt(arr[0])-1;

            int idx = 1;
            while(!arr[idx].equals("-1")) {
                int edge = Integer.parseInt(arr[idx++])-1;
                int value = Integer.parseInt(arr[idx++]);

                Node node = new Node(edge, value);
                list[k].add(node);
            }
        }

        int[] distance1 = bfs(0);

        int d = 0, idx = 1;
        for(int i = 0; i < distance1.length; i++) {
            if(distance1[i] > d) {
                idx = i;
                d = distance1[i];
            }
        }

        int[] distance2 = bfs(idx);
//        System.out.println(Arrays.toString(distance2));
        Arrays.sort(distance2);
        System.out.println(distance2[distance2.length-1]);
    }

    public static int[] bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[list.length];
        int[] isVisited = new int[list.length];
        isVisited[n] = 1;

        queue.add(n);

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for (Node node : list[cur]) {
                if (isVisited[node.e] == 0) {
                    isVisited[node.e] = 1;
                    queue.add(node.e);
                    distance[node.e] = distance[cur]+distance[node.e]+node.value;
                }

            }
        }

        return distance;
    }
}
