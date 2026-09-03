package programmers.gilbut.ch13_kakao;

class Q92344 {
    public int solution(int[][] board, int[][] skills) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;

        // 차분 배열
        int[][] diff = new int[n+1][m+1];
        for(int[] skill: skills){
            int type = skill[0];
            int r1 = skill[1];
            int c1 = skill[2];
            int r2 = skill[3];
            int c2 = skill[4];
            int degree = skill[5];

            int value;
            if (type == 1) {
                value = -degree;
            } else {
                value = degree;
            }

            diff[r1][c1] += value;
            diff[r1][c2+1] -= value;
            diff[r2+1][c1] -= value;
            diff[r2+1][c2+1] += value;
        }

        // 가로 누적
        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
                diff[i][j] += diff[i][j-1];
            }
        }
        // 세로 누적
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                diff[i][j] += diff[i-1][j];
            }
        }

        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]+diff[i][j] >= 1){
                    count++;
                }
            }
        }

        return count;
    }
}