class Q43238 {
    public long solution(int n, int[] times) {
        long answer = 0;

        long left = 1;
        long max = Long.MIN_VALUE;
        for(int t:times){
            max = Math.max(max,t);
        }
        long right = max*n;
        while(left<=right){
            long mid = left+(right-left)/2;

            long count = 0;
            for(int t : times){
                count += mid/t;
            }

            if(count<n){
                left = mid+1;
            }
            else{
                answer = mid;
                right = mid-1;
            }
        }

        return answer;
    }
}