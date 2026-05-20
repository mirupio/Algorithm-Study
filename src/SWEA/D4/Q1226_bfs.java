package SWEA.D4;

import java.io.*;
import java.util.*;

public class Q1226_bfs {
    static char[][] arr = new char[16][16];
    static int[] dRow = {-1,1,0,0};
    static int[] dCol = {0,0,-1,1};
    static Queue<int []> queue;
    static int enable;
    static boolean[][] visited;
    public static void main(String[] args)throws IOException {
        System.setIn(new FileInputStream("src/ssafy/input (16).txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;
        for(int test_case = 1; test_case <= T; test_case++)
        {
            enable=0;
            visited=new boolean[16][16];
            br.readLine();
            for(int i=0;i<16;i++) {
                arr[i] = br.readLine().toCharArray();
            }

            queue = new LinkedList<>();
            for(int i=0;i<16;i++) {
                for(int j=0;j<16;j++) {
                    if(arr[i][j]=='2') {
                        queue.add(new int[] {i,j});
                    }
                }
            }
            bfs();
            System.out.println("#"+test_case+" "+enable);
        }
    }

    static void bfs() {
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];

            if(arr[row][col] == '3') {
                enable=1;
                break;
            }

            for(int i=0;i<4;i++) {
                int nRow = row+dRow[i];
                int nCol = col+dCol[i];

                if(nRow>=0 && nRow<16
                        && nCol>=0 && nCol<16
                        && arr[nRow][nCol] != '1'
                        && !visited[nRow][nCol]) {
                    queue.add(new int[] {nRow,nCol});
                    visited[nRow][nCol]=true;
                }
            }
        }
    }
}
