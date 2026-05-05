package programmers.algorithm.sort;

import java.util.*;

class Q42748 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int t=0;t<commands.length;t++){
            int i = commands[t][0];
            int j = commands[t][1];
            int k = commands[t][2];

            int[] arr = new int[j-i+1];
            for(int a=0;a<arr.length;a++){
                arr[a] = array[a+i-1];
            }

            Arrays.sort(arr);
            answer[t] = arr[k-1];

        }
        return answer;
    }
}
