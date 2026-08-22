package programmers;

// 시간 초과
class Q250136 {
    static int[][] Land;
    static boolean[][] visited;
    static int N,M;
    static int[] dR = {-1,1,0,0};
    static int[] dC = {0,0,-1,1};
    static int amount;
    public int solution(int[][] land) {
        int answer = 0;

        Land = land;
        N = land.length;
        M = land[0].length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<M;i++){ // 열
            visited = new boolean[N][M];
            int sum = 0;
            for(int j=0;j<N;j++){ // 행
                if(Land[j][i] == 1 && !visited[j][i]){
                    amount = 0;
                    visited[j][i] = true;
                    dfs(j,i);
                    sum += amount;
                    //System.out.println("i="+i+" j="+j+" sum="+sum);
                }
            }
            max = Math.max(max,sum);
        }

        return max;
    }

    static void dfs(int r, int c){
        amount++;

        for(int i=0;i<4;i++){
            int nextR = r+dR[i];
            int nextC = c+dC[i];

            if(nextR>=0 && nextR<N && nextC>=0 && nextC<M
                    && !visited[nextR][nextC] && Land[nextR][nextC]==1){
                visited[nextR][nextC] = true;
                dfs(nextR,nextC);
            }
        }
    }
}