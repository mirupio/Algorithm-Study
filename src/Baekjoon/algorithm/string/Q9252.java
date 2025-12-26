package Baekjoon.algorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// LCS 2
public class Q9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String second = br.readLine();

        int[][] dp = new int[first.length()+1][second.length()+1];

        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= second.length(); j++) {
                if (first.charAt(i-1) == second.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); // first or second의 현재 문자 버리기
                }
            }
        }

        System.out.println(dp[first.length()][second.length()]);

        int i = first.length();
        int j = second.length();
        String LCS = "";
        while (i > 0 && j > 0) {
            if(first.charAt(i-1) == second.charAt(j-1)) {
                LCS += first.charAt(i - 1);
                i--;
                j--;
            }
            else{
                if(dp[i-1][j] > dp[i][j-1]) {
                    i--;
                }
                else{
                    j--;
                }
            }
        }
        for (int c = LCS.length() - 1; c >= 0; c--) {
            System.out.print(LCS.charAt(c));
        }
    }
}
