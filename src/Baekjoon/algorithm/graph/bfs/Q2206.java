package Baekjoon.algorithm.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 틀린 답안 -> 시간 초과 (1000000번 BFS 실행할 수도...)
public class Q2206 {
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static int N,M;
    static int[][] graph;
    static Queue<int[]> queue;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        ArrayList<int[]> list_1 = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                graph[i][j] = line.charAt(j) - '0';

                if (graph[i][j] == 1) {
                    list_1.add(new int[]{i, j});
                }
            }
        }

        int[][] graph_copy = new int[N][M];
        for(int i = 0; i < N; i++) {
            graph_copy[i] = graph[i].clone();
        }

        int min = Integer.MAX_VALUE;
        // 부술 벽 1개 고르기
        for(int i=0;i<list_1.size();i++) {
            // 초기화
            for(int n = 0; n < N; n++) {
                graph[n] = graph_copy[n].clone();
            }
            graph[list_1.get(i)[0]][list_1.get(i)[1]] = 0;

            /*System.out.println("시도"+i);
            for (int n = 0; n < N; n++) {
                for(int m = 0; m < M; m++) {
                    System.out.print(graph[n][m] + " ");
                }
                System.out.println();
            }*/

            queue = new LinkedList<>();
            visited = new boolean[N][M];
            queue.add(new int[]{0, 0, 1}); // 행, 열, 거리

            int result = bfs();
            min = Math.min(min,result);
        }

        if(min == Integer.MAX_VALUE) {
            System.out.print(-1);
        }
        else{
            System.out.print(min);
        }
    }

    static int bfs(){
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            int dis = cur[2];
            visited[curRow][curCol] = true;
            // System.out.println("["+curRow+","+curCol+"]"+" dis: "+dis);

            if(curRow == N-1 && curCol == M-1){
                return dis;
            }

            for(int i=0;i<4;i++) {
                int nextRow = curRow + dRow[i];
                int nextCol = curCol + dCol[i];

                if(nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M
                && graph[nextRow][nextCol] == 0
                && !visited[nextRow][nextCol]) {
                    queue.add(new int[]{nextRow, nextCol, dis+1});
                    visited[nextRow][nextCol] = true;
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
