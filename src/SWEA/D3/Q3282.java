package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 0/1 Knapsack
public class Q3282 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] V = new int[N+1];
            int[] C = new int[N+1];
            for(int i=1;i<N+1;i++) {
                st = new StringTokenizer(br.readLine());
                V[i] = Integer.parseInt(st.nextToken());
                C[i] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[N + 1][K + 1];
            for(int i=1;i<N+1;i++) {
                dp[0][i] = 0;
            }

            for(int i=1;i<N+1;i++) {
                for (int j = 0; j < K + 1; j++) {
                    if (j < V[i]) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    else{
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - V[i]] + C[i]);
                    }
                }
            }
            System.out.println("#"+t+" "+dp[N][K]);
        }
    }
}
