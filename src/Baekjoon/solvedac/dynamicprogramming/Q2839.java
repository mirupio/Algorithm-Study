package Baekjoon.solvedac.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = -1;
        dp[2] = -1;
        dp[3] = 1;

        if(N == 3 || N == 5){
            System.out.println(1);
        }
        if(N == 4){
            System.out.println(-1);
        }
        if(N >= 6){
            dp[4] = -1;
            dp[5] = 1;

            for(int i = 6; i <= N; i++) {
                if(dp[i-5] == -1){
                    if(dp[i-3] == -1){
                        dp[i] = -1;
                    }
                    else{
                        dp[i] = dp[i-3] + 1;
                    }
                }
                else{
                    dp[i] = dp[i-5] + 1;
                }
            }

            /*for(int i=0;i<=N;i++){
                System.out.print(dp[i] + " ");
            }
            System.out.println();*/

            System.out.println(dp[N]);
        }
    }
}
