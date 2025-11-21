package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1209 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            br.readLine();
            int[][] arr = new int[100][100];

            for(int i = 0; i < 100; i++) {
                String[] tokens = br.readLine().split(" ");
                for(int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(tokens[j]);
                }
            }

            int max=0;
            // 가로 검사
            for (int i = 0; i < 100; i++) {
                int sum = 0;
                for(int j = 0; j < 100; j++) {
                    sum += arr[i][j];
                }
                max = Math.max(max, sum);
            }

            // 세로 검사
            for (int i = 0; i < 100; i++) {
                int sum = 0;
                for(int j = 0; j < 100; j++) {
                    sum += arr[j][i];
                }
                max = Math.max(max, sum);
            }

            // 대각선 \ 검사
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += arr[i][i];
            }
            max = Math.max(max, sum);

            // 대각선 / 검사
            sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += arr[i][99-i];
            }
            max = Math.max(max, sum);

            System.out.println("#"+t+" " +max);
        }
    }
}
