package Baekjoon.algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2206_2 {
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static int N,M;
    static int[][] graph;
    static Queue<int[]> queue; // 행, 열, 거리, 현재 broken(0 or 1)상태
    static boolean[][][] visited; // 행, 열, broken(0 or 1)상태로 와밨는지
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        queue = new LinkedList<>();
        visited = new boolean[N][M][2];
        queue.add(new int[]{0, 0, 1, 0});

        System.out.print(bfs());

    }

    static int bfs(){
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            int dis = cur[2];
            int broken = cur[3];

            visited[curRow][curCol][broken] = true;
            // System.out.println("["+curRow+","+curCol+"]"+" dis: "+dis);

            if(curRow == N-1 && curCol == M-1){
                return dis;
            }

            for(int i=0;i<4;i++) {
                int nextRow = curRow + dRow[i];
                int nextCol = curCol + dCol[i];

                // 다음 칸이 0인 경우 = 부실 필요 없음
                if(nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M
                && graph[nextRow][nextCol] == 0
                && !visited[nextRow][nextCol][broken]) {
                    queue.add(new int[]{nextRow, nextCol, dis+1,broken});
                    visited[nextRow][nextCol][broken] = true;
                }

                // 다음 칸이 1이고, 아직 벽을 안 부숨 = 부셔보기
                if(nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M
                        && graph[nextRow][nextCol] == 1
                        && broken == 0
                        && !visited[nextRow][nextCol][1]) {
                    queue.add(new int[]{nextRow, nextCol, dis+1, 1});
                    visited[nextRow][nextCol][1] = true;
                }

            }
        }
        return -1;
    }
}
