package Baekjoon.algorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5525_2 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int count = 0;
        int cnt = 0;
        for (int i = 1; i < M - 1; i++) {
            if (S.charAt(i - 1) == 'I'
                && S.charAt(i) == 'O'
                && S.charAt(i + 1) == 'I') {

                cnt++;
                // P1 : IOI -> IOI 1개
                // P2 : IOIOI -> IOI 2개
                if(cnt == N){
                    count++;
                    cnt--;
                }
                i++;
            }
            else{
                cnt = 0;
            }
        }

        System.out.print(count);
    }
}
