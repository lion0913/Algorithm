import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] A, B;
    static int N, len;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        A = new int[N];
        B = new int[N];
        len = 0;

        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st2.nextToken());
            if(A[i] == B[i]) {
                len++;
            }
        }

        if(len == N) {
            System.out.println(1);
            return;
        }

        int result = select(0, N-1, Q);
        System.out.println(result == -1 ? 1:0);

    }

    public static int select(int p, int r, int q) {
        if(p == r) return A[p];
        int t = partition(p,r);
        if(t == -1) return -1;

        int k = t - p + 1;
        if(q < k) {
            return select(p, t - 1, q);
        }
        else if(q == k)
            return A[t];
        else {
            return select(t + 1, r, q - k);
        }
    }

    static int partition(int p, int r) {
        int x = A[r];
        int i = p-1;
        for(int j = p; j < r; j++) {
            if(A[j] <= x){
                ++i;
                if(A[i] == B[i]) len--;
                if(A[j] == B[j]) len--;
                if(A[i] == B[j]) len++;
                if(A[j] == B[i]) len++;
                if(len == N) return -1;

                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        if(i+1 != r) {
            if(A[i+1] == B[i+1]) len--;
            if(A[r] == B[r]) len--;
            if(A[i+1] == B[r]) len++;
            if(A[r] == B[i+1]) len++;
            if(len == N) return -1;

            int tmp = A[i+1];
            A[i+1] = A[r];
            A[r] = tmp;
        }
        return i+1;
    }

}
