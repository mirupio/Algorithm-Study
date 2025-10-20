package Baekjoon.ppusda.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            long[] dp = new long[N+1];
            long[] init = {1,1,1,2,2};

            /*
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 2;
            dp[4] = 2;
             */

            if(N <= 5){
                System.out.println(init[N-1]);
            }
            else{
                System.arraycopy(init, 0, dp, 0, init.length);
                for(int i = 5; i < N; i++) {
                    dp[i] = dp[i-5] + dp[i-1];
                }
                /*
                for(int i=0;i<N;i++){
                    System.out.print(dp[i]+" ");
                }
                System.out.println();
                 */

                System.out.println(dp[N-1]);
            }
        }
    }
}
