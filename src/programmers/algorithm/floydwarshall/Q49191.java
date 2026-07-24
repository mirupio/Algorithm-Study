package programmers.algorithm.floydwarshall;

import java.util.*;

class Q49191 {
    public int solution(int n, int[][] results) {
        int answer = 0;

        // dp[i][j] = i부터 j까지의 도달 가능 여부
        boolean[][] dp = new boolean[n+1][n+1];

        for(int[] result: results){
            int winner = result[0];
            int loser = result[1];

            dp[winner][loser] = true;
        }

        for(int k=1;k<n+1;k++){
            for(int i=1;i<n+1;i++){
                for(int j=1;j<n+1;j++){
                    if(dp[i][k] && dp[k][j]){
                        dp[i][j] = true;
                    }
                }
            }
        }

        for(int k=1;k<n+1;k++){
            int count = 0;
            for(int i=1;i<n+1;i++){
                for(int j=1;j<n+1;j++){
                    // k가 이긴 애들 : dp[k][j] = k->j
                    if(i == k && dp[i][j]==true){
                        count++;
                    }
                    // k를 이긴 애들 : dp[i][k] = i->k
                    if(j == k && dp[i][j]==true){
                        count++;
                    }
                }
            }
            if(count == n-1){
                answer++;
            }
        }

        return answer;
    }

}