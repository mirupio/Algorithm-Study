package Baekjoon.codingdodo.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prefixsum2D_practice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 행
        int m = Integer.parseInt(st.nextToken()); // 열

        int[][] arr = new int[n+1][m+1]; // 입력 배열
        int[][] prefix = new int[n+1][m+1]; // 누적합 배열

        // 배열 입력
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 누적합 계산
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                // 현재 인덱스의 누적합 = 이전 누적합(위+왼 - 공통) + 현재 배열의 수치
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + arr[i][j];
            }
        }

        // 구간합 구하기 (startX,startY) ~ (endX,endY)
        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int endX = Integer.parseInt(st.nextToken());
        int endY = Integer.parseInt(st.nextToken());

        int sum = prefix[endY][endX] - prefix[startY -1][endX] - prefix[endY][startX -1] + prefix[startY -1][startX -1];
        System.out.println(sum);
    }
}
