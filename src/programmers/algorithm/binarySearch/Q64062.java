package programmers.algorithm.binarySearch;

class Q64062 {
    static int K;
    public int solution(int[] stones, int k) {
        int answer = 0;

        K = k;

        int left = 0;
        int right = 200000000;
        while(left<=right){
            int mid = left + (right-left)/2;
            // System.out.println("mid="+mid);

            if(available(stones,mid)){
                answer = mid;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }

        return answer;
    }

    static boolean available(int[] stones, int friend){
        int count = 0;
        for(int i=0;i<stones.length;i++){
            if(stones[i]-friend < 0){
                count++;
            }
            else{
                count = 0;
            }
            if(count >= K){
                return false;
            }
        }

        return true;
    }
}