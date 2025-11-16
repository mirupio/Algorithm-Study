package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1945 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        int[] prime = {2, 3, 5, 7, 11};

        for(int t=1;t<=T;t++) {
            int[] num = new int[5];
            int N = Integer.parseInt(br.readLine().trim());

            for (int i = 0; i < 5; i++) {
                while (N % prime[i] == 0) {
                    num[i] += 1;
                    N = N / prime[i];
                }
            }

            System.out.print("#"+t+" ");
            for (int i = 0; i < 5; i++) {
                System.out.print(num[i]+" ");
            }
            System.out.println();
        }
    }
}
