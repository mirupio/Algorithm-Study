package programmers.algorithm.slidingwindow;

import java.util.*;

// 틀린 답안 -> 완탐 -> 시간 초과
class Q468379 {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[] answer = new int[2];
        // drops에 없는 좌표는 MAX_VALUE로 채우고, 있는 좌표는 해당 인덱스로 채우기
        int[][] arr = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(arr[i],Integer.MAX_VALUE);
        }
        for(int i=0;i<drops.length;i++){
            arr[drops[i][0]][drops[i][1]] = i;
        }

        // m*n을 0,0부터 h*w씩 순회하며 가장 작은 원소 찾아서 리스트에 넣기
        // (원소, 좌표 형태로)
        // => X
        // 슬라이딩 윈도우 가로 최솟값
        int[][] minArr1 = new int[m][n-w+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n-w+1;j++){
                int min = Integer.MAX_VALUE;
                for(int d=0;d<w;d++){
                    min = Math.min(min,arr[i][j+d]);
                }
                minArr1[i][j] = min;
            }
        }

        // 슬라이딩 윈도우 세로 최솟값
        int[][] minArr2 = new int[m-h+1][n-w+1];
        for(int i=0;i<n-w+1;i++){
            for(int j=0;j<m-h+1;j++){
                int min = Integer.MAX_VALUE;
                for(int d=0;d<h;d++){
                    min = Math.min(min,minArr1[j+d][i]);
                }
                minArr2[j][i] = min;
            }
        }

        // 리스트 순회하며 인덱스가 가장 작은 max 원소 찾기 -> 좌표 반환
        // => X
        // 그 배열에서 젤 큰 값의 좌표 반환
        int max = Integer.MIN_VALUE;
        for(int i=0;i<m-h+1;i++){
            for(int j=0;j<n-w+1;j++){
                if(max<minArr2[i][j]){
                    max = minArr2[i][j];
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }

        return answer;
    }
}