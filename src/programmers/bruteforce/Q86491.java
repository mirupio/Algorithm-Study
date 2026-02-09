package programmers.bruteforce;

import java.util.*;

class Q86491 {
    public int solution(int[][] sizes) {
        int w_max = 0;
        int h_max = 0;
        for(int i=0;i<sizes.length;i++){
            int w = Math.max(sizes[i][0],sizes[i][1]);
            int h = Math.min(sizes[i][0],sizes[i][1]);

            if(w_max < w){
                w_max = w;
            }

            if(h_max < h){
                h_max = h;
            }
        }

        int answer = w_max * h_max;
        return answer;
    }
}