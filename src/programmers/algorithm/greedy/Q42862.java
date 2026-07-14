package programmers.algorithm.greedy;

import java.util.*;

class Q42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] arr = new int[n];
        Arrays.fill(arr,1);
        for(int i=0;i<lost.length;i++){
            arr[lost[i]-1]--;
        }
        for(int i=0;i<reserve.length;i++){
            arr[reserve[i]-1]++;
        }

        for(int i=0;i<n;i++){
            if(arr[i] == 0){
                if(i-1>=0 && arr[i-1]>1){
                    arr[i-1]--;
                    arr[i]++;
                }
                else if(i+1<=n-1 && arr[i+1]>1){
                    arr[i+1]--;
                    arr[i]++;
                }
            }
        }

        for(int i=0;i<n;i++){
            if(arr[i]>0){
                answer++;
            }
        }
        return answer;
    }
}