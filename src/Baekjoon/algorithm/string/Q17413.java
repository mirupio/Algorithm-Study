package Baekjoon.algorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q17413 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        boolean tagStart = false;
        String tag = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            // System.out.println("c = " + c);
            if (c == '<') {
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop());
                }
                tag = "";
                tagStart = true;
                tag += c;
            }
            else if (c == '>') {
                tagStart = false;
                tag += c;
                System.out.print(tag);
            }
            else{
                if (tagStart) {
                    tag+=c;
                }
                else{
                    if (c == ' ') {
                        while(!stack.isEmpty()){
                            System.out.print(stack.pop());
                        }
                        System.out.print(" ");
                    }
                    else{
                        stack.push(c);
                        // System.out.println(stack);
                    }
                }
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
