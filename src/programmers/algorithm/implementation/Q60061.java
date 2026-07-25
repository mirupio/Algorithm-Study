package programmers.algorithm.implementation;

import java.util.*;

class Q60061 {
    static int N;
    static boolean[][] pillar; // x,y에 기둥 있는지
    static boolean[][] bar; // x,y에 보 있는지
    public int[][] solution(int n, int[][] build_frames) {
        N = n;
        pillar = new boolean[n+1][n+1];
        bar = new boolean[n+1][n+1];

        // 적용했을 때 조건 만족하면 실행
        for(int[] build_frame:build_frames){
            int x = build_frame[0];
            int y = build_frame[1];
            int a = build_frame[2];
            int b = build_frame[3];

            // 기둥 삭제
            if(b == 0 && a == 0){
                pillar[x][y] = false;
                if(!isValid()){
                    pillar[x][y] = true;
                }
            }
            // 기둥 설치
            else if(b == 1 && a == 0){
                pillar[x][y] = true;
                if(!isValid()){
                    pillar[x][y] = false;
                }
            }
            // 보 삭제
            else if(b == 0 && a == 1){
                bar[x][y] = false;
                if(!isValid()){
                    bar[x][y] = true;
                }
            }
            // 보 설치
            else if(b == 1 && a == 1){
                bar[x][y] = true;
                if(!isValid()){
                    bar[x][y] = false;
                }
            }

        }

        List<int[]> result = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                if(pillar[i][j]){
                    result.add(new int[]{i,j,0});
                }
                if(bar[i][j]){
                    result.add(new int[]{i,j,1});
                }
            }
        }

        int[][] answer = new int[result.size()][];
        for(int i=0;i<result.size();i++){
            answer[i] = result.get(i);
        }
        return answer;
    }

    // 조건 만족하는지
    static boolean isValid(){
        for(int x=0;x<N+1;x++){
            for(int y=0;y<N+1;y++){
                // 기둥
                // 바닥 위 or 보의 한쪽 끝 위 or 다른 기둥 위
                if(pillar[x][y]){
                    if(!(y==0 || bar[x][y] || (x>0 && bar[x-1][y])
                            || (y>0 && pillar[x][y-1]))){
                        return false;
                    }
                }

                // 보
                if(bar[x][y]){
                    // 한쪽 끝이 기둥 위 or 양쪽 끝이 다른 보와 연결
                    if (!((y > 0 && pillar[x][y - 1])
                            || (x<N && y > 0 && pillar[x + 1][y - 1])
                            || (x > 0 && x<N && bar[x - 1][y] && bar[x + 1][y]))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}