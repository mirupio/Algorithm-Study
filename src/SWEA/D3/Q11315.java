package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 틀린 풀이 -> 장황, 인덱스 오류
public class Q11315 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine().trim());

            char[][] arr = new char[N][N];
            for(int i = 0; i < N; i++) {
                arr[i] = br.readLine().toCharArray();
            }

            boolean exist = false;
            // 가로 검사
            for(int i = 0; i < N; i++) {
                int sum = 0;
                for(int j = 0; j < N; j++) {
                    if(arr[i][j] == 'o'){
                        sum++;
                    }
                    else{
                        sum = 0;
                    }
                }
                if (sum >= 5) {
                    exist = true;
                    break;
                }
            }

            // 세로 검사
            for(int i = 0; i < N; i++) {
                int sum = 0;
                for(int j = 0; j < N; j++) {
                    if(arr[j][i] == 'o'){
                        sum++;
                    }
                    else{
                        sum = 0;
                    }
                }
                if (sum >= 5) {
                    exist = true;
                    break;
                }
            }

            // 대각선 \ 위쪽 검사
            int sum = 0;
            for(int k = 0; k < N/2; k++) {
                for(int i = 0; i < N/2; i++) {
                    for(int j = 0; j < N; j++) {
                        // System.out.println("i = " + i+" j = " + j+" k = " + k);
                        System.out.println((i+j) + " "+ (i+j+k));
                        if (arr[i+j][i+j+k] == 'o') {
                            sum++;
                        }
                        else{
                            sum = 0;
                        }
                    }
                }
            }
            if (sum >= 5) {
                exist = true;
            }

            // 대각선 \ 아래쪽 검사
            sum = 0;
            for(int k = 1; k < N/2; k++) {
                for(int i = 0; i < N/2; i++) {
                    for(int j = 0; j < N; j++) {
                        if (arr[i+j+k][i+j] == 'o') {
                            sum++;
                        }
                        else{
                            sum = 0;
                        }
                    }
                }
            }
            if (sum >= 5) {
                exist = true;
            }

            // 대각선 / 위쪽 검사
            sum = 0;
            for(int k = 0; k < N/2; k++) {
                for(int i = 0; i < N/2; i++) {
                    for(int j = 0; j < N; j++) {
                        if (arr[i+j][i-j-k] == 'o') {
                            sum++;
                        }
                        else{
                            sum = 0;
                        }
                    }
                }
            }
            if (sum >= 5) {
                exist = true;
            }

            // 대각선 / 아래쪽 검사
            sum = 0;
            for(int k = 1; k < N/2; k++) {
                for(int i = 0; i < N/2; i++) {
                    for(int j = 0; j < N; j++) {
                        if (arr[i+j+k][i-j] == 'o') {
                            sum++;
                        }
                        else{
                            sum = 0;
                        }
                    }
                }
            }
            if (sum >= 5) {
                exist = true;
            }

            /*// 대각선 / 위쪽 검사
            sum = 0;
            for(int i = 0; i < N; i++) {
                if (arr[i][N - 1 - i] == 'o') {
                    sum++;
                }
            }
            if (sum >= 5) {
                exist = true;
            }*/

            if(exist) {
                System.out.println("#"+t+" "+"YES");
            }
            else {
                System.out.println("#"+t+" "+"NO");
            }
        }
    }
}