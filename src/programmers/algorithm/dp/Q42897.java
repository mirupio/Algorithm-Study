package programmers.algorithm.dp;

class Q42897 {
    public int solution(int[] money) {
        int answer = 0;
        int n = money.length;

        // 첫번째 선택할 경우 -> 마지막 선택 못함
        int[] dp1 = new int[n+1];
        dp1[1] = money[0];
        dp1[2] = dp1[1];
        for(int i=3;i<n;i++){
            int o = dp1[i-2]+money[i-1]; // 해당 원소 선택 o
            int x = dp1[i-1]; // 해당 원소 선택 x
            dp1[i] = Math.max(o,x);
        }
        dp1[n] = dp1[n-1];

        /*
        for(int i:dp1){
            System.out.print(i+" ");
        }
        System.out.println();
        */

        // 첫번째 선택하지 않을 경우 -> 마지막 선택 가능
        int[] dp2 = new int[n+1];
        for(int i=2;i<n+1;i++){
            int o = dp2[i-2]+money[i-1]; // 해당 원소 선택 o
            int x = dp2[i-1]; // 해당 원소 선택 x
            dp2[i] = Math.max(o,x);
        }

        /*
        for(int i:dp2){
            System.out.print(i+" ");
        }
        */

        // System.out.println("dp1="+dp1[n]+"dp2="+dp2[n]);
        answer = Math.max(dp1[n],dp2[n]);

        return answer;
    }
}