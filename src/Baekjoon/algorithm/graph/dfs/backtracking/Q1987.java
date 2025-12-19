package Baekjoon.algorithm.graph.dfs.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1987 {
    static int R, C;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static char[][] arr;
    static boolean[][] visited;
    static boolean[] alpha_visited;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                arr[i][j] = str.toCharArray()[j];
            }
        }

        visited = new boolean[R][C];
        alpha_visited = new boolean[26];

        max = Integer.MIN_VALUE;
        visited[0][0] = true;
        alpha_visited[arr[0][0] -'A'] = true;
        dfs(0, 0,1);
        System.out.println(max);
    }

    static void dfs(int row, int col, int count) {
        // System.out.println("row = " + row+", col = " + col+", count = " + count);
        max = Math.max(max, count);

        for (int i = 0; i < 4; i++) {
            int nextRow = row + dRow[i];
            int nextCol = col + dCol[i];
            int nextCount = count + 1;

            if (nextRow >= 0 && nextRow < R && nextCol >= 0 && nextCol < C
            && !visited[nextRow][nextCol]
            && !alpha_visited[arr[nextRow][nextCol] -'A']) {
                visited[nextRow][nextCol] = true;
                alpha_visited[arr[nextRow][nextCol] -'A'] = true;
                dfs(nextRow, nextCol, nextCount);
                visited[nextRow][nextCol] = false;
                alpha_visited[arr[nextRow][nextCol] -'A'] = false;
            }

        }
    }
}
