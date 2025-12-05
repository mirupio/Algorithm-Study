package SWEA.D3;

import java.io.*;
import java.util.*;

public class Q4615 {
    static int[] dRow = {-1,1,0,0};
    static int[] dCol = {0,0,1,-1};
    static int[][] arr;
    static int N;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            arr = new int[N][N];
            arr[N/2-1][N/2-1] = 2;
            arr[N/2][N/2-1] = 1;
            arr[N/2-1][N/2] = 1;
            arr[N/2][N/2] = 2;

            for(int i=0;i<M;i++) {
                st = new StringTokenizer(br.readLine());
                int col = Integer.parseInt(st.nextToken())-1;
                int row = Integer.parseInt(st.nextToken())-1;
                int color = Integer.parseInt(st.nextToken());

                change(color,row,col);
            }

            int black=0;
            int white=0;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(arr[i][j] == 1) {
                        black++;
                    }
                    if(arr[i][j] == 2) {
                        white++;
                    }
                }
            }

            System.out.print("#"+t+" "+black+" "+white);

        }

    }
    static void change(int color,int row, int col ) {
        for(int d=0;d<4;d++) {
            int next2Row = row + dRow[d]*2;
            int next2Col = col + dCol[d]*2;
            int nextRow = row + dRow[d];
            int nextCol = col + dCol[d];

            if(next2Row>=0 && next2Row<N && next2Col>=0 && next2Row<N) {
                if(arr[row][col] == arr[next2Row][next2Col]) {
                    arr[nextRow][nextCol] = color;
                }
            }
        }

    }

}
