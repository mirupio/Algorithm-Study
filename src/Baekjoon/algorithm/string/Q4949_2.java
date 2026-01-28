package Baekjoon.algorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q4949_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();
            if (s.equals(".")) {
                break;
            }

            boolean isValid = true;

            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[') {
                    stack.push(c);
                }
                else if (c == ')') {
                    if(stack.isEmpty()||stack.peek() != '(') {
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }
                else if (c == ']') {
                    if(stack.isEmpty()||stack.peek() != '[') {
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if(isValid && stack.isEmpty()) {
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }
        }

    }
}
