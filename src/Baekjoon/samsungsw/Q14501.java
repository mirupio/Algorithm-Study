package Baekjoon.samsungsw;

import java.io.*;
import java.util.*;

public class Q14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][2];
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            arr[i][0] = T; // 기간
            arr[i][1] = P; // 금액
        }

        int[] dp = new int[N+2];
        for(int i=N;i>=1;i--){
            if(i+arr[i][0] <= N+1){
                dp[i] = Math.max(dp[i+1], arr[i][1]+dp[i+arr[i][0]]);
            }
            else{
                dp[i] = dp[i+1];
            }
        }

        System.out.println(dp[1]);
    }
}
