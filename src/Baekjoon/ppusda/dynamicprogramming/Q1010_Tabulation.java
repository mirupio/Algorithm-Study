package Baekjoon.ppusda.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1010_Tabulation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int n = Math.min(N, M);
            int m = Math.max(N, M);

            int[][] dp = new int[m + 1][m + 1];

            // 기본값 설정
            for(int i = 0; i <= m; i++) {
                for(int j = 0; j <= m; j++) {
                    if(i == j) {
                        dp[i][j] = 1;
                    }
                    if(j == 0){
                        dp[i][j] = 1;
                    }
                    if(j > i){
                        dp[i][j] = 0;
                    }
                }
            }

            for(int i = 2; i <= m; i++) {
                for(int j = 1; j < i; j++) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }

            }

            /*
            for(int i = 0; i <= m; i++) {
                for(int j = 0; j <= m; j++) {
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("끝");
             */

            System.out.println(dp[m][n]);
        }

    }
}
