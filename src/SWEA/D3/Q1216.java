package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1216 {
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            int testcase = Integer.parseInt(br.readLine());

            arr = new char[100][100];
            for (int i = 0; i < 100; i++) {
                arr[i] = br.readLine().toCharArray();
            }

            int result = 0;

            // 회문 길이 100~1
            outer:
            for(int l = 100; l > 0; l--) {
                // 가로 검사 (0행~99행)
                for(int i=0;i<100;i++) {
                    for(int j=0;j<101-l;j++) {
                        /*System.out.println("row = " + i);
                        System.out.println("start = " + j);
                        System.out.println("end = " + (j+l-1));*/
                        if(isP_row(j, j + l-1, i)){
                            result = l;
                            break outer;
                        };
                    }
                }

                // 세로 검사 (0열~99열)
                for(int i=0;i<100;i++) {
                    for(int j=0;j<101-l;j++) {
                        if(isP_col(j, j + l-1, i)){
                            result = l;
                            break outer;
                        };
                    }
                }
            }

        System.out.println("#"+testcase+" "+result);
        }
    }

    static boolean isP_row(int start, int end, int row) {
        while (start <= end) {
            if(arr[row][start] != arr[row][end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    static boolean isP_col(int start, int end, int col) {
        while (start <= end) {
            if(arr[start][col] != arr[end][col]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
