package Baekjoon.ppusda.dynamicprogramming;

// Bottom-Up(반복문)
public class DpTabulation_practice {
    public static void main(String[] args) {
        int n = 10;
        int[] dp = new int[n + 1];

        // 기본값 설정
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println("fib(" + n + ") = " + dp[n]);
    }
}
