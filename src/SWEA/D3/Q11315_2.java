package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11315_2 {
    static int[] dRow = {0,1,1,1};
    static int[] dCol = {1,0,1,-1};
    static int N;
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine().trim());

            arr = new char[N][N];
            for(int i = 0; i < N; i++) {
                arr[i] = br.readLine().toCharArray();
            }

            boolean exist = false;

            for(int row = 0; row < N &&!exist; row++) {
                for(int col = 0; col < N &&!exist; col++) {
                    if(arr[row][col] == 'o') {
                        for (int d = 0; d < 4; d++) {
                            if(check(row, col, d)) {
                                exist = true;
                                break;
                            }
                        }
                    }
                }
            }

            System.out.println("#" + t + " " + (exist? "YES" : "NO"));
        }
    }

    static boolean check(int row, int col, int d) {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            int nextRow = row + dRow[d]*i;
            int nextCol = col + dCol[d]*i;

            if(nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) {
                return false;
            }
            if(arr[nextRow][nextCol] == '.') {
                return false;
            }
            count++;
        }
        return count==5;
    }

}