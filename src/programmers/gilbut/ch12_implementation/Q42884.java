package programmers.gilbut.ch12_implementation;

import java.util.*;

class Q42884 {
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes,(a,b)->a[0]-b[0]);

        int count = 1;
        int s1 = routes[0][0]; // -20
        int e1 = routes[0][1]; // -15
        for(int i=1;i<routes.length;i++){
            int[] route = routes[i];
            int s2 = route[0];
            int e2 = route[1];

            // 겹치지 않으면 카메라 개수++
            if(e1 < s2){
                count++;
                s1 = s2;
                e1 = e2;
            }

            else{
                s1 = Math.max(s1,s2);
                e1 = Math.min(e1,e2);
            }

        }

        return count;
    }
}