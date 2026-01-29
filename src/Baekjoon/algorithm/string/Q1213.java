package Baekjoon.algorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 팰린드롬
public class Q1213 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(); // abcabcc

        // 각 문자의 개수
        // a:2, b:2, c:3
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            freq.put(str.charAt(i),freq.getOrDefault(str.charAt(i),0) + 1);
        }

        int oddcount = 0;
        char mid = ' ';
        for (char c : freq.keySet()) {
            // 홀수 개인 문자 개수 세기
            if (freq.get(c) % 2 == 1) {
                oddcount++;
                mid = c; // 홀수 개인 문자를 가운데로
            }
        }

        // 홀수 개인 문자가 2개 이상이면 불가능
        if (oddcount > 1) {
            System.out.print("I'm Sorry Hansoo");
            return;
        }


        // aabbccc
        List<Character> chars = new ArrayList<>(freq.keySet());
        Collections.sort(chars); // 알파벳 순 정렬

        // 앞
        StringBuilder front = new StringBuilder();
        for (char c : chars) {
            int count = freq.get(c) / 2; // a:1, b:1, c:1
            for (int i = 0; i < count; i++) {
                front.append(c); // abc
            }
        }

        // 뒤 (=앞의 거꾸로)
        StringBuilder back = new StringBuilder(front).reverse(); // cba

        if (oddcount == 1) {
            System.out.print(front + String.valueOf(mid) + back); // abc + c + cba
        }
        else{
            System.out.print(front.toString() + back.toString());
        }
    }
}
