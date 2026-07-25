package programmers.algorithm.floydwarshall;

import java.util.*;

class Q72413 {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int INF = 1000000000;
        int[][] dp = new int[n+1][n+1];
        for(int i=1;i<n+1;i++){
            Arrays.fill(dp[i],INF);
            dp[i][i] = 0;
        }

        for(int[] fare:fares){
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];

            dp[from][to] = cost;
            dp[to][from] = cost;
        }

        for(int k=1;k<n+1;k++){
            for(int i=1;i<n+1;i++){
                for(int j=1;j<n+1;j++){
                    dp[i][j] = Math.min(dp[i][j],dp[i][k]+dp[k][j]);
                }
            }
        }

        int answer = INF;
        for(int k=1;k<n+1;k++){
            if (dp[s][k] == INF || dp[k][a] == INF || dp[k][b] == INF) {
                continue;
            }
            answer = Math.min(answer,dp[s][k] + dp[k][a] + dp[k][b]);
        }

        return answer;
    }
}
