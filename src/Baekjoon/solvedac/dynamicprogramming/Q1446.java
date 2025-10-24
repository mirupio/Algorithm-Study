package Baekjoon.solvedac.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][3];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            arr[i][0] = start;
            arr[i][1] = end;
            arr[i][2] = distance;
        }

        long[] dp = new long[D+1];
        // 밑에서 최솟값이 0이 수렴하지 않도록 우선 초기화
        for(int i=0;i<=D;i++){
            dp[i] = i; // 리팩토링3️⃣
        }
        for(int i=1;i<=D;i++){
            // 현재 위치의 최소거리
            // = "기존에 지름길로 업데이트 했었다면 그 값, 이전 위치의 최소거리 + 1" 중 최솟값
            dp[i] = Math.min(dp[i],dp[i-1] + 1); // 리팩토링2️⃣
            for(int j=0;j<N;j++){
                if(arr[j][1] == i) { // 현재 위치가 지름길(도착위치 기준) 중 있다면
                    // "출발위치까지의 최소거리+거리, 도착위치의 이전 위치까지의 최소거리+1" 중 최솟값
                    dp[i] = Math.min(dp[arr[j][0]]+arr[j][2], dp[i]); // 리팩토링1️⃣
                }
            }
        }

        /*
        for(int i=0;i<=D;i++){
            System.out.println("i:"+ i+ " " + dp[i]);
        }
         */

        System.out.println(dp[D]);
    }
}
