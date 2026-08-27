package programmers.gilbut.ch10_dp;

class Q1843 {
    public int solution(String arr[]) {
        int n = arr.length; //7

        int[][] maxDp = new int[n/2+1][n/2+1]; // maxDp[i][j] : i~j까지 만들 수 있는 숫자 중 최댓값
        int[][] minDp = new int[n/2+1][n/2+1]; // minDp[i][j] : i~j까지 만들 수 있는 숫자 중 최솟값

        // 구간 길이 1짜리 채우기
        for(int i=0;i<=n/2;i++){ //0~3
            maxDp[i][i] = Integer.parseInt(arr[i*2]);
            minDp[i][i] = Integer.parseInt(arr[i*2]);
        }

        // 구간 길이 2~n짜리 채우기
        for(int l=1;l<=n/2;l++){ // l=1~3, l=3
            for(int i=0;i+l<=n/2;i++){ // i=0~0

                int end = i+l;

                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;

                for(int j=i;j<end;j++){ // j=1~2

                    String op = arr[j*2+1];

                    if(op.equals("+")){ //1,3,5
                        max = Math.max(max,maxDp[i][j]+maxDp[j+1][end]);
                        min = Math.min(min,minDp[i][j]+minDp[j+1][end]);
                    }
                    else{
                        max = Math.max(max,maxDp[i][j]-minDp[j+1][end]);
                        min = Math.min(min,minDp[i][j]-maxDp[j+1][end]);
                    }
                }
                maxDp[i][i+l] = max;
                minDp[i][i+l] = min;
            }
        }

        return maxDp[0][n/2];
    }
}