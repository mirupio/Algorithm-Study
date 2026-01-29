package Baekjoon.algorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }

        Arrays.sort(str,(a, b) -> {
            // 길이 오름차순
            int cmp = a.length()-b.length();
            if(cmp!=0) return cmp;

            // 자리수 합 오름차순
            int sumA = 0;
            for (int i = 0; i < a.length(); i++) {
                // System.out.println("a.charAt(i)-'0' = " + (a.charAt(i)-'0'));
                if (a.charAt(i)-'0' <= 9) {
                    sumA += a.charAt(i)-'0';
                    // System.out.println("sumA = " + sumA);
                }
            }
            int sumB = 0;
            for (int i = 0; i < b.length(); i++) {
                // System.out.println("b.charAt(i) = " + (b.charAt(i)-'0'));
                if (b.charAt(i)-'0' <= 9) {
                    sumB += b.charAt(i)-'0';
                    // System.out.println("sumB = " + sumB);
                }
            }
            cmp = sumA-sumB;
            if(cmp!=0) return cmp;

            // 사전 순 오름차순
            return a.compareTo(b);

        });

        for(int i = 0; i < N; i++) {
            System.out.println(str[i]);
        }
    }
}
