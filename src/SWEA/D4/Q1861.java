package SWEA.D4;

import java.io.*;
import java.util.*;

public class Q1861 {
    static int[] dRow = {-1,1,0,0};
    static int[] dCol = {0,0,-1,1};
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int max;
    static int num;
    static int count;
    public static void main(String[] args)throws IOException {
        //System.setIn(new FileInputStream("src/ssafy/input (17).txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = Integer.parseInt(br.readLine());

            arr = new int[N][N];
            for(int i=0;i<N;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            max = Integer.MIN_VALUE;
            int num = Integer.MAX_VALUE;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    count = 0;
                    dfs(i,j);
                    if(max<=count) {
                        if(max==count && num>arr[i][j]) {
                            num = arr[i][j];
                            max = count;
                        }
                        else if(max<count) {
                            num = arr[i][j];
                            max = count;
                        }
                    }
                }
            }
            System.out.println("#"+test_case+" "+num+" "+max);
        }
    }
    static private void dfs(int row, int col) {
        // System.out.println("row="+row+" col="+col);
        count++;

        for(int i=0;i<4;i++) {
            int nRow = row+dRow[i];
            int nCol = col+dCol[i];

            if(nRow>=0 && nRow<N
                    && nCol>=0 && nCol<N
                    &&(arr[nRow][nCol]==(arr[row][col]+1))) {
                dfs(nRow,nCol);
            }
        }
    }
}
