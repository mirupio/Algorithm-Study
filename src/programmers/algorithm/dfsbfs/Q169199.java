package programmers.algorithm.dfsbfs;

import java.util.*;

class Q169199 {
    static int[] dRow = {-1,1,0,0};
    static int[] dCol = {0,0,-1,1};
    static int[][] distance;
    static int endRow, endCol;
    static Queue<int[]> queue;
    static int R,C;
    static char[][] arr;
    public int solution(String[] board) {

        R = board.length;
        C = board[0].length();

        // R -> G
        arr = new char[R][C];
        distance =  new int[R][C];
        queue = new LinkedList<>();

        for(int i=0;i<R;i++){
            Arrays.fill(distance[i],-1);

            for(int j=0;j<C;j++){
                arr[i][j] = board[i].charAt(j);
                if(arr[i][j]=='R'){
                    queue.offer(new int[]{i,j});
                    distance[i][j] = 0;
                }
            }
        }

        return bfs();
    }

    static int bfs(){
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int row = now[0];
            int col = now[1];

            if(arr[row][col] == 'G'){
                return distance[row][col];
            }

            for(int i=0;i<4;i++){
                int nextRow = row;
                int nextCol = col;

                while(true){
                    int movedRow = nextRow+dRow[i];
                    int movedCol = nextCol+dCol[i];

                    if(movedRow<0 || movedRow>=R
                            || movedCol<0 || movedCol>=C
                            || arr[movedRow][movedCol] == 'D'){
                        break;
                    }
                    nextRow = movedRow;
                    nextCol = movedCol;
                }

                if(distance[nextRow][nextCol] == -1){
                    distance[nextRow][nextCol] = distance[row][col]+1;
                    queue.offer(new int[]{nextRow,nextCol});
                }
            }
        }

        return -1;
    }
}