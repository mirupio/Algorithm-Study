package Baekjoon.algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] dp_ox = new long[N];
        long[] dp_xx = new long[N];
        long[] dp_xo = new long[N];

        dp_ox[0] = 2;
        dp_xx[0] = 3;
        dp_xo[0] = 2;

        if(N > 1){
            for(int i = 1; i < N-1; i++) {
                dp_ox[i] = (dp_xx[i-1] + dp_xo[i-1])% 9901;
                dp_xx[i] = (dp_ox[i-1] + dp_xx[i-1] + dp_xo[i-1])% 9901;
                dp_xo[i] = (dp_ox[i-1] + dp_xx[i-1])% 9901;
            }
            long total = dp_ox[N-2] + dp_xx[N-2] + dp_xo[N-2];
            System.out.println(total % 9901);
        }

        else {
            System.out.println(3);
        }
        /*
        for(int i = 0; i < N-1; i++) {
            System.out.println(dp_ox[i] + " " + dp_xx[i] + " " + dp_xo[i] + " ");
        }
         */



    }
}
