package Baekjoon.ppusda.dynamicprogramming;

// Top-Down(재귀)
public class DpMemoization_practice {
    static int[] dp;

    static int fib(int n){
        if(dp[n] != -1) return dp[n]; // 이미 계산한 값이 있으면 반환

        if(n <= 1) return dp[n] = n; // 기본값

        return dp[n] = fib(n-1) + fib(n-2); // 점화식 적용 -> 재귀로 새로 계산해서 저장
    }

    public static void main(String[] args) {
        int n = 10;

        dp = new int[n+1];

        // dp 초기화 (아직 계산되지 않은 상태 = -1)
        for(int i=0; i<=n ; i++){
            dp[i] = -1;
        }

        System.out.println("fib(" + n + ") = " + fib(n));
    }
}
