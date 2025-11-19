package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1289 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++) {
            String s = br.readLine();
            int[] arr = new int[s.length()];
            for(int i=0;i<s.length();i++) {
                arr[i] = s.charAt(i) - '0';
            }

            int now = 0;
            int count = 0;
            for(int i=0;i<s.length();i++) {
                if (arr[i] != now) {
                    count++;
                    now = arr[i];
                }
            }

            System.out.println("#"+t+" "+count);
        }

    }
}
