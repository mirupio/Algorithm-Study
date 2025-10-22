package Baekjoon.ppusda.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] red = new int[N];
        int[] green = new int[N];
        int[] blue = new int[N];
        for (int i = 0; i < N; i++) {
            String[] tokens = br.readLine().split(" ");

            red[i] = Integer.parseInt(tokens[0]);
            green[i] = Integer.parseInt(tokens[1]);
            blue[i] = Integer.parseInt(tokens[2]);
        }

        long[][] dp = new long[N][3];

        // 기본값 설정
        dp[0][0] = red[0];
        dp[0][1] = green[0];
        dp[0][2] = blue[0];

        for(int i = 1; i < N; i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + red[i];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + green[i];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + blue[i];
        }

        /*
        for(int i = 0; i < N; i++){
            for(int j = 0; j <= 2; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
         */

        long min = dp[N-1][0];
        for(int i=1;i<=2;i++){
            if(min > dp[N-1][i]){
                min = dp[N-1][i];
            }
        }

        System.out.println(min);
    }
}
