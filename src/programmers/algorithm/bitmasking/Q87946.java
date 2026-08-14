package programmers.algorithm.bitmasking;

class Q87946 {
    static int N;
    static int[][] Dungeons;
    static int max;
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        Dungeons = dungeons;
        max = Integer.MIN_VALUE;

        boolean[] visited = new boolean[N];
        dfs(k,0,visited);

        return max;
    }

    static void dfs(int rest, int count, boolean[] visited){
        max = Math.max(count,max);

        for(int i=0;i<N;i++){
            int need = Dungeons[i][0];
            int use = Dungeons[i][1];

            if(!visited[i] && rest>=need){
                visited[i] = true;
                dfs(rest-use,count+1,visited);
            }
        }
    }
    /*
    static void dfs(int total, int count, int rest){
        if(total == N){
            max = Math.max(max,count);
            return;
        }

        for(int i=0;i<N;i++){
            int need = Dungeons[i][0];
            int use = Dungeons[i][1];

            if(rest>=need){
                // 포함
                dfs(total+1,count+1,rest-use);

                // 포함 x
                dfs(total+1,count,rest);
            }
        }
    }
    */
}