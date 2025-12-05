package Baekjoon.algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] dp = new int[n+1];

            dp[1] = 1;

            if (n >= 2){
                dp[2] = 2;
            }

            if (n >= 3){
                dp[3] = 4;
            }

            for(int i=4;i<=n;i++){
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }

            /*for(int i=0 ; i<=n; i++){
                System.out.print(dp[i] + " ");
            }
            System.out.println();*/

            System.out.println(dp[n]);
        }

    }
}
