package programmers.algorithm.stackqueue;

import java.util.*;

class Q131704 {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();

        int next = 1;
        int count = 0;
        for(int i=0;i<order.length;i++){
            int o = order[i]; // 4
            while(next<order.length && o>next){
                stack.push(next); // 1 2 3
                next++;
            }

            if(!stack.isEmpty() && stack.peek()==o){
                count++;
                stack.pop();
            }
            else if(next == o){
                count++;
                next++;
            }
            else{
                break;
            }
        }

        return count;
    }
}