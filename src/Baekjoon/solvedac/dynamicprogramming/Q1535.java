package Baekjoon.solvedac.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1535 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] power = new int[N+1];
        for(int i=1;i<=N;i++){
            power[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] happy = new int[N+1];
        for(int i=1;i<=N;i++){
            happy[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[100][N+1];
        for(int i=1;i<=N;i++){
            for(int j=0;j<100;j++){
                if(power[i] > j){
                    dp[j][i] = dp[j][i-1];
                }

                else{
                    dp[j][i] = Math.max(dp[j][i-1],happy[i] + dp[j-power[i]][i-1]);
                }
            }
        }

        /*for(int i=0;i<100;i++){
            for(int j=0;j<=N;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }*/

        System.out.println(dp[99][N]);

    }
}
