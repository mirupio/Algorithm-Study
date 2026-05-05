package programmers.algorithm.dfsbfs;

class Q43165 {
    static int[] number;
    static int targetnum;
    static int count;
    static int[] pm = {-1,1};
    public int solution(int[] numbers, int target) {
        number = new int[numbers.length];
        for(int i=0;i<numbers.length;i++){
            number[i] = numbers[i];
        }
        targetnum = target;

        count = 0; // 방법의 수

        dfs(0,0);
        // (0,0) -> (1,-1) or (1,1) -> ... -> (5,3) or (5,~)

        return count;
    }

    static void dfs(int index,int sum){
        if(index == number.length){
            if(sum == targetnum){
                count++;
            }
            return;
        }

        // + or -
        for(int i=0;i<2;i++){
            int next= sum + pm[i]*number[index];
            dfs(index+1,next);
        }
    }
}
