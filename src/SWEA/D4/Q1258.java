package SWEA.D4;

import java.io.*;
import java.util.*;

public class Q1258 {
    static int[] dRow = {-1,1,0,0};
    static int[] dCol = {0,0,-1,1};
    static int n=0;
    static int[][] arr;
    static int maxRow = Integer.MIN_VALUE;
    static int maxCol = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        // System.setIn(new FileInputStream("src/ssafy/input (15).txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            for(int i=0;i<n;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean[][] visited = new boolean[n][n];

            List<int[]> list = new ArrayList<>();
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(arr[i][j]!=0 && !visited[i][j]) {
                        maxRow = i;
                        maxCol = j;
                        dfs(i,j,visited);

                        int rowSize = maxRow-i+1;
                        int colSize = maxCol-j+1;

                        list.add(new int[] {rowSize,colSize});
                    }
                }
            }

            Collections.sort(list,(a,b) -> {
                if(a[0]*a[1]==b[0]*b[1]) {
                    return a[0]-b[0];
                }

                return a[0]*a[1]-b[0]*b[1];
            });

            System.out.print("#"+test_case+" "+list.size()+" ");
            for(int[] arrs:list) {
                System.out.print(arrs[0]+" "+arrs[1]+" ");
            }
            System.out.println();
        }
    }

    static void dfs(int row,int col,boolean[][] visited) {

        visited[row][col] = true;
        maxRow = Math.max(maxRow, row);
        maxCol = Math.max(maxCol, col);

        for(int i=0;i<4;i++) {
            int nextRow = row+dRow[i];
            int nextCol = col+dCol[i];

            if(nextRow>=0 && nextRow<n
                    && nextCol>=0 && nextCol<n
                    && arr[nextRow][nextCol] !=0
                    && !visited[nextRow][nextCol]) {

                dfs(nextRow,nextCol,visited);
            }

        }
    }
}
