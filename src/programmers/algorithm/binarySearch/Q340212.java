package programmers.algorithm.binarySearch;

class Q340212 {
    static int[] Diffs;
    static int[] Times;
    static int N;
    public int solution(int[] diffs, int[] times, long limit) {
        Diffs = diffs;
        Times = times;
        N = diffs.length;

        // 1 ~ 100000 -> 이분탐색(파라메트릭 서치)
        int left = 1;
        int right = 100000;
        int mid = 0;
        int answer = 0;
        while(left <= right){
            mid = left + (right-left)/2;

            // 제한 이하면 더 작은 레벨 도전
            if(getTotal(mid)<=limit){
                // System.out.println("mid="+mid+" total="+getTotal(mid));
                answer = mid;
                right = mid-1;
            }
            // 제한 이상이면 레벨 더 높이기
            else if(getTotal(mid)>limit){
                // System.out.println("left="+left+" right="+right+" mid="+mid+" total="+getTotal(mid));
                left = mid+1;
            }
        }

        return answer;
    }

    static long getTotal(int level){
        long sum = 0;
        for(int i=0;i<N;i++){
            // diffs[0] = 1이어서 항상 level>=diffs[i]
            if(level < Diffs[i]){
                sum += (Times[i]+Times[i-1])*(Diffs[i]-level) + Times[i];
            }
            else{
                sum += Times[i];
            }
        }

        return sum;
    }
}