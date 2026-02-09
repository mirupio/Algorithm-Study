package programmers.bruteforce;

import java.util.*;

class Q42840 {
    public int[] solution(int[] answers) {
        int[] arr_1 = {1,2,3,4,5};
        int[] arr_2 = {2,1,2,3,2,4,2,5};
        int[] arr_3 = {3,3,1,1,2,2,4,4,5,5};

        int count_1 = 0;
        int count_2 = 0;
        int count_3 = 0;
        for(int i=0;i<answers.length;i++){
            int answer = answers[i];
            if(arr_1[i%5] == answer){
                count_1++;
            }
            if(arr_2[i%8] == answer){
                count_2++;
            }
            if(arr_3[i%10] == answer){
                count_3++;
            }
        }

        int[] counts = {count_1,count_2,count_3};
        int max = 0;
        for(int i=0;i<3;i++){
            if(max<counts[i]){
                max = counts[i];
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i=0;i<3;i++){
            if(max == counts[i]){
                list.add(i);
            }
        }

        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i)+1;
        }
        return answer;
    }
}