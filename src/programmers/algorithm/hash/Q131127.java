package programmers.algorithm.hash;

import java.util.*;

class Q131127 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String,Integer> map = new HashMap<>();

        for(int i=0;i<want.length;i++){
            map.put(want[i],map.getOrDefault(want[i],0)+number[i]);
        }

        for(int i=0;i<discount.length-9;i++){
            Map<String,Integer> map_copy = new HashMap<>(map);
            for(int j=0;j<10;j++){
                String product = discount[i+j];
                // System.out.println("i="+i+" j="+j+" product="+product);
                if(map_copy.containsKey(product) && map_copy.get(product)>=1){
                    map_copy.put(product,map_copy.get(product)-1);
                }
                else{
                    break;
                }
            }
            boolean isSame = true;
            for(int count: map_copy.values()){
                if(count != 0){
                    isSame = false;
                    break;
                }
            }
            if(isSame){
                answer++;
            }
        }
        return answer;
    }
}