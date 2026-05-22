package SWEA.D4;

import java.io.*;

public class Q1868 {
    static int[] dRow = {-1,-1,-1,0,1,1,1,0};
    static int[] dCol = {-1,0,1,1,1,0,-1,-1};
    static int N;
    static char[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = Integer.parseInt(br.readLine());
            arr = new char[N][N];
            for(int i=0;i<N;i++) {
                arr[i] = br.readLine().toCharArray();
            }

            int tot = 0;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    // 1. 주변 지뢰가 0인 '.'만 먼저 클릭
                    if (arr[i][j] == '.' && countBomb(i, j) == 0) {
                        tot++;
                        dfs(i, j);
                    }
                }
            }

            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    // 2. 남은 '.'은 각각 한 번씩 클릭
                    if (arr[i][j] == '.') {
                        tot++;
                    }
                }
            }

            System.out.println("#"+test_case+" "+tot);
        }
    }

    static void dfs(int row, int col) {
        arr[row][col] = '-';
        //System.out.println("row="+row+"col="+col);
        for(int i=0;i<8;i++) {
            int nextRow = row+dRow[i];
            int nextCol = col+dCol[i];

            if(nextRow>=0 && nextRow<N && nextCol>=0 && nextCol<N
                    && arr[nextRow][nextCol] == '.') {
                arr[nextRow][nextCol] = '-';
                if(countBomb(nextRow,nextCol)==0) {
                    dfs(nextRow,nextCol);
                }

            }
        }
    }

    static int countBomb(int row, int col) {
        int count = 0;
        for(int i=0;i<8;i++) {
            int nextRow = row+dRow[i];
            int nextCol = col+dCol[i];

            if(nextRow>=0 && nextRow<N && nextCol>=0 && nextCol<N
                    && arr[nextRow][nextCol] == '*') {
                count++;
            }
        }
        return count;
    }
}

