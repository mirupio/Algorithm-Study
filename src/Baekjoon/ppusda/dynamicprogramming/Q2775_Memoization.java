package Baekjoon.ppusda.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2775_Memoization {
    static Integer[][] dp;

    static int dynamic(int row, int col) {
        if(dp[row][col] == null) {
            dp[row][col] = dynamic(row-1, col) + dynamic(row, col-1);
        }

        return dp[row][col];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            dp = new Integer[k+1][n+1];

            // 기본값 설정
            for(int i=0;i<=n;i++){
                dp[0][i] = i;
            }
            for(int i=1;i<=k;i++){
                dp[i][0] = 0;
                dp[i][1] = 1;
            }

            System.out.println(dynamic(k,n));
        }

    }
}
