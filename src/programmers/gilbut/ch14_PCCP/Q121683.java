package programmers.gilbut.ch14_PCCP;

import java.util.*;

class Q121683 {
    public String solution(String input_string) {
        String answer = "";

        Stack<Character> stack = new Stack<>();
        stack.push(input_string.charAt(0));

        for(char c : input_string.toCharArray()){
            if(stack.peek() != c){
                stack.push(c);
            }
        }

        Map<Character,Integer> map = new HashMap<>();
        for(char c : stack){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        List<Character> list = new ArrayList<>();
        for(char c : map.keySet()){
            if(map.get(c)>1){
                list.add(c);
            }
        }

        if(list.size()>0){
            Collections.sort(list);
            for(char c : list){
                answer += c;
            }
        }
        else{
            answer += "N";
        }

        return answer;
    }
}