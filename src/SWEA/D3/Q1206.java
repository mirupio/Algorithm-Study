package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1206 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            String[] tokens = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            /*for (int i = 0; i < N; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();*/

            int result = 0;
            for (int i = 2; i < N-2; i++) {
                // 양옆 2개씩 중 자기보다 크거나 같은게 있는 경우 pass = 작을 때만 검사
                if( arr[i] <= arr[i-1] || arr[i] <= arr[i+1] || arr[i] <= arr[i-2] || arr[i] <= arr[i+2]) {
                    continue;
                }

                int max = 0;
                // 양옆 2개씩(총 4개) 중 젤 큰거 찾기
                max = Math.max(max, arr[i-2]);
                max = Math.max(max, arr[i-1]);
                max = Math.max(max, arr[i+1]);
                max = Math.max(max, arr[i+2]);

                result += (arr[i] - max);
                /*System.out.println("arr[i] = " + arr[i]);
                System.out.println("max = " + max);
                System.out.println("result = " + result);*/

            }

            System.out.println("#"+t+" "+result);
        }

    }
}
