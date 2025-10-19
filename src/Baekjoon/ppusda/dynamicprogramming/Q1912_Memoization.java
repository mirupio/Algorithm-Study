package Baekjoon.ppusda.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1912_Memoization {
    static Integer[] dp;
    static int[] arr;
    static int MAX;

    static int dynamic(int n) {
        if(dp[n] == null) {
            dp[n] = Math.max(dynamic(n-1)+arr[n], arr[n]);
            MAX = Math.max(dp[n], MAX);
        }

        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        String[] tokens = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }

        dp = new Integer[n];

        // 기본값 설정
        dp[0] = arr[0];
        MAX = arr[0];

        dynamic(n-1);

        System.out.println(MAX);
    }
}
