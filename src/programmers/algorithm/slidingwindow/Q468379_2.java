package programmers.algorithm.slidingwindow;

import java.util.*;

// 슬라이딩 윈도우 -> deque 사용
// "절대로 최솟값이 될 수 없는 원소는 미리 버려서, 맨 앞이 항상 최솟값이 되게 만듦." -> 완탐 x, 시간 아끼기
// dq엔 인덱스를 담음 -> 윈도우 크기 벗어난 거 쉽게 제거하기 위해
class Q468379_2 {
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

        // 슬라이딩 윈도우 가로 최솟값
        int[][] minArr1 = new int[m][n-w+1];
        for(int i=0;i<m;i++){
            Deque<Integer> dq = new ArrayDeque<>();

            for(int j=0;j<n;j++){
                // 새 값보다 큰 값은 뒤에서 제거
                while(!dq.isEmpty()
                        && arr[i][j] <= arr[i][dq.peekLast()] ){
                    dq.pollLast();
                }

                dq.offerLast(j);

                // 구간 밖으로 나간 값은 앞에서 제거
                while(!dq.isEmpty() && dq.peekFirst()+w <= j){
                    dq.pollFirst();
                }

                // 윈도우 크기만큼 다 봤는가 -> 윈도우 시작 위치에 최솟값 저장
                if(j>=w-1){
                    minArr1[i][j-w+1] = arr[i][dq.peekFirst()];
                }
            }
        }

        // 슬라이딩 윈도우 세로 최솟값
        int[][] minArr2 = new int[m-h+1][n-w+1];
        for(int i=0;i<n-w+1;i++){
            Deque<Integer> dq = new ArrayDeque<>();

            for(int j=0;j<m;j++){
                while(!dq.isEmpty()
                        && minArr1[j][i] <= minArr1[dq.peekLast()][i]){
                    dq.pollLast();
                }

                dq.offerLast(j);

                while(!dq.isEmpty() && dq.peekFirst()+h <= j){
                    dq.pollFirst();
                }

                if(j>=h-1){
                    minArr2[j-h+1][i] = minArr1[dq.peekFirst()][i];
                }
            }
        }

        // minArr2에서 젤 큰 값의 좌표 반환
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