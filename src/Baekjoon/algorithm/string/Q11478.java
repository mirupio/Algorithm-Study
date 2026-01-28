package Baekjoon.algorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Q11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> set = new HashSet<>();
        String S = br.readLine();
        // 문자열 길이 : 1~S.length개
        for (int i = 1; i <= S.length(); i++) {
            // 시작 : 1, 끝 : S.length-문자열 길이
            // 1개 -> 1~S.length-1
            // 2개 -> 1~S.length-2
            // 3개 -> 1~S.length-3
            for(int j=0;j<=S.length()-i;j++){
                String str = S.substring(j, j + i);
                // System.out.println(str);
                set.add(str);
            }
        }

        // System.out.println(set);
        System.out.println(set.size());
    }
}


