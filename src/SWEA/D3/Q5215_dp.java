package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5215_dp {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            System.out.print("#"+t+" ");

            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            int[] score = new int[N+1];
            int[] cal = new int[N+1];

            for (int i = 1; i < N+1; i++) {
                st = new StringTokenizer(br.readLine().trim());
                score[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[N+1][L+1];

            for (int i = 0; i < L+1; i++) {
                dp[0][i] = 0;
            }

            for (int i = 1; i < N+1; i++) {
                for(int j = 0; j < L+1; j++) {
                    if(cal[i] > j){
                        dp[i][j] = dp[i-1][j];
                    }
                    else{
                        dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-cal[i]]+score[i]);
                    }
                }
            }

            System.out.print(dp[N][L]);
            System.out.println();
        }
    }
}
