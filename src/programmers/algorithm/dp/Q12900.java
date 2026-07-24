package programmers.algorithm.dp;

class Q12900 {
    public int solution(int n) {
        int answer = 0;
        int mod = 1000000007;

        int[] dp = new int[n+1];
        dp[1] = 1;

        if(n>=2){
            dp[2] = 2;
        }

        for(int i=3;i<n+1;i++){
            dp[i] = (dp[i-1]+dp[i-2])%mod;
        }

        return dp[n];
    }
}