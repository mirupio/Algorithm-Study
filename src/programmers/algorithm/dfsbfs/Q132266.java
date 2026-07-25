package programmers.algorithm.dfsbfs;

import java.util.*;

class Q132266 {
    static Queue<Integer> q;
    static int[] distance;
    static int des;
    static List<Integer>[] graph;
    static int ans;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];

        graph = new ArrayList[n+1];
        for(int i=1;i<n+1;i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] road: roads){
            int from = road[0];
            int to = road[1];

            graph[from].add(to);
            graph[to].add(from);
        }

        q = new LinkedList<>();
        distance = new int[n+1];
        Arrays.fill(distance,-1);

        q.offer(destination);
        distance[destination] = 0;

        bfs();

        for(int i=0;i<sources.length;i++){
            answer[i] = distance[sources[i]];
        }

        return answer;
    }

    static void bfs(){
        while(!q.isEmpty()){
            int now = q.poll();

            for(int next:graph[now]){
                if(distance[next]==-1){
                    distance[next] = distance[now]+1;
                    q.offer(next);
                }
            }
        }
    }
}