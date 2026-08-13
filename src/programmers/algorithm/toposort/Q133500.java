package programmers.algorithm.toposort;

import java.util.*;

class Q133500 {
    public int solution(int n, int[][] lighthouses) {

        int[] degree = new int[n+1];
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] lighthouse: lighthouses){
            int from = lighthouse[0];
            int to = lighthouse[1];

            degree[from]++;
            degree[to]++;

            graph[from].add(to);
            graph[to].add(from);
        }

        boolean[] removed = new boolean[n+1];
        boolean[] on = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<n+1;i++){
            if(degree[i]==1){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int cur = queue.poll();
            removed[cur] = true;

            for(int next: graph[cur]){
                if(!removed[next]){
                    // 자식이 꺼져 있다면 부모는 반드시 켜야 함
                    if(!on[cur]){
                        on[next] = true;
                    }

                    degree[next]--;

                    if(degree[next] == 1){
                        queue.offer(next);
                    }
                }
            }
        }
        int answer = 0;
        for(int i=1;i<=n;i++){
            if(on[i]){
                answer++;
            }
        }
        return answer;
    }
}