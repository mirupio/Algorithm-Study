package programmers.gilbut.ch14_PCCP;

// 시간 초과 날 수도 있는 풀이
// 10^6 * 10^4 = 10^10
class Q121688 {
    public int solution(int[] ability, int number) {
        int sum = 0;
        for(int i=0;i<ability.length;i++){
            sum += ability[i];
        }

        while(number-- > 0){
            int min = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            int idx = -1;
            int idx2 = -1;
            for(int i=0;i<ability.length;i++){
                if(min>ability[i]){
                    min2 = min;
                    min = ability[i];
                    idx2 = idx;
                    idx = i;
                }
                else if(min2 > ability[i]){
                    min2 = ability[i];
                    idx2 = i;
                }
            }
            ability[idx] += min2;
            ability[idx2] += min;

            //System.out.println("min="+min+" min2="+min2);
            sum += (min+min2);
        }

        return sum;
    }

}