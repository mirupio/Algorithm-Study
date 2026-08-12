package programmers.algorithm.mst;

import java.util.*;

class Q42861 {

    static int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;

        // 간선 비용순으로 정렬
        Arrays.sort(costs,(a,b)-> a[2]-b[2]);

        parent = new int[n+1];
        for(int i=1;i<n+1;i++){
            parent[i] = i;
        }
        int totalCost = 0;
        int count = 0;
        for(int[] edge: costs){
            // 다른 그룹이면 합치기
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];
            if(find(from) != find(to)){
                union(from,to);
                totalCost += cost;
                count++;
            }
            if(count == n-1){
                answer = totalCost;
                break;
            }
        }

        return answer;
    }

    static int find(int x){
        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);


        parent[b] = a;
    }
}