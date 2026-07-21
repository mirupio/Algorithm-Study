package programmers.algorithm.dfsbfs;

import java.util.*;

class Q159993 {
    static int[] dRow = {-1,1,0,0};
    static int[] dCol = {0,0,-1,1};
    static Queue<int[]> queue;
    static int[][] dis;
    static int R,C;
    static char[][] arr;
    static int answer;
    static int leverRow,leverCol;
    public int solution(String[] maps) {

        answer = -1;
        R = maps.length;
        C = maps[0].length();

        int startRow=0;
        int startCol=0;
        int leverRow = 0;
        int leverCol = 0;
        int exitRow = 0;
        int exitCol = 0;
        arr = new char[R][C];
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                arr[i][j] = maps[i].charAt(j);
                if(arr[i][j] == 'S'){
                    startRow = i;
                    startCol = j;
                }
                else if(arr[i][j] == 'L'){
                    leverRow = i;
                    leverCol = j;
                }
                else if(arr[i][j] == 'E'){
                    exitRow = i;
                    exitCol = j;
                }
            }
        }

        // 시작 지점(S) -> 레버(L)
        queue = new ArrayDeque<>();
        dis = new int[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(dis[i], -1);
        }

        queue.offer(new int[]{startRow,startCol});
        dis[startRow][startCol] = 0;
        int StoL = bfs(startRow,startCol,leverRow,leverCol);

        // 레버(L) -> 출구(E)
        queue = new ArrayDeque<>();
        dis = new int[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(dis[i], -1);
        }

        queue.offer(new int[]{leverRow,leverCol});
        dis[leverRow][leverCol] = 0;
        int LtoE = bfs(leverRow,leverCol,exitRow,exitCol);

        if (StoL == -1 || LtoE == -1) {
            return -1;
        }
        return StoL + LtoE;
    }

    static int bfs(int sR, int sC, int tR, int tC ){
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int row = now[0];
            int col = now[1];

            if(row == tR && col == tC){
                return dis[row][col];
            }

            for(int i=0;i<4;i++){
                int nextRow = row+dRow[i];
                int nextCol = col+dCol[i];

                if(nextRow>=0 && nextRow<R
                        && nextCol>=0 && nextCol<C
                        && arr[nextRow][nextCol] != 'X'
                        && dis[nextRow][nextCol] == -1){
                    dis[nextRow][nextCol] = dis[row][col]+1;
                    queue.offer(new int[]{nextRow,nextCol});
                }
            }
        }
        return -1;
    }
}