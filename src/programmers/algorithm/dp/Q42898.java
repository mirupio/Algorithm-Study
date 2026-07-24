package programmers.algorithm.dp;

class Q42898 {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int mod = 1000000007;

        // dp[i][j] : i,j까지 최단으로 갈 수 있는 경우의 수
        int[][] dp = new int[n][m];
        for(int i=1;i<n;i++){
            dp[i][0] = 1;
        }

        for(int j=1;j<m;j++){
            dp[0][j] = 1;
        }

        for(int[] puddle: puddles){
            int row = puddle[1]-1;
            int col = puddle[0]-1;
            dp[row][col] = -1;

            if(row == 0){
                for(int j=col;j<m;j++){
                    dp[row][j] = -1;
                }
            }
            else if(col == 0){
                for(int i=row;i<n;i++){
                    dp[i][col] = -1;
                }
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(dp[i][j] != -1){
                    if(dp[i-1][j] != -1 && dp[i][j-1] != -1){
                        dp[i][j] = (dp[i-1][j] + dp[i][j-1])%mod;
                    }
                    else if(dp[i-1][j] == -1 && dp[i][j-1] != -1){
                        dp[i][j] = dp[i][j-1];
                    }
                    else if(dp[i-1][j] != -1 && dp[i][j-1] == -1){
                        dp[i][j] = dp[i-1][j];
                    }
                    else if(dp[i-1][j] == -1 && dp[i][j-1] == -1){
                        dp[i][j] = -1;
                    }
                }
            }
        }

        /*
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        */

        return dp[n-1][m-1]==-1?0:dp[n-1][m-1];
    }
}