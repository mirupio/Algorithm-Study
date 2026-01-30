package Baekjoon.algorithm.graph.dfs;

import java.io.*;
import java.util.*;

public class Q21736 {
    static int[] dRow = {-1,1,0,0};
    static int[] dCol = {0,0,1,-1};
    static boolean[][] visited;
    static char[][] arr;
    static int count;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            arr[i] = s.toCharArray();
        }

        visited = new boolean[N][M];
        count = 0;
        outer:
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if (arr[i][j] == 'I') {
                    dfs(visited,i,j);
                    break outer;
                }
            }
        }

        if(count > 0){
            System.out.print(count);
        }
        else{
            System.out.print("TT");
        }

    }

    static void dfs(boolean[][] visited, int row, int col) {
        visited[row][col] = true;
        // System.out.println("["+row+","+col+"]");
        if(arr[row][col] == 'P'){
            // System.out.println("친구 만남 ");
            // System.out.println("["+row+","+col+"]");
            count++;
        }

        for (int i = 0; i < 4; i++) {
            int nextRow = row + dRow[i];
            int nextCol = col + dCol[i];

            if(nextRow>=0 && nextRow<N && nextCol>=0 && nextCol<M
                && !visited[nextRow][nextCol]
                && (arr[nextRow][nextCol] == 'P' || arr[nextRow][nextCol] == 'O' )){
                dfs(visited, nextRow,nextCol);
            }
        }
    }
}
