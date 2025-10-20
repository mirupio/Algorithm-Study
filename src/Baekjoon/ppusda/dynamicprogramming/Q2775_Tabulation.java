package Baekjoon.ppusda.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2775_Tabulation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] dp = new int[k+1][n+1];

            // 기본값 설정
            for(int i=0;i<=n;i++){
                dp[0][i] = i;
            }
            for(int i=1;i<=k;i++){
                dp[i][0] = 0;
                dp[i][1] = 1;
            }

            for(int i=1;i<=k;i++){
                for(int j=1;j<=n;j++){
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }

            /*
            for(int i=0;i<=k;i++){
                for(int j=0;j<=n;j++){
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }
             */

            System.out.println(dp[k][n]);
        }
    }
}
