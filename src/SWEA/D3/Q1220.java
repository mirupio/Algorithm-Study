package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1220 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            br.readLine();
            // 배열 입력
            int[][] arr = new int[100][100];
            for(int i = 0; i < 100; i++) {
                String[] tokens = br.readLine().split(" ");
                for(int j = 0; j < 100; j++) {
                    arr[i][j] = tokens[j].charAt(0)-'0';
                }
            }

            /*for(int i = 0; i < 100; i++) {
                for(int j = 0; j < 100; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }*/

            int count=0;
            for(int i = 0; i < 100; i++) {
                for(int j = 0; j < 100; j++) {
                    if(arr[j][i] == 1){
                        for (int k = j+1; k < 100; k++) {
                            if(arr[k][i] == 2){
                                count++;
                                j = k; // 2 등장 이후부터 다시 시작
                                break;
                            }
                        }
                    }
                }
            }

            System.out.println("#"+t+" "+count);
        }
    }
}
