package programmers.bruteforce;

class Q87946 {
    static boolean[] visited;
    static int max;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        max = 0;
        for(int i=0;i<dungeons.length;i++){
            dfs(i,dungeons,k,0);
        }

        return max;
    }

    static void dfs(int now, int[][] dungeons,int cur,int count){
        for(int i=0;i<dungeons.length;i++){
            if(!visited[i]){
                int need = dungeons[i][0];
                int use = dungeons[i][1];

                if(cur>=need){
                    visited[i] = true;
                    int result = cur-use;
                    max = Math.max(count+1,max);
                    dfs(i,dungeons,result,count+1);
                    visited[i] = false;
                }

            }
        }
    }
}