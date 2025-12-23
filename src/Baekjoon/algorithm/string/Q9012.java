package Baekjoon.algorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '(') {
                    stack.push(c);
                }
                else{
                    if(stack.isEmpty()){
                        // System.out.println("t: "+t+" NO");
                        stack.push(c); // 결과는 NO 확정이지만 stack이 비면 YES를 반환하므로 stack에 아무거나 넣어주고 반복문을 멈춤
                        break;
                    }
                    stack.pop();
                }
            }

            if (!stack.isEmpty()) {
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
            }
        }

    }
}
