package programmers.gilbut.ch6_bruteforce;

import java.util.*;
import java.util.regex.*;

class Q67257 {
    public long solution(String expression) {

        List<String> tokens = new ArrayList<>();
        Matcher m = Pattern.compile("\\d+|[*+\\-]").matcher(expression);
        while(m.find()){
            tokens.add(m.group());
        }

        String[][] combs = {
                {"*", "+", "-"},
                {"*", "-", "+"},
                {"+", "*", "-"},
                {"+", "-", "*"},
                {"-", "*", "+"},
                {"-", "+", "*"}
        };

        long max = Long.MIN_VALUE;
        for(String[] comb: combs){
            List<String> temp = new ArrayList<>(tokens);
            for(String op: comb){
                for(int i=0;i<temp.size();i++){
                    if(temp.get(i).equals(op)){
                        long num1 = Long.parseLong(temp.get(i-1));
                        long num2 = Long.parseLong(temp.get(i+1));
                        temp.set(i,calculate(op,num1,num2));
                        temp.remove(i+1);
                        temp.remove(i-1);
                        i--;
                    }
                }
            }
            long result = Math.abs(Long.parseLong(temp.get(0)));
            if(result > max){
                max = result;
            }
        }

        return max;
    }

    private String calculate(String op, long num1, long num2){
        if(op.equals("*")){
            return String.valueOf(num1 * num2);
        }
        else if(op.equals("+")){
            return String.valueOf(num1 + num2);
        }
        else{
            return String.valueOf(num1 - num2);
        }
    }
}