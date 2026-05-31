package programmers.algorithm;

import java.util.*;

// 틀린 답안 -> 시간 초과
class Q81303 {
    public String solution(int n, int k, String[] cmd) {

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = i;
        }
        Stack<Integer> stack = new Stack<>();
        int now = k;

        for(String move : cmd){
            if(move.charAt(0) == 'D'){
                int num = Integer.parseInt(move.substring(2));
                while(num>0){
                    now++;
                    if(arr[now] != Integer.MIN_VALUE){
                        num--;
                    }
                }
            }

            if(move.charAt(0) == 'U'){
                int num = Integer.parseInt(move.substring(2));
                while(num>0){
                    now--;
                    if(arr[now] != Integer.MIN_VALUE){
                        num--;
                    }
                }
            }

            if(move.charAt(0) == 'C'){
                arr[now] = Integer.MIN_VALUE;
                stack.push(now);
                int num = 1;
                while(num>0){
                    if(now >= n-1){
                        break;
                    }
                    now++;
                    if(arr[now] != Integer.MIN_VALUE){
                        num--;
                    }
                }
                while(num>0){
                    now--;
                    if(arr[now] != Integer.MIN_VALUE){
                        num--;
                    }
                }
            }

            if(move.charAt(0) == 'Z'){
                int rec = stack.pop();
                arr[rec] = rec;
            }

            /*
            System.out.println("now="+now);
            for(int i:arr){
                System.out.print(i+" ");
            }
            System.out.println();
            */
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            if(arr[i] != Integer.MIN_VALUE){
                sb.append('O');
            }
            else{
                sb.append('X');
            }
        }
        String answer = sb.toString();
        return answer;
    }
}