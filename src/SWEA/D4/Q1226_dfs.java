package SWEA.D4;

import java.io.*;

public class Q1226_dfs {
    static char[][] arr = new char[16][16];
    static int[] dRow = {-1,1,0,0};
    static int[] dCol = {0,0,-1,1};
    static boolean[][] visited;
    static int enable;
    public static void main(String[] args)throws IOException {
        System.setIn(new FileInputStream("src/ssafy/input (16).txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;
        for(int test_case = 1; test_case <= T; test_case++)
        {
            visited = new boolean[16][16];
            br.readLine();
            enable = 0;
            for(int i=0;i<16;i++) {
                arr[i] = br.readLine().toCharArray();
            }

            for(int i=0;i<16;i++) {
                for(int j=0;j<16;j++) {
                    if(arr[i][j] == '2') {
                        dfs(i,j);
                    }
                }
            }
            System.out.println("#"+test_case+" "+enable);
        }
    }

    static void dfs(int row, int col) {
        visited[row][col] = true;
        // System.out.println("row="+row+" col="+col);
        if(arr[row][col]=='3'){
            // System.out.println("finish! "+"row="+row+" col="+col);
            enable = 1;
            return;
        }

        for(int i=0;i<4;i++) {
            int nRow = row+dRow[i];
            int nCol = col+dCol[i];

            if(nRow>=0 && nRow<16 && nCol>=0 && nCol<16
                    && arr[nRow][nCol]!='1'
                    && !visited[nRow][nCol]) {
                dfs(nRow,nCol);
            }
        }

    }
}
