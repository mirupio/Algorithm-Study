package Baekjoon.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9663 {
    static int N;
    static int[][] arr;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        count = 0;
        for (int col = 0; col < N; col++) {
            arr = new int[N][N];
            arr[0][col] = 1;
            dfs(1);
        }

        System.out.println(count);
    }

    static void dfs(int row) {
        if (row == N) {
            count++;
            return;
        }
        for (int col = 0; col < N; col++) {
            if (available(row, col)) {
                // 방문
                arr[row][col] = 1;
                dfs(row + 1);
                arr[row][col] = 0;
            }
        }
    }

    static boolean available(int row, int col) {
        // 세로 검사
        for (int r = 0; r < row; r++) {
            if(arr[r][col] == 1){
                return false;
            }
        }

        // 왼쪽 대각선 검사 (\)
        int r = row-1;
        int c = col-1;
        while (r >= 0 && c >= 0) {
            if(arr[r][c] == 1){
                return false;
            }
            r--;
            c--;
        }

        // 오른쪽 대각선 검사 (/)
        r = row-1;
        c = col+1;
        while (r >= 0 && c < N) {
            if(arr[r][c] == 1){
                return false;
            }
            r--;
            c++;
        }

        return true;
    }
}
