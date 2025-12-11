package Baekjoon.algorithm.graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2468 {
    static int[] dCol = {-1, 1, 0, 0};
    static int[] dRow = {0, 0, -1, 1};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                graph[i][j] = a;
                if (a > max) {
                    max = a;
                }
            }
        }
        // System.out.println("max: " + max);

        int[] part = new int[max+1];
        for (int d = 0; d <= max; d++) {
            // System.out.println("depth: "+d);
            int count = 0;
            boolean[][] visited = new boolean[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if (!visited[i][j] && graph[i][j] > d) {
                        dfs(d, i, j, visited, graph);
                        // System.out.println();
                        count++;
                    }
                }
            }
            part[d] = count;
            // System.out.println("영역개수 "+ part[d]);
        }

        /*for(int i = 0; i <= max; i++) {
            System.out.print(part[i]+" ");
        }
        System.out.println();*/

        int maxCount = 0;
        for(int i = 0; i < max; i++) {
            if(part[i]>maxCount) {
                maxCount = part[i];
            }
        }

        System.out.println(maxCount);

    }

    static void dfs(int depth,int row,int col, boolean[][] visited, int[][] graph) {
        visited[row][col] = true;
        // System.out.print("["+row+","+col+"]"+" ");

        for(int i=0; i<4; i++) {
            int nextRow = row + dRow[i];
            int nextCol = col + dCol[i];

            if((nextRow>=0 && nextRow<N && nextCol>=0 && nextCol<N)
            && (graph[nextRow][nextCol]>depth)
            && (!visited[nextRow][nextCol])) {
                dfs(depth,nextRow, nextCol, visited, graph);
            }
        }



    }
}
