package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1954 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        // 오, 아, 왼, 위
        int[] d_row = {0,1,0,-1};
        int[] d_col = {1,0,-1,0};

        for(int t=1;t<=T;t++){
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][N];

            int row=0,col=0;
            int d=0;

            for(int num=1; num <= N*N; num++){
                arr[row][col] = num;

                // 다음 위치
                int n_row = row+d_row[d];
                int n_col = col+d_col[d];

                // 경계 벗어나거나 이미 숫자 있으면 -> 방향 전환
                if(n_row<0 || n_row>=N || n_col<0 || n_col>=N || arr[n_row][n_col]!=0) {
                    d = (d + 1) % 4; // 방향 바꾸기 ⭐

                    n_row = row + d_row[d];
                    n_col = col + d_col[d];
                }

                row = n_row;
                col = n_col;
            }

            System.out.println("#" + t);
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}
