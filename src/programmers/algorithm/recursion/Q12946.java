package programmers.algorithm.recursion;

import java.util.*;

// 하노이탑 : "가장 큰 원판을 옮기려면 그 위의 원판들을 먼저 치워야 한다"
class Q12946 {
    static List<int[]> list = new ArrayList<>();

    public int[][] solution(int n) {
        move(n,1,2,3);

        int[][] answer = new int[list.size()][2];

        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

    // 옮길 개수, 출발, 보조, 도착
    static void move(int count, int start, int mid, int end){
        if(count == 0){
            return;
        }

        move(count-1,start, end, mid); // 위의 n-1개를 보조로 옮김
        list.add(new int[]{start,end}); // 가장 큰 원판을 목적지로 옮김
        move(count-1,mid,start,end); // 보조의 n-1개를 목적지로 옮김
    }

}