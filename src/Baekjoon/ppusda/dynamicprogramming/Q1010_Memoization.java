package Baekjoon.ppusda.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1010_Memoization {
    static Integer[][] dp;

    static int dynamic(int row,int col){
        if(dp == null){
            dp[row][col] = dynamic(row-1,col-1) + dynamic(row-1,col);
        }

        return dp[row][col];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int n = Math.min(N, M);
            int m = Math.max(N, M);

            dp = new Integer[m + 1][m + 1];

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

            System.out.println(dynamic(m,n));
        }
    }
}
