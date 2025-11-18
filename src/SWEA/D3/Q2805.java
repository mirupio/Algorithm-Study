package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import java.lang.*;

import static java.lang.Math.*;

public class Q2805 {
    static int[] drow = {-1, 1, 0, 0};
    static int[] dcol = {0, 0, 1, -1};
    static int N;
    static int[][] visited;
    static int sum;
    static int[][] value;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            value = new int[N][N];
            visited = new int[N][N];
            for(int n=0;n<N;n++) {
                String s = br.readLine();
                for (int i = 0; i< s.length(); i++) {
                    value[n][i] = s.charAt(i) - '0';
                }
            }

            sum = 0;
            bfs(N/2,N/2);

            System.out.println("#"+t+" "+sum);
        }


    }
    static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = 1;
        sum += value[row][col];

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            int nextRow,nextCol;
            for (int i = 0; i < 4; i++) {
                nextRow = cur[0]+drow[i];
                nextCol = cur[1]+dcol[i];

                // 경계 안넘어가고, 방문 안했고, 거리 오버 안됐으면
                if((nextRow>=0 && nextRow<N && nextCol>=0 && nextCol<N)
                        && (visited[nextRow][nextCol]==0)
                        &&(abs(nextRow-N/2)+abs(nextCol-N/2))<=N/2){
                    visited[nextRow][nextCol] = 1;
                    sum += value[nextRow][nextCol];
                    queue.add(new int[]{nextRow, nextCol});
                }
            }

        }
    }
}
