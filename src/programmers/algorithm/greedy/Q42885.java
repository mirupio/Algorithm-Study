package programmers.algorithm.greedy;

import java.util.*;

class Q42885 {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;

        while(left<=right){
            if(left==right){
                answer++;
                break;
            }

            if(people[left]+people[right]<=limit){
                left++;
                right--;
            }
            else{
                right--;
            }
            answer++;
        }

        return answer;
    }
}