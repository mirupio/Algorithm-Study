package programmers.algorithm.implementation;

import java.util.*;

class Q258712 {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(friends[i],i);
        }

        int[][] present = new int[n][n];
        for(String gift: gifts){
            String[] tokens = gift.split(" ");
            String A = tokens[0];
            String B = tokens[1];

            present[map.get(A)][map.get(B)]++;
        }

        int[] presentNum = new int[n];
        for(int i=0;i<n;i++){
            // 준 것들
            int give = 0;
            for(int j=0;j<n;j++){
                give += present[i][j];
            }

            // 받은 것들
            int take = 0;
            for(int j=0;j<n;j++){
                take += present[j][i];
            }

            presentNum[i] = give - take;
        }

        int[] nextMonth = new int[n];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(present[i][j] == present[j][i]){
                    if(presentNum[i] > presentNum[j]){
                        nextMonth[i]++;
                    }
                    else if(presentNum[i] < presentNum[j]){
                        nextMonth[j]++;
                    }
                }
                else if(present[i][j] > present[j][i]){
                    nextMonth[i]++;
                }
                else{
                    nextMonth[j]++;
                }
            }
        }

        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max,nextMonth[i]);
        }
        return max;
    }
}