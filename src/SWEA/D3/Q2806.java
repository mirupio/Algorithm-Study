package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// N-Queen
public class Q2806 {
    static int N;
    static int[][] map;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++) {
            System.out.print("#"+t+" ");

            N = Integer.parseInt(br.readLine());
            count = 0;

            // 1행 1열 ~ 1행 N열 시도
            for(int col = 1; col<=N; col++) {
                map = new int[N+1][N+1];
                map[1][col] = 1;
                dfs(map, 2); // 2행부터 dfs 탐색
            }

            System.out.println(count);
        }
    }

    static void dfs(int[][] map, int row){
        if (row == N + 1) { // 종료 조건
            count++;
            return;
        }

        // 현재 행에 대해 1~N열 탐색
        for (int col = 1; col <= N; col++) {
            if (condition(map, row, col)) { // 해당 위치에 퀸을 둘 수 있다면
                map[row][col] = 1; // 퀸을 둠
                dfs(map, row + 1); // 다음 행으로 dfs 호출
                map[row][col] = 0; // dfs 끝나면, 다시 0으로 되돌림(backtracking)
            }
        }
    }

    // 퀸 둘 수 있는지 검사 = 이미 놓인 퀸들과 충돌이 있는지 검사
    static boolean condition(int[][] map, int row, int col) {
        // 세로 방향 체크
        for (int r = 1; r < row; r++) {
            if (map[r][col] == 1) {
                return false;
            }
        }

        // 왼쪽 위 대각선 (\)
        // -1행 -1열 -> -2행 -2열 -> ... -> map을 벗어나지 않을 때까지
        int r = row - 1;
        int c = col - 1;
        while (r > 0 && c > 0) {
            if(map[r][c] == 1) {
                return false;
            }
            r--;
            c--;
        }

        // 오른쪽 위 대각선(/)
        // -1행 +1열 -> -2행 +2열 -> ... -> map을 벗어나지 않을 때까지
        r = row - 1;
        c = col + 1;
        while (r > 0 && c <= N) {
            if(map[r][c] == 1) {
                return false;
            }
            r--;
            c++;
        }

        // 전부 통과할 경우
        return true;
    }
}
