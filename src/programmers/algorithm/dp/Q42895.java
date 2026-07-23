package programmers.algorithm.dp;

import java.util.*;

class Q42895 {
    public int solution(int N, int number) {
        int answer = -1;

        // dp[i] = N을 i개 사용해서 만들 수 있는 모든 숫자 집합, i<=8
        Set<Integer>[] dp = new HashSet[9];

        for(int i=0;i<=8;i++){
            dp[i] = new HashSet<>();
        }

        dp[1].add(N);
        if(dp[1].contains(number)){
            answer = 1;
            return answer;
        }

        dp[2].add(N+N);
        dp[2].add(N-N);
        dp[2].add(N/N);
        dp[2].add(N*N);
        dp[2].add(N*10+N);
        if(dp[2].contains(number)){
            answer = 2;
            return answer;
        }

        for(int i=3;i<=8;i++){
            for(int j=1;j<i;j++){
                for(int num1:dp[j]){
                    for(int num2:dp[i-j]){
                        dp[i].add(num1+num2);
                        dp[i].add(num1-num2);
                        dp[i].add(num1*num2);
                        if(num2!=0){
                            dp[i].add(num1/num2);
                        }
                    }
                }
            }
            int num = N;
            for(int j=1;j<=i-1;j++){
                num = num*10+N;
            }
            dp[i].add(num);

            if(dp[i].contains(number)){
                answer = i;
                break;
            }
        }

        return answer;
    }
}