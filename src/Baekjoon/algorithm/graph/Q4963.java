package Baekjoon.algorithm.graph;

import java.io.IOException;
import java.io.*;
import java.util.StringTokenizer;

public class Q4963 {
    static int[] dRow = {-1, 1, 0, 0, 1, 1, -1, -1};
    static int[] dCol = {0, 0, -1, 1, 1, -1, 1, -1};
    static int w,h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            int[][] arr = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            boolean[][] visited = new boolean[h][w];
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(!visited[i][j] && arr[i][j] == 1) {
                        visited[i][j] = true;
                        // System.out.println("i = " + i+", j = "+j);
                        count++;
                        dfs(i, j, arr, visited);
                    }
                }
            }

            System.out.println(count);
        }
    }

    static void dfs(int startRow,int startCol, int[][] arr, boolean[][] visited) {
        // System.out.println("dfs!");
        visited[startRow][startCol] = true;

        for (int i = 0; i < 8; i++) {
            int nextRow = startRow + dRow[i];
            int nextCol = startCol + dCol[i];

            if(nextRow >= 0 && nextRow < h && nextCol >= 0 && nextCol < w
                    && !visited[nextRow][nextCol]
                    && arr[nextRow][nextCol] == 1) {
                dfs(nextRow, nextCol, arr, visited);
            }
        }
    }
}
