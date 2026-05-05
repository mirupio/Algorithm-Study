package programmers.algorithm.sort;
import java.util.*;

public class Q42747 {
    public static void main(String[] args) {
        Solution_3 sol = new Solution_3();
        int[] citations = {3, 0, 6, 1, 5};

        int result = sol.solution(citations);
        System.out.println(result);
    }
}

class Solution_3 {
    public int solution(int[] citations) {
        // 오름차순 정렬
        // 0 1 3 5 6
        Arrays.sort(citations);

        // h=6 -> 1개 -> 비교할 필요도 없음
        // h=5 -> 2개
        // h=4 -> 2개
        // h=3 -> 3개 -> return 3
        // h=2 -> 3개
        // h=5~0
        // 인덱스가 citations.length-h인 원소가 h 이상인지
        for(int h=citations.length;h>=0;h--){
            if(citations.length-h>=0 && citations.length-h<citations.length){
                if(citations[citations.length-h] >= h){
                    return h;
                }
            }

        }
        return 0;
    }
}
