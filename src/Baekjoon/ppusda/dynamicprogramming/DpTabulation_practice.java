package Baekjoon.ppusda.dynamicprogramming;

// Bottom-Up(반복문)
public class DpTabulation_practice {
    static int fib(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // 점화식 적용 -> 반복문으로 채움
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;

        System.out.println("fib(" + n + ") = " + fib(n));
    }
}
