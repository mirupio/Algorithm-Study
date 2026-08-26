package programmers.algorithm.binarySearch;

import java.util.*;

class Q43236 {
    static int[] Rocks;
    static int N,Distance;
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        Rocks = rocks;
        Arrays.sort(Rocks);

        N = n;
        Distance = distance;

        int left = 1;
        int right = distance;
        while(left <= right){
            int mid = left+(right-left)/2;

            if(isAvailable(mid)){
                left = mid+1;
                answer = mid;
            }
            else{
                right = mid-1;
            }
        }

        return answer;
    }

    // 거리의 최소가 x가 되기 위해, n만큼 제거하면 가능한가
    static boolean isAvailable(int x){
        int remove = 0;
        int prev = 0;

        // 거리가 x보다 작으면 그 바위 제거
        for(int rock:Rocks){
            if(rock-prev < x){
                remove++;
            }
            else{
                prev = rock;
            }
        }

        if(Distance-prev < x){
            remove++;
        }

        return remove<=N;
    }
}