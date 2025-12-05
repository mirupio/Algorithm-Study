package Baekjoon.algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];

        dp[0] = 0;
        dp[1] = 0;

        /*
        for(int i = 2; i <= N; i++){
            if(i % 3 == 0){
                dp[i] = dp[i/3] + 1;
            }
            else if(i % 2 == 0){
                dp[i] = dp[i/2] + 1;
            }
            else{
                dp[i] = dp[i-1] + 1;
            }
        }
         */

        for(int i = 2; i <= N; i++){
            dp[i] = dp[i-1] + 1;  // 1을 빼는 경우 기본값으로 설정

            if(i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }

            if(i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }
        }

        /*
        for(int i=0;i<=N;i++){
            System.out.print(dp[i] + " ");
        }
        System.out.println();
         */

        System.out.println(dp[N]);
    }
}
