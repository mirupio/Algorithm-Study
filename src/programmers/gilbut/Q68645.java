package programmers.gilbut;

class Q68645 {
    static int[] dRow = {1,0,-1};
    static int[] dCol = {0,1,-1};
    static int row = 0;
    static int col = 0;
    private void move(int dir){
        row += dRow[dir%3];
        col += dCol[dir%3];
    }
    private void moveback(int dir){
        row -= dRow[dir%3];
        col -= dCol[dir%3];
    }
    public int[] solution(int n) {
        int[][] arr = new int[n][n];

        int num = 1;
        int dir = 0;
        while(num < (n*(n+1)/2)+1){
            // 원소=0, 행<n, 행>=열일 경우에만 넣기
            if(row>=0 && row<n
                    && col>=0 && col<n
                    && row>=col
                    && arr[row][col] == 0){
                arr[row][col] = num;
            }

            // 아닐 경우 방향 바꾸기
            else{
                moveback(dir);
                dir++;
                move(dir);
                arr[row][col] = num;
            }

            move(dir);
            num++;
        }

        int[] answer = new int[n*(n+1)/2];
        int a=0;
        for(int r=0;r<n;r++){
            for(int c=0;c<=r;c++){
                answer[a++] = arr[r][c];
            }
        }
        return answer;
    }
}


/*
/으로 이동 : [++][] = dRow++
[0,0] [1,0] [2,0] [3,0] [4,0] [5,0]
ㅡ으로 이동 : [][++] = dCol++
[5,1] [5,2] [5,3] [5,4] [5,5]
\으로 이동 : [--][--] = dRow--, dCol--
[4,4] [3,3] [2,2] [1,1]
/
[2,1] [3,1] [4,1]
ㅡ
[4,2] [4,3]
\
[3,2]
*/