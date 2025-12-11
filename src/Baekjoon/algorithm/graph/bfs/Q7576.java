package Baekjoon.algorithm.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7576 {
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, 1, -1};
    static int M,N;
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로

        int[][] graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

                // 모든 익은 토마토 큐에 미리 삽입
                if (graph[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        bfs(graph);

        // 안 익은 게 남아 있는지 확인 & 최소날짜 반환
        int result = Integer.MIN_VALUE;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if (graph[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, graph[i][j]); // 가장 늦게 익은 토마토가 익은 날짜
            }
        }

        System.out.println(result - 1); // 모두 익어 있었으면 = 가장 늦게 익은 토마토가 익은 날짜가 1 -> 0 반환
    }

    static void bfs(int[][] graph) {
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];

            for(int i=0;i<4;i++) {
                int nextRow = curRow + dRow[i];
                int nextCol = curCol + dCol[i];

                if(nextRow>=0 && nextRow<N && nextCol>=0 && nextCol<M
                    && graph[nextRow][nextCol] == 0) {
                    graph[nextRow][nextCol] = graph[curRow][curCol]+1;
                    queue.add(new int[]{nextRow,nextCol});
                }
            }
        }


    }
}
