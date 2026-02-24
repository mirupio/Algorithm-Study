package programmers.stackqueue;

import java.util.*;

class Q42587 {
    public int solution(int[] priorities, int location) {
        int count = 1;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<priorities.length;i++){
            int[] pr = {i,priorities[i]};
            q.add(pr);
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int index = cur[0];
            int p = cur[1];

            boolean pass = true;
            for(int[] next:q){
                if(next[1] > p){
                    pass = false;
                    break;
                }
            }

            if(!pass){
                q.add(cur);
            }
            else{
                if(cur[0] == location){
                    return count;
                }
                else{
                    count++;
                }
            }
        }
        return -1;
    }
}