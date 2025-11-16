package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1970 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

        for(int t=1;t<=T;t++) {
            int N = Integer.parseInt(br.readLine());

            System.out.println("#"+t);
            for(int i=0; i<8; i++) {
                int count = N/money[i];
                N = N%money[i];

                System.out.print(count +" ");
            }
            System.out.println();
        }
    }
}
