package programmers.algorithm.dfsbfs;

import java.util.*;

class Q121690 {
    static int[][] Hole;
    static int N,M;
    static int[] dRow = {1,-1,0,0};
    static int[] dCol = {0,0,-1,1};
    static boolean[][][] visited;
    static Queue<int[]> queue;
    public int solution(int n, int m, int[][] holes) {
        int answer = 0;
        N = n;
        M = m;
        Hole = new int[M+1][N+1];
        for(int[] hole: holes){
            Hole[hole[1]][hole[0]] = 1;
        }

        visited = new boolean[M+1][N+1][2];
        queue = new LinkedList<>();
        visited[1][1][0] = true;
        queue.offer(new int[]{1,1,0,0});
        // dfs(1,1,0,false);

        return bfs();
    }

    static int bfs(){
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int d= cur[2];
            int shoes = cur[3];

            if(r == M && c == N){
                return d;
            }

            for(int i=0;i<4;i++){
                int nextR = r+dRow[i];
                int nextC = c+dCol[i];

                if(nextR>=1 && nextR<=M && nextC>=1 && nextC<=N
                        && Hole[nextR][nextC]!=1 && !visited[nextR][nextC][shoes]){
                    visited[nextR][nextC][shoes] = true;

                    queue.offer(new int[]{nextR,nextC,d+1,shoes});
                }
                if(shoes == 0){
                    nextR = r+dRow[i]*2;
                    nextC = c+dCol[i]*2;

                    if(nextR>=1 && nextR<=M && nextC>=1 && nextC<=N
                            && Hole[nextR][nextC]!=1 && !visited[nextR][nextC][1]){
                        visited[nextR][nextC][1] = true;

                        queue.offer(new int[]{nextR,nextC,d+1,1});
                    }
                }
            }
        }
        return -1;
    }
    /*
    static void dfs(int r,int c,int d, boolean shoes){
        if(r == M && c == N){
            min = Math.min(min,d);
            return;
        }

        for(int i=0;i<4;i++){
            int nextR = r+dRow[i];
            int nextC = c+dCol[i];

            if(nextR>=1 && nextR<=M && nextC>=1 && nextC<=N
            && Hole[nextR][nextC]!=1 && !visited[nextR][nextC]){
                visited[nextR][nextC] = true;
                dfs(nextR,nextC,d+1,shoes);
                visited[nextR][nextC] = false;
            }
            if(!shoes){
                nextR = r+dRow[i]*2;
                nextC = c+dCol[i]*2;

                if(nextR>=1 && nextR<=M && nextC>=1 && nextC<=N
                && Hole[nextR][nextC]!=1 && !visited[nextR][nextC]){
                    visited[nextR][nextC] = true;
                    dfs(nextR,nextC,d+1,true);
                    visited[nextR][nextC] = false;
                }
            }

        }
    }
    */
}