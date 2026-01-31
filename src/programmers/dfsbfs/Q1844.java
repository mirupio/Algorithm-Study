package programmers.dfsbfs;

import java.util.*;

class Q1844 {
    static int[] dRow = {-1,1,0,0};
    static int[] dCol = {0,0,-1,1};
    static int n,m;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;

        boolean[][] visited = new boolean[n][m];
        int answer = bfs(visited,maps);
        return answer;
    }

    static int bfs(boolean[][] visited, int[][] map){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            int dis = cur[2];

            if(row == n-1 && col == m-1){
                return dis;
            }

            for(int i=0;i<4;i++){
                int nextRow = row+dRow[i];
                int nextCol = col+dCol[i];
                int nextDis = dis+1;

                if(nextRow>=0 && nextRow<n && nextCol>=0 && nextCol<m
                        && !visited[nextRow][nextCol]
                        && map[nextRow][nextCol] == 1){
                    visited[nextRow][nextCol] = true;
                    queue.add(new int[]{nextRow,nextCol,nextDis});
                }
            }
        }
        return -1;
    }
}