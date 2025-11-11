package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1961 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];

            for(int i=0;i<N;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            String[][] returnArr = new String[N][N];
            // 초기화
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    returnArr[i][j] = "";
                }
            }
            // 90도
            for(int i=0;i<N;i++) {
                for(int j=N-1;j>=0;j--) {
                    returnArr[i][0] += arr[j][i];
                }
            }

            // 180도
            for(int i=0;i<N;i++) {
                for(int j=N-1;j>=0;j--) {
                    returnArr[i][1] += arr[N-i-1][j];
                }
            }

            // 270도
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    returnArr[i][2] += arr[j][N-i-1];
                }
            }

            System.out.println("#"+t);
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    System.out.print(returnArr[i][j] + " ");
                }
                System.out.println();
            }

        }
    }
}
