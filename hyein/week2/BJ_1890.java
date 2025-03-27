package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[n][n];
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] > 0) {
                    int move = map[i][j];
                    if (move > 0) {
                        int nr = i + move;
                        int nc = j + move;
                        if (nr < n) {
                            dp[nr][j] += dp[i][j];
                        }
                        if (nc < n) {
                            dp[i][nc] += dp[i][j];
                        }
                    }

                }

            }
        }

        System.out.println(dp[n - 1][n - 1]);
    }
}
