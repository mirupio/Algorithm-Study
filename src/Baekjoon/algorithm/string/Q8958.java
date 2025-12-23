package Baekjoon.algorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String str = br.readLine();

            int sum = 0;
            int total = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'O') {
                  sum++;
                  total += sum;
                }
                else{
                    sum = 0;
                }
            }

            System.out.println(total);
        }
    }
}
