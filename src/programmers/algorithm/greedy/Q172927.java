package programmers.algorithm.greedy;

import java.util.*;

class Q172927 {
    static int[][] use;
    public int solution(int[] picks, String[] minerals) {

        use = new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(i<=j){
                    use[i][j] = 1;
                }
            }
        }
        use[1][0] = 5;
        use[2][0] = 25;
        use[2][1] = 5;


        // 사용할 수 있는 곡괭이 개수
        int pickCount = picks[0]+picks[1]+picks[2];

        // 실제로 캘 수 있는 광물 개수
        int maxMinerals = Math.min(minerals.length,pickCount*5);

        // 광물을 5개씩 묶어서 저장
        List<int[]> groups = new ArrayList<>();

        for(int i=0;i<maxMinerals;i+=5){
            int end = Math.min(i+5,maxMinerals);

            int[] mineralGroup = new int[end-i];
            for(int j=i;j<end;j++){
                if(minerals[j].equals("diamond")){
                    mineralGroup[j-i] = 0;
                }
                else if(minerals[j].equals("iron")){
                    mineralGroup[j-i] = 1;
                }
                else{
                    mineralGroup[j-i] = 2;
                }
            }

            groups.add(mineralGroup);
        }

        // 돌 곡괭이로 캤을 때 피로도가 큰 그룹부터 정렬
        groups.sort((a,b) -> {
            long fatigueA = getTotal(2,a);
            long fatigueB = getTotal(2,b);

            return Long.compare(fatigueB,fatigueA);
        });

        int sumUse = 0;
        // 좋은 곡괭이부터 사용
        for(int p=0;p<3;p++){
            while(picks[p] > 0 && !groups.isEmpty()){
                int[] mineralGroup = groups.remove(0);

                sumUse += getTotal(p,mineralGroup);

                picks[p]--;
            }
        }
        return sumUse;
    }

    static long getTotal(int p, int[] mineral){
        long sum = 0;
        for(int m: mineral){
            sum += use[p][m];
        }

        return sum;
    }
}