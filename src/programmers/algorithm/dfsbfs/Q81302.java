package programmers.algorithm.dfsbfs;

class Q81302 {
    static int[] dRow = {-1,1,0,0};
    static int[] dCol = {0,0,-1,1};
    static String[] place;
    static boolean[][] visited;

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        // 모든 P 주위에 거리두기를 안 한 다른 P가 있는지
        for(int p=0;p<5;p++){
            int far = 1;
            place = places[p];

            outer:
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    if(place[i].charAt(j)=='P'){
                        visited = new boolean[5][5];
                        visited[i][j] = true;

                        if(dfs(0,i,j)){
                            far = 0;
                            break outer;
                        }
                    }
                }
            }

            answer[p] = far;
        }

        return answer;
    }

    static boolean dfs(int depth, int r, int c){
        if(depth == 2){
            return false;
        }

        for(int i=0;i<4;i++){
            int nR = r + dRow[i];
            int nC = c + dCol[i];

            if(nR>=0 && nR<5 && nC>=0 && nC<5){
                if(!visited[nR][nC]){
                    // 빈 테이블이면 계속 탐색
                    if(place[nR].charAt(nC)=='O'){
                        if(dfs(depth+1,nR,nC)){
                            return true;
                        }
                    }

                    // 사람 발견 = 위반
                    else if(place[nR].charAt(nC)=='P'){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}