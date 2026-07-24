package programmers.algorithm.floydwarshall;

import java.util.*;

class Q12978 {
    public int solution(int N, int[][] roads, int K) {
        int answer = 0;

        int[][] dp = new int[N+1][N+1];
        for(int i=1;i<N+1;i++){
            Arrays.fill(dp[i],100000000);
            dp[i][i] = 0;
        }
        for(int[] road:roads){
            dp[road[0]][road[1]] = Math.min(dp[road[0]][road[1]],road[2]);
            dp[road[1]][road[0]] = Math.min(dp[road[1]][road[0]],road[2]);
        }

        for(int k=1;k<N+1;k++){
            for(int i=1;i<N+1;i++){
                for(int j=1;j<N+1;j++){
                    dp[i][j] = Math.min(dp[i][j],dp[i][k]+dp[k][j]);
                }
            }
        }

        /*
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        */

        for(int k=1;k<N+1;k++){
            if(dp[1][k]<=K){
                answer++;
            }
        }
        return answer;
    }
}