package programmers.gilbut;

import java.util.*;

class Q42883_2 {
    public String solution(String number, int k) {
        String answer = "";

        Stack<Character> stack = new Stack<>();
        for(char c:number.toCharArray()){
            while(k>0 && !stack.isEmpty() && c>stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        while(k-- > 0){
            stack.pop();
        }

        for(char c: stack){
            answer += c;
        }

        return answer;
    }
}