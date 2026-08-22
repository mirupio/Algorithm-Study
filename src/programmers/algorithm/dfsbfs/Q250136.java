package programmers.algorithm.dfsbfs;

import java.util.*;

class Q250136 {
    static int[][] Land;
    static boolean[][] visited;
    static int N,M;
    static int[] dR = {-1,1,0,0};
    static int[] dC = {0,0,-1,1};
    static int amount;
    static Set<Integer> set;
    static Queue<int[]> queue;
    public int solution(int[][] land) {
        int answer = 0;

        Land = land;
        N = land.length;
        M = land[0].length;
        visited = new boolean[N][M];
        int[] sum = new int[M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(Land[i][j] == 1 && !visited[i][j]){
                    amount = 0;
                    set = new HashSet<>();
                    visited[i][j] = true;
                    queue = new LinkedList<>();
                    queue.offer(new int[]{i,j});
                    bfs();
                    // dfs(i,j);
                    // System.out.println("i="+i+" j="+j+" amount="+amount);
                    for(int column:set){
                        sum[column] += amount;
                        //System.out.println("column= "+column+" sum="+sum[column]);
                    }

                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int c: sum){
            max = Math.max(max,c);
        }
        return max;
    }

    static void bfs(){
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            amount++;
            set.add(c);

            for(int i=0;i<4;i++){
                int nextR = r+dR[i];
                int nextC = c+dC[i];

                if(nextR>=0 && nextR<N && nextC>=0 && nextC<M
                        && !visited[nextR][nextC] && Land[nextR][nextC]==1){
                    visited[nextR][nextC] = true;
                    queue.offer(new int[]{nextR,nextC});
                }
            }

        }
    }

    static void dfs(int r, int c){
        amount++;
        set.add(c);

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