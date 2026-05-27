package programmers.algorithm.dfsbfs;

class Q150365_2 {
    static int[][] arr;
    // 상, 하, 좌, 우
    static int[] dRow = {1,0,0,-1};
    static int[] dCol = {0,-1,1,0};
    static char[] dDir = {'d','l','r','u'};
    static int N,M,R,C,K;
    static String answer = null;
    public String solution(int n, int m, int x, int y, int r, int c, int k)     {

        arr = new int[n][m];
        N = n;
        M = m;
        R = r;
        C = c;
        K = k;

        int startDis = Math.abs((x-1)-(R-1))+Math.abs((y-1)-(C-1));

        // 애초에 불가능
        if(startDis > K || (k - startDis) % 2 == 1){
            return "impossible";
        }

        dfs(0,x-1,y-1,"");

        return answer;
    }

    static void dfs(int depth, int row, int col, String dir){
        if(answer != null) {
            return;
        }

        int dis = Math.abs(row-(R-1)) + Math.abs(col-(C-1));
        int remain = K - depth;
        if(dis > remain || (remain-dis)%2 == 1){
            return;
        }

        if(depth == K){
            if(row == R-1 && col == C-1){
                answer = dir;
            }
            return;
        }

        for(int i=0;i<4;i++){
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];
            String nDir = dir + dDir[i];
            if(nRow>=0 && nRow<N && nCol>=0 && nCol<M){
                dfs(depth+1,nRow,nCol,nDir);
            }
        }
    }
}