package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12865 {

    static int[] W;
    static int[] V;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        W = new int[N];
        V = new int[N];

        dp = new Integer[N][K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(knapSack(N - 1, K));
    }

    static int knapSack(int i, int k) {
        if (i < 0) return 0;

        if (dp[i][k] == null) {
            if (W[i] > k) {
                dp[i][k] = knapSack(i - 1, k);
            } else {
                dp[i][k] = Math.max(knapSack(i - 1, k), knapSack(i - 1, k - W[i]) + V[i]);
            }
        }

        return dp[i][k];
    }
}
