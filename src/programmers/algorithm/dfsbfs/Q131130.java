package programmers.algorithm.dfsbfs;

class Q131130 {
    static int[] Cards;
    static boolean[] visited;

    public int solution(int[] cards) {
        int answer = 0;
        Cards = cards;

        int firstMax = 0;
        int secondMax = 0;
        visited = new boolean[cards.length];
        for(int i=0;i<Cards.length;i++){
            if(!visited[i]){
                int size = dfs(i);

                if(size>firstMax){
                    secondMax = firstMax;
                    firstMax = size;
                }
                else if(size>secondMax){
                    secondMax = size;
                }
            }
        }

        return firstMax*secondMax;
    }

    static int dfs(int now){
        visited[now] = true;

        int next = Cards[now]-1;

        if(!visited[next]){
            return 1+dfs(next);
        }

        return 1;
    }
}