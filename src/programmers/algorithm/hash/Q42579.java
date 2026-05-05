package programmers.algorithm.hash;

import java.util.*;

public class Q42579 {

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        int[] result = sol.solution(genres, plays);
        System.out.println(Arrays.toString(result));
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> ans = new ArrayList<>();

        // 장르별 개수 세기
        Map<String,Integer> map = new HashMap<>(); // 장르, 개수
        for(int i=0;i<genres.length;i++){
            map.put(genres[i], map.getOrDefault(genres[i],0) + plays[i]);
        }

        // 장르별 개수 내림차순 정렬
        List<String> list = new ArrayList<>(map.keySet()); // 장르
        list.sort((a,b) -> map.get(b) - map.get(a));

        for(String s : list){
            List<int[]> num = new ArrayList<>(); // 재생 횟수, 인덱스
            for(int i=0;i<genres.length;i++){ // 장르 순으로
                if(s.equals(genres[i])){ // 해당 장르인 것끼리
                    num.add(new int[]{plays[i], i});
                }
            }
            // 재생 횟수 내림차순 정렬
            // 재생 횟수 같으면 고유 번호 오름차순
            num.sort((a,b) ->{
                        int cmp = b[0] - a[0];
                        if(cmp!=0) return cmp;

                        cmp = a[1] - b[1];
                        return cmp;
            }
            );
            /*for(int i=0;i<numlist.size();i++){
                System.out.print(numlist.get(i) + " ");
            }
            System.out.println();*/


            if(num.size() > 1){
                for(int i=0;i<2;i++){
                    ans.add(num.get(i)[1]);
                }
            } else {
                ans.add(num.get(0)[1]);
            }
        }

        // list -> arr로
        int[] answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
