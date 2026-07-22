package programmers.algorithm.hash;

import java.util.*;

class Q132265 {
    public int solution(int[] topping) {
        int answer = 0;

        // 가짓수 : set에 넣고 set.size()

        // 0~i까지의 가짓수
        int[] arr = new int[topping.length];
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<topping.length;i++){
            set.add(topping[i]);
            arr[i] = set.size();
        }

        // 맨뒤~i까지의 가짓수
        int[] arrReverse = new int[topping.length];
        set = new HashSet<>();
        for(int i=topping.length-1;i>=0;i--){
            set.add(topping[i]);
            arrReverse[i] = set.size();
        }

        // 나누는 곳
        for(int i=1;i<topping.length;i++){
            if(arr[i-1] == arrReverse[i]){
                answer++;
            }
        }

        return answer;
    }
}