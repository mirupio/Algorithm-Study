package programmers.algorithm.stackqueue;

import java.util.*;

class Q17680 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        Deque<String> dq = new ArrayDeque<>();
        int time = 0;
        if(cacheSize == 0){
            return cities.length*5;
        }
        else{
            for(int i=0;i<cities.length;i++){
                String city = cities[i].toLowerCase();
                boolean hit = false;
                // cache hit
                if(dq.contains(city)){
                    // System.out.println("cache hit "+city);
                    time++;
                    dq.remove(city);
                    dq.addLast(city);
                    hit = true;
                }

                // cache miss
                else{
                    // System.out.println("cache miss "+city);
                    time += 5;
                    if(dq.size()<cacheSize){
                        dq.addLast(city);
                    }
                    else {
                        dq.pollFirst();
                        dq.addLast(city);
                    }
                }
            }
            return time;
        }
    }
}