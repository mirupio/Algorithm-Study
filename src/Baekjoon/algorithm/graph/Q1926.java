package Baekjoon.algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q1926 {
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, 1, -1};
    static int n,m;
    static int count;
    static int total;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로

        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Integer> countArr = new ArrayList<>();
        boolean[][] visited = new boolean[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(!visited[i][j] && graph[i][j] == 1) {
                    count=0;
                    dfs(i,j,visited,graph);
                    countArr.add(count);

                    total++;
                }
            }
        }

        System.out.println(total);
        Collections.sort(countArr);
        if (countArr.isEmpty()) {
            System.out.print(0);
        }
        else{
            System.out.print(countArr.get(countArr.size()-1));
        }
    }

    static void dfs(int row, int col, boolean[][] visited, int[][] graph) {
        visited[row][col] = true;
        count++;

        for(int i=0;i<4;i++) {
            int nextRow = row + dRow[i];
            int nextCol = col + dCol[i];

            if((nextRow>=0 && nextRow<n) && (nextCol>=0 && nextCol<m)
                    && !visited[nextRow][nextCol]
                    && graph[nextRow][nextCol] == 1) {
                dfs(nextRow, nextCol, visited, graph);
            }
        }
    }
}
