package programmers.algorithm.hash;

import java.util.*;

class Q42577 {
    public boolean solution(String[] phone_book) {

        Set<String> set = new HashSet<>(Arrays.asList(phone_book));

        // 1195524421 (길이 10)
        for(String s:phone_book){
            // 0~9
            for(int i=0;i<s.length();i++){
                if(set.contains(s.substring(0,i))){
                    return false;
                }
            }
        }
        return true;
    }
}
