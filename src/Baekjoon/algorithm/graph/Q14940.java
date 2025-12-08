package Baekjoon.algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q14940 {
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static int n,m;
    static int[][] graph;
    static int[][] distance;
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        distance = new int[n][m];
        // 디폴트를 -1로
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                distance[i][j] = -1;
            }
        }
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(tokens[j]);
                if (graph[i][j] == 2) {
                    queue.add(new int[] {i, j, 0});
                    visited[i][j] = true;
                }
                if(graph[i][j] == 0) {
                    distance[i][j] = 0;
                }
            }
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void bfs() {
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            int dis = cur[2];

            distance[row][col] = dis;

            for (int i = 0; i < 4; i++) {
                int nextRow = row + dRow[i];
                int nextCol = col + dCol[i];

                if(nextRow>=0 && nextRow<n && nextCol>=0 && nextCol<m
                && graph[nextRow][nextCol] == 1
                && !visited[nextRow][nextCol]) {
                    queue.add(new int[]{nextRow, nextCol,dis+1});
                    visited[nextRow][nextCol] = true;
                }
            }
        }
    }
}
