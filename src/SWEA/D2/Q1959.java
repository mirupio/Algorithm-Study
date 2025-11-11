package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1959 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] Ai = new int[N];
            String[] tokens = br.readLine().split(" ");
            for(int i=0;i<N;i++) {
                Ai[i] = Integer.parseInt(tokens[i]);
            }

            int[] Bj = new int[M];
            tokens = br.readLine().split(" ");
            for(int i=0;i<M;i++) {
                Bj[i] = Integer.parseInt(tokens[i]);
            }

            // "M>=N & Bj가 더 큰 배열"로 가정
            if(N>M){
                int[] temp = Ai;
                Ai = Bj;
                Bj = temp;

                int temp_num = N;
                N = M;
                M = temp_num;
            }

            /*for(int i=0;i<N;i++) {
                System.out.print(Ai[i]+" ");
            }
            System.out.println();
            for(int i=0;i<M;i++) {
                System.out.print(Bj[i]+" ");
            }
            System.out.println();*/

            int max = 0;
            int sum = 0;
            for(int j=0;j<(M-N)+1;j++) {
                for(int i=0;i<N;i++) {
                    // System.out.println("Ai[i] = "+Ai[i]);
                    // System.out.println("Bj[i+j] = "+Bj[i+j]);
                    sum += (Ai[i]*Bj[i+j]);
                    // System.out.println("sum = " + sum);
                }
                if(sum > max) {
                    max = sum;
                }
                sum = 0;
                // System.out.println("max = " + max);
            }

            System.out.println("#" + t + " " + max);
        }

    }
}
