package programmers.algorithm.dfsbfs;

import java.util.*;
class Q87694 {
    static final int MAX = 102;
    static int[][] board = new int[MAX+1][MAX+1];
    static boolean[][] visited = new boolean[MAX][MAX];
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 모든 직사각형 채우기
        for(int[] r:rectangle){
            int x1 = r[0]*2;
            int y1 = r[1]*2;
            int x2 = r[2]*2;
            int y2 = r[3]*2;

            for(int y=y1; y<=y2; y++){
                for(int x=x1; x<=x2; x++){
                    board[y][x] = 1;
                }
            }
        }

        // 내부 지우기
        for(int[] r:rectangle){
            int x1 = r[0]*2;
            int y1 = r[1]*2;
            int x2 = r[2]*2;
            int y2 = r[3]*2;

            for(int y=y1+1; y<=y2-1; y++){
                for(int x=x1+1; x<=x2-1; x++){
                    board[y][x] = 0;
                }
            }
        }

        return bfs(characterY*2, characterX*2,itemY*2,itemX*2)/2;
    }

    static int bfs(int sy, int sx, int ty, int tx){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sy, sx});
        visited[sy][sx] = true;
        int[][] dis = new int[MAX][MAX];

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];

            if(y == ty && x == tx){
                return dis[y][x];
            }

            for(int i=0;i<4;i++){
                int ny = y+dr[i];
                int nx = x+dc[i];

                if(ny>=0 && nx>=0 && ny<MAX && nx<MAX
                        && !visited[ny][nx]
                        && board[ny][nx] == 1){
                    visited[ny][nx] = true;
                    dis[ny][nx] = dis[y][x] + 1;
                    queue.add(new int[]{ny,nx});
                }
            }
        }

        return 0;
    }
}
