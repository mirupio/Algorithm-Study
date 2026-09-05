package programmers.algorithm.mst;

import java.util.*;

class Q62050 {
    static int[][] group;
    static int[][] Land;
    static int N;
    static int H;

    static int[] dRow = {-1,1,0,0};
    static int[] dCol = {0,0,-1,1};

    static class Edge{
        int from;
        int to;
        int cost;

        Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static int[] parent;

    public int solution(int[][] land, int height) {
        int answer = 0;

        Land = land;
        N = land.length;
        H = height;

        group = new int[N][N];

        // dfs -> 공짜로 이동 가능한 칸끼리 구역 만들기
        int groupNum = 1;
        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){
                if(group[r][c] == 0){
                    dfs(r,c,groupNum);
                    groupNum++;
                }
            }
        }

        // 서로 다른 구역 맞닿으면 사다리 간선 만들기
        List<Edge> edges = new ArrayList<>();
        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){

                for(int i=0;i<4;i++){
                    int nr = r+dRow[i];
                    int nc = c+dCol[i];

                    if(nr>=0 && nr<N && nc>=0 && nc<N
                            && (group[r][c] != group[nr][nc])){
                        int cost = Math.abs(land[r][c] - land[nr][nc]);
                        edges.add(new Edge(group[r][c],group[nr][nc],cost));
                    }
                }
            }
        }

        // 사다리 비용 순 정렬
        edges.sort((a,b) -> a.cost-b.cost);

        // kruskal(union-find)로 싼 사다리부터 연결
        parent = new int[groupNum];
        for(int i=1;i<groupNum;i++){
            parent[i] = i;
        }

        for(Edge edge: edges){
            if(union(edge.from,edge.to)){
                answer += edge.cost;
            }
        }

        return answer;
    }

    static void dfs(int r, int c, int groupNum){
        group[r][c] = groupNum;

        for(int i=0;i<4;i++){
            int nr = r+dRow[i];
            int nc = c+dCol[i];

            if(nr>=0 && nr<N && nc>=0 && nc<N
                    && group[nr][nc]==0
                    && Math.abs(Land[r][c] - Land[nr][nc])<=H){
                dfs(nr,nc,groupNum);
            }
        }
    }

    static int find(int x){
        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b){
        a = find(a);
        b = find(b);

        // 이미 연결
        if(a==b){
            return false;
        }
        parent[b] = a;
        return true;
    }
}