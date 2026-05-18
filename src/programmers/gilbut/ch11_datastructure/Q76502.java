package programmers.gilbut.ch11_datastructure;

import java.util.*;

class Q76502 {
    public int solution(String s) {

        int count = 0;
        String str = s;
        for(int i=0; i<s.length(); i++){
            if(correct(str)){
                count++;
            }
            str = str.substring(1)+str.charAt(0);
        }

        return count;
    }

    // 올바른 괄호인지 판별하는 함수
    private boolean correct(String str){
        Stack<Character> stack = new Stack<>();
        for(char c: str.toCharArray()){
            if(c=='[' || c=='{' || c=='('){
                stack.push(c);
            }

            else{
                if(stack.isEmpty()){
                    return false;
                }

                else{
                    if(stack.peek() == '[' && c==']'){
                        stack.pop();
                    }
                    else if(stack.peek() == '{' && c=='}'){
                        stack.pop();
                    }
                    else if(stack.peek() == '(' && c==')'){
                        stack.pop();
                    }
                    else{
                        stack.push(c);
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}