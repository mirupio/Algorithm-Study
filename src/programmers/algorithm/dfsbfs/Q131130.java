package programmers.algorithm.dfsbfs;

class Q131130 {
    static int[] Cards;
    static boolean[] visited;
    static int first,second;
    public int solution(int[] cards) {
        int answer = 0;
        Cards = cards;

        int Max = 0;
        for(int i=0;i<Cards.length;i++){
            visited = new boolean[cards.length];
            first = 0;
            dfs(i,0,1);
            //System.out.println("first="+first);
            second = 0;
            for(int j=0;j<Cards.length;j++){
                if(!visited[j]){
                    dfs(j,0,2);
                }
            }
            //System.out.println("second="+second);
            Max = Math.max(Max,first*second);
        }

        return Max;
    }

    static void dfs(int now,int count,int i){
        //System.out.println("now="+now+" count="+count);
        visited[now] = true;
        count++;
        if(i==1){
            first=count;
        }
        else{
            second=Math.max(second,count);
        }

        int next = Cards[now]-1;
        if(!visited[next]){
            dfs(next,count,i);
        }
    }
}