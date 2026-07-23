package programmers.algorithm.dp;

class Q43105 {
    public int solution(int[][] triangle) {

        // dp : 해당 위치에 도달할 때까지 합 중 최댓값
        int[][] dp = new int[triangle.length][];
        for(int n=0;n<triangle.length;n++){
            dp[n] = new int[n+1];
        }

        dp[0][0] = triangle[0][0];

        dp[1][0] = triangle[0][0]+triangle[1][0];
        dp[1][1] = triangle[0][0]+triangle[1][1];

        for(int n=2;n<triangle.length;n++){
            dp[n][0] = dp[n-1][0]+triangle[n][0];
            for(int i=1;i<n;i++){
                dp[n][i] = Math.max(dp[n-1][i-1],dp[n-1][i])+triangle[n][i];
            }
            dp[n][n] = dp[n-1][n-1]+triangle[n][n];
        }

        /*
        for(int[] i:dp){
            for(int num:i){
                System.out.print(num+" ");
            }
            System.out.println();
        }
        */

        int max = 0;
        for(int num: dp[triangle.length-1]){
            max = Math.max(max, num);
        }
        return max;
    }
}