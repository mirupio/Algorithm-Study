package programmers.algorithm.sort;
import java.util.*;

// 틀린 답안
// -> 반례 존재
// {343,34} -> 내 논리로는 34의 3과 343의 3 비교 -> 정렬 불가
public class Q42746 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] numbers = {3, 30, 34, 5, 9};

        String result = sol.solution(numbers);
        System.out.println(result);
    }
}
class Solution {
    public String solution(int[] numbers) {
        // 숫자 -> 문자열 -> 리스트에 넣기
        List<String> list = new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            list.add(String.valueOf(numbers[i]));
        }

        // 내림차순 정렬
        // 첫번째 문자 -> 두번째 문자 -> 세번째 문자
        list.sort((a,b) -> {
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            // 첫번째 문자 비교
            // 9, 5, (3,30,34)
            int cmp = b.charAt(0)-a.charAt(0);
            System.out.println("a.charAt(0) = " + a.charAt(0));
            System.out.println("b.charAt(0) = " + b.charAt(0));
            System.out.println("cmp = " + cmp);
            if(cmp !=0) return cmp;

            // 34303 34330
            // 32 3_ 30 -> 3_ 32 30
            // 34 3_ 30 -> 34 3_ 30
            // 두번째 문자 비교
            // 두번째 문자가 없으면 첫번째 문자랑 비교
            int secondA,secondB;
            if(a.length()>1) {
                secondA = a.charAt(1)-'0';
            }
            else{
                secondA = a.charAt(0)-'0';
            }
            if(b.length()>1) {
                secondB = b.charAt(1)-'0';
            }
            else{
                secondB = b.charAt(0)-'0';
            }
            cmp = secondB - secondA;
            System.out.println("secondA = " + secondA);
            System.out.println("secondB = " + secondB);
            System.out.println("cmp = " + cmp);
            if(cmp!=0) return cmp;

            // 341 34_ 344 -> 344 34_ 341
            int thirdA, thirdB;
            if(a.length()>2) {
                thirdA = a.charAt(2)-'0';
            }
            else{
                thirdA = a.charAt(0)-'0';
            }
            if(b.length()>2) {
                thirdB = b.charAt(2)-'0';
            }
            else{
                thirdB = b.charAt(0)-'0';
            }
            cmp = thirdB - thirdA;
            System.out.println("thirdA = " + thirdA);
            System.out.println("thirdB = " + thirdB);
            System.out.println("cmp = " + cmp);
            return cmp;
        });

        // 문자열로 이어붙이기
        String answer = "";
        for(int i=0;i<list.size();i++){
            answer += list.get(i);
        }

        return answer;
    }
}
