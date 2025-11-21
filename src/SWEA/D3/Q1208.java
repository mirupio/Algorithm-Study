package SWEA.D3;

import java.io.*;

import static java.util.Arrays.*;

public class Q1208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            int dump = Integer.parseInt(br.readLine());

            int[] arr = new int[100];
            String[] tokens = br.readLine().split(" ");
            for (int i = 0; i < 100; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            while (dump-- > 0) {
                sort(arr);
                arr[99]--;
                arr[0]++;
            }

            sort(arr);
            int result = arr[99] - arr[0];

            System.out.println("#"+t+" "+result);
        }

    }
}
