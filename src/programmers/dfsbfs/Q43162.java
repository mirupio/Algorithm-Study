package programmers.dfsbfs;

import java.util.*;

class Q43162 {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[computers.length];

        int network = 0;
        for(int i=0;i<computers.length;i++){
            if(!visited[i]){
                dfs(computers,visited,i);
                network++;
            }
        }

        return network;
    }

    static void dfs(int[][] computers, boolean[] visited, int index){
        visited[index] = true;

        int[] computer = computers[index]; // [1,1,0]
        List<Integer> connect = new ArrayList<>();
        for(int i=0;i<computer.length;i++){
            if(computer[i] == 1){
                connect.add(i); // 0,1
            }
        }

        for(int next:connect){
            if(!visited[next]){
                dfs(computers,visited,next);
            }
        }
    }
}