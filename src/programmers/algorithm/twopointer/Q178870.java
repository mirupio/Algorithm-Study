package programmers.algorithm.twopointer;

class Q178870 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        int n = sequence.length;

        int left = 0;
        int right = 0;
        int sum = sequence[0];
        int min = Integer.MAX_VALUE;

        int answerLeft = 0;
        int answerRight = 0;

        while(right < n){
            if(sum == k){

                int len = right - left + 1;

                if(min > len){
                    min = len;
                    answerLeft = left;
                    answerRight = right;
                }

                // 현재 합이 k이므로 더 짧은 구간 찾아보기 위해 left 이동
                sum -= sequence[left];
                left++;
            }
            else if(sum < k){
                // right를 더 늘릴 수 없는 경우 종료
                if (right == n - 1) {
                    break;
                }

                right++;
                sum += sequence[right];
            }
            else{
                sum -= sequence[left];
                left++;
            }
        }

        return new int[]{answerLeft,answerRight};
    }
}