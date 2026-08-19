package programmers.algorithm.heap;

import java.util.*;

class Q121685 {
    static List<Integer> list;
    public String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];

        for(int q=0; q<queries.length;q++){
            int n = queries[q][0];
            int p = queries[q][1];

            list = new ArrayList<>();
            getParent(n,p);

            // 루트부터 다시 내려가기
            String cur = "Rr";
            for(int i=list.size()-1;i>=0;i--){
                int child = list.get(i);

                if(cur.equals("RR")){
                    cur = "RR";
                }
                else if(cur.equals("rr")){
                    cur = "rr";
                }
                else{
                    if(child == 1){
                        cur = "RR";
                    }
                    else if(child == 4){
                        cur = "rr";
                    }
                    else{
                        cur = "Rr";
                    }
                }
            }
            answer[q] = cur;
        }

        return answer;
    }

    static void getParent(int n, int p){
        if(n==1){
            return;
        }

        int nextP;

        if(p%4 == 0){
            nextP = p/4;
            list.add(4);
        }
        else{
            nextP = p/4+1;
            list.add(p%4);
        }

        getParent(n-1,nextP);
    }
}