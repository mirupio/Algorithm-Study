package Baekjoon.algorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();
            if (s.equals(".")) {
                break;
            }
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                // System.out.println("i: "+i+" c: "+c);
                if (c == '(' || c == '[') {
                    stack.push(c);
                }
                else if (c == ')') {
                    if(!stack.isEmpty()) {
                        if(stack.peek() == '(') {
                            stack.pop();
                        }
                        else {
                            break;
                        }
                    }
                    else{
                        stack.push(c);
                        break;
                    }
                }
                else if (c == ']') {
                    if(!stack.isEmpty()) {
                        if(stack.peek() == '[') {
                            stack.pop();
                        }
                        else {
                            break;
                        }
                    }
                    else{
                        stack.push(c);
                        break;
                    }
                }
                // System.out.println(stack);
            }

            if(stack.isEmpty()) {
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }
        }

    }
}
