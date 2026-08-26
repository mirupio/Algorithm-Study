package programmers.algorithm.dfsbfs;

class Q250134 {
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};

    static boolean[][] Rvisited, Bvisited;
    static int[][] Maze;

    static int N, M;
    static int min;

    static int RstartR, RstartC, BstartR, BstartC;
    static int RendR, RendC, BendR, BendC;

    public int solution(int[][] maze) {
        N = maze.length;
        M = maze[0].length;

        Maze = maze;

        Rvisited = new boolean[N][M];
        Bvisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maze[i][j] == 1) {
                    RstartR = i;
                    RstartC = j;
                }
                else if (maze[i][j] == 2) {
                    BstartR = i;
                    BstartC = j;
                }
                else if (maze[i][j] == 3) {
                    RendR = i;
                    RendC = j;
                }
                else if (maze[i][j] == 4) {
                    BendR = i;
                    BendC = j;
                }
            }
        }

        Rvisited[RstartR][RstartC] = true;
        Bvisited[BstartR][BstartC] = true;

        min = Integer.MAX_VALUE;

        dfs(RstartR, RstartC, BstartR, BstartC, 0);

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    static void dfs(int Rrow, int Rcol, int Brow, int Bcol, int turn) {

        if (turn >= min) {
            return;
        }

        boolean Rfinished = Rrow == RendR && Rcol == RendC;
        boolean Bfinished = Brow == BendR && Bcol == BendC;

        // 둘 다 도착
        if (Rfinished && Bfinished) {
            min = Math.min(min, turn);
            return;
        }

        // 빨강만 도착 -> 파랑만 이동
        if (Rfinished) {
            for (int j = 0; j < 4; j++) {
                int BnextR = Brow + dRow[j];
                int BnextC = Bcol + dCol[j];

                if (!canMove(BnextR, BnextC, Bvisited)) {
                    continue;
                }

                // 빨강이 있는 칸으로 이동 불가
                if (BnextR == Rrow && BnextC == Rcol) {
                    continue;
                }

                Bvisited[BnextR][BnextC] = true;

                dfs(Rrow, Rcol, BnextR, BnextC, turn + 1);

                Bvisited[BnextR][BnextC] = false;
            }

            return;
        }

        // 파랑만 도착 -> 빨강만 이동
        if (Bfinished) {
            for (int i = 0; i < 4; i++) {
                int RnextR = Rrow + dRow[i];
                int RnextC = Rcol + dCol[i];

                if (!canMove(RnextR, RnextC, Rvisited)) {
                    continue;
                }

                // 파랑이 있는 칸으로 이동 불가
                if (RnextR == Brow && RnextC == Bcol) {
                    continue;
                }

                Rvisited[RnextR][RnextC] = true;

                dfs(RnextR, RnextC, Brow, Bcol, turn + 1);

                Rvisited[RnextR][RnextC] = false;
            }

            return;
        }

        // 둘 다 아직 도착하지 않은 경우
        for (int i = 0; i < 4; i++) {
            int RnextR = Rrow + dRow[i];
            int RnextC = Rcol + dCol[i];

            if (!canMove(RnextR, RnextC, Rvisited)) {
                continue;
            }

            for (int j = 0; j < 4; j++) {
                int BnextR = Brow + dRow[j];
                int BnextC = Bcol + dCol[j];

                if (!canMove(BnextR, BnextC, Bvisited)) {
                    continue;
                }

                // 이동 후 같은 칸이면 안 됨
                if (RnextR == BnextR && RnextC == BnextC) {
                    continue;
                }

                // 서로 위치를 맞바꾸면 안 됨
                if (RnextR == Brow && RnextC == Bcol
                        && BnextR == Rrow && BnextC == Rcol) {
                    continue;
                }

                Rvisited[RnextR][RnextC] = true;
                Bvisited[BnextR][BnextC] = true;

                dfs(RnextR, RnextC, BnextR, BnextC, turn + 1);

                Rvisited[RnextR][RnextC] = false;
                Bvisited[BnextR][BnextC] = false;
            }
        }
    }

    static boolean canMove(int row, int col, boolean[][] visited) {

        if (row < 0 || row >= N || col < 0 || col >= M) {
            return false;
        }

        if (Maze[row][col] == 5) {
            return false;
        }

        if (visited[row][col]) {
            return false;
        }

        return true;
    }
}