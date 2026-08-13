package programmers.algorithm.toposort;

import java.util.*;

class Q86971 {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int[] count = new int[n+1];
        Arrays.fill(count,1);

        List<Integer>[] graph = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }

        int[] degree = new int[n+1];

        for(int[] wire: wires){
            int from = wire[0];
            int to = wire[1];

            graph[from].add(to);
            graph[to].add(from);

            degree[from]++;
            degree[to]++;
        }

        boolean[] removed = new boolean[n+1];

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<degree.length;i++){
            if(degree[i] == 1){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int cur = queue.poll();

            answer = Math.min(answer,Math.abs(count[cur]-(n-count[cur])));
            for(int next: graph[cur]){
                if(!removed[next]){
                    degree[next]--;
                    count[next] += count[cur];
                    removed[cur] = true;

                    if(degree[next] == 1){
                        queue.offer(next);
                    }
                }
            }
        }

        return answer;
    }

}