package programmers.algorithm.dfsbfs;

class Q17679 {
    static int[] dRow = {0,1,1};
    static int[] dCol = {1,1,0};
    static char[][] Board;
    static boolean[][] remove;
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        Board = new char[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Board[i][j] = board[i].charAt(j);
            }
        }

        while(true){
            remove = new boolean[m][n];

            for(int i=0;i<m-1;i++){
                for(int j=0;j<n-1;j++){
                    dfs(i,j);
                }
            }

            // 삭제
            int count = 0;
            for(int row=0;row<m;row++){
                for(int col=0;col<n;col++){
                    if(remove[row][col]){
                        Board[row][col] = '.';
                        count++;
                    }
                }
            }

            if(count==0){
                break;
            }
            answer += count;

            // 채우기
            for(int col=0;col<n;col++){

                int write = m-1;

                for(int row=m-1;row>=0;row--){
                    if(Board[row][col] != '.'){
                        Board[write][col] = Board[row][col];
                        write--;
                    }
                }

                while(write >= 0){
                    Board[write][col] = '.';
                    write--;
                }
            }
        }

        return answer;
    }

    static void dfs(int r, int c){

        if(Board[r][c] != '.'
                && Board[r][c] == Board[r][c+1]
                && Board[r][c] == Board[r+1][c+1]
                && Board[r][c] == Board[r+1][c]){

            remove[r][c] = true;
            remove[r][c+1] = true;
            remove[r+1][c+1] = true;
            remove[r+1][c] = true;
        }
    }
}