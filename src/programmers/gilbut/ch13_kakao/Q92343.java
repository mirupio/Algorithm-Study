package programmers.gilbut.ch13_kakao;

import java.util.*;

class Q92343 {
    static List<Integer>[] graph;
    static int n;
    static int max;
    static int[] Info;
    static boolean[] visited;
    static int Wolf, Sheep;
    public int solution(int[] info, int[][] edges) {
        n = info.length;
        max = Integer.MIN_VALUE;
        Info = info;
        visited = new boolean[n];

        graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge: edges){
            int parent = edge[0];
            int child = edge[1];

            graph[parent].add(child);
        }

        List<Integer> possible = new ArrayList<>();
        possible.addAll(graph[0]);

        dfs(1,0,possible);

        return max;
    }

    static void dfs(int sheep, int wolf, List<Integer> possible){
        max = Math.max(max,sheep);

        for(int i=0;i<possible.size();i++){
            int next = possible.get(i);
            int nextSheep = sheep;
            int nextWolf = wolf;

            if(Info[next] == 0){
                nextSheep++;
            }
            else{
                nextWolf++;
            }

            if(nextWolf < nextSheep){
                // 현재 선택한 노드 제거
                List<Integer> nextPossible = new ArrayList<>(possible);
                nextPossible.remove(i);

                // 선택한 노드의 자식들을 새로운 후보에 추가
                nextPossible.addAll(graph[next]);

                dfs(nextSheep,nextWolf,nextPossible);
            }


        }
    }
}