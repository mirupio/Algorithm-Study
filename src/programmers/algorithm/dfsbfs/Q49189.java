package programmers.algorithm.dfsbfs;

import java.util.*;

class Q49189 {
    static int[] distance;
    static List<Integer>[] graph;
    static Queue<Integer> queue;
    public int solution(int n, int[][] edges) {
        int answer = 0;

        graph = new ArrayList[n+1];
        for(int i=1;i<n+1;i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];

            graph[a].add(b);
            graph[b].add(a);
        }

        distance = new int[n+1];
        Arrays.fill(distance,-1);
        queue = new LinkedList<>();

        queue.offer(1);
        distance[1] = 0;

        bfs();

        int max = Integer.MIN_VALUE;
        int count = 0;
        for(int i=1;i<n+1;i++){
            if(max < distance[i]){
                max = distance[i];
                count = 1;
            }
            else if(max==distance[i]){
                count++;
            }
        }

        return count;
    }

    static void bfs(){
        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int next: graph[cur]){
                if(distance[next] == -1){
                    distance[next] = distance[cur]+1;
                    queue.offer(next);
                }
            }
        }
    }
}