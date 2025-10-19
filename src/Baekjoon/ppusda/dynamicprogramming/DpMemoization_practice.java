package Baekjoon.ppusda.dynamicprogramming;

// Top-Down(재귀)
public class DpMemoization_practice {
    static Integer[] dp;

    static int fib(int n){
        if(dp[n] == null){
            dp[n] = fib(n-1) + fib(n-2);
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        dp = new Integer[n+1];

        // 기본값 설정
        dp[0] = 0;
        dp[1] = 1;

        System.out.println("fib(" + n + ") = " + fib(n));
    }
}
