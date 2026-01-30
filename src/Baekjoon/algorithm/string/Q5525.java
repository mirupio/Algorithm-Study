package Baekjoon.algorithm.string;

import java.io.*;

// 부분 정답 -> 시간 초과
public class Q5525 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        String P = "";
        for(int i=1;i<=2*N+1;i++){
            if (i % 2 == 1) {
                P += 'I';
            }
            else{
                P += 'O';
            }
        }
        // System.out.println("P= "+P);

        // PN : 2*N+1 길이
        // 0~M-1-(2*N) 점검
        int count = 0;
        for (int i = 0; i <= M - 1 - (2 * N); i++) {
            String s = S.substring(i,i+2*N+1);
            // System.out.println(s);
            if(P.equals(s)){
                // System.out.println("count");
                count++;
            }
        }

        System.out.print(count);
    }
}
