package programmers.gilbut.ch13_kakao;

class Q92345 {
    static int[] dRow = {-1,1,0,0};
    static int[] dCol = {0,0,-1,1};
    static int N,M;

    static class Result{
        boolean win;
        int count;

        Result(boolean win, int count){
            this.win = win;
            this.count = count;
        }
    }
    public int solution(int[][] board, int[] aloc, int[] bloc) {

        N = board.length;
        M = board[0].length;

        Result result = dfs(aloc[0],aloc[1],bloc[0],bloc[1],board);
        return result.count;
    }

    static Result dfs(int curR, int curC, int otherR, int otherC, int[][] board){

        // 내 발판 사라졌으면 바로 패배
        if(board[curR][curC] == 0){
            return new Result(false,0);
        }

        boolean canWin = false;
        int minWin = Integer.MAX_VALUE;
        int maxLose = 0;

        boolean canMove = false;

        for(int i=0;i<4;i++){
            int nextR = curR + dRow[i];
            int nextC = curC + dCol[i];
            if(nextR>=0 && nextR<N && nextC>=0 && nextC<M
                    && board[nextR][nextC]==1){

                canMove = true;

                board[curR][curC] = 0; // 현재 발판 제거

                Result next = dfs(otherR,otherC,nextR,nextC,board);

                board[curR][curC] = 1; // 백트래킹

                if(!next.win){
                    canWin = true;
                    minWin = Math.min(minWin,next.count+1);
                }
                else{
                    maxLose = Math.max(maxLose,next.count+1);
                }
            }
        }
        if(!canMove){
            return new Result(false,0);
        }

        if(canWin){
            return new Result(true,minWin);
        }

        return new Result(false,maxLose);
    }
}