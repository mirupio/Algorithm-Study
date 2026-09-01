package programmers.gilbut.ch11_datastructure;

import java.util.*;

class Q60060_2 {

    HashMap<Integer,List<String>> map = new HashMap<>();
    HashMap<Integer,List<String>> reverseMap = new HashMap<>();

    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        // 길이별로 단어 저장
        for(String word: words){
            int len = word.length();

            map.computeIfAbsent(len, k->new ArrayList<>())
                    .add(word);

            String reverseWord = new StringBuilder(word).reverse().toString();
            reverseMap.computeIfAbsent(len, k->new ArrayList<>())
                    .add(reverseWord);
        }

        // 길이별 정렬
        for(List<String> list: map.values()){
            Collections.sort(list);
        }
        for(List<String> list: reverseMap.values()){
            Collections.sort(list);
        }

        for(int i=0;i<queries.length;i++){
            String query = queries[i];
            int len = query.length();

            List<String> list;

            // 접두사일 경우
            if(query.charAt(0) == '?'){
                query = new StringBuilder(query).reverse().toString();
                list = reverseMap.get(len);
            }
            // 접미사일 경우
            else{
                list = map.get(len);
            }

            if(list == null){
                answer[i] = 0;
                continue;
            }

            String min = query.replace('?','a');
            String max = query.replace('?','z');

            int start = lowerBound(list,min);
            int end = upperBound(list,max);

            answer[i] = end-start;
        }

        return answer;
    }

    // target 이상이 처음 나오는 위치
    int lowerBound(List<String> list, String target){
        int left = 0;
        int right = list.size()-1;

        while(left<=right){
            int mid = (left+right)/2;

            if(list.get(mid).compareTo(target)>=0){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        return left;
    }
    // target 초과가 처음 나오는 위치
    int upperBound(List<String> list, String target){
        int left = 0;
        int right = list.size()-1;

        while(left<=right){
            int mid = (left+right)/2;

            if(list.get(mid).compareTo(target)>0){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        return left;
    }
}