package programmers.sort;

import java.util.ArrayList;
import java.util.List;

public class Q42746_2 {
    public static void main(String[] args) {
        Solution_2 sol = new Solution_2();
        int[] numbers = {3, 30, 34, 5, 9};

        String result = sol.solution(numbers);
        System.out.println(result);
    }
}
class Solution_2 {
    public String solution(int[] numbers) {
        // 숫자 -> 문자열 -> 리스트에 넣기
        List<String> list = new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            list.add(String.valueOf(numbers[i]));
        }

        // 내림차순 정렬
        list.sort((a,b) -> (b+a).compareTo(a+b));

        // 문자열로 이어붙이기
        if(list.get(0).equals("0")){
            return "0";
        }
        else{
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<list.size();i++){
                sb.append(list.get(i));
            }

            String answer = sb.toString();
            return answer;
        }
    }
}