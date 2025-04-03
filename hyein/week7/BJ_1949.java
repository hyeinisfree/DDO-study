package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_1949 {
    public static int n;
    public static int[] people;
    public static boolean[] visited;
    public static ArrayList<Integer>[] graph;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        people = new int[n + 1];
        graph = new ArrayList[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[n + 1];
        dp = new int[n + 1][2];
        dfs(1);

        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    public static void dfs(int x) {
        visited[x] = true;
        dp[x][1] = people[x];
        for (Integer i : graph[x]) {
            if (!visited[i]) {
                dfs(i);
                dp[x][0] += Math.max(dp[i][0], dp[i][1]);
                dp[x][1] += dp[i][0];
            }
        }
    }
}
