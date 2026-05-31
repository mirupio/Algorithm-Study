package programmers.algorithm;

import java.util.*;

// 연결리스트
class Q81303_2 {
    class Solution {
        static class Node{
            int cur;
            int prev;
            int next;

            Node(int cur,int prev,int next){
                this.cur = cur;
                this.prev = prev;
                this.next = next;
            }
        }

        public String solution(int n, int k, String[] cmd) {

            int[] prev = new int[n];
            int[] next = new int[n];
            for(int i=0;i<n;i++){
                prev[i] = i-1;
                next[i] = i+1;
            }
            next[n-1] = -1;

            char[] answer = new char[n];
            Arrays.fill(answer,'O');

            Stack<Node> stack = new Stack<>();
            int now = k;

            for(String move : cmd){
                if(move.charAt(0) == 'D'){
                    int num = Integer.parseInt(move.substring(2));
                    while(num-->0){
                        now = next[now];
                    }
                }

                if(move.charAt(0) == 'U'){
                    int num = Integer.parseInt(move.substring(2));
                    while(num-->0){
                        now = prev[now];
                    }
                }

                if(move.charAt(0) == 'C'){
                    stack.push(new Node(now,prev[now],next[now]));
                    answer[now] = 'X';
                    // 이전 노드 - 다음 노드 새로 연결
                    if(prev[now] != -1){
                        next[prev[now]] = next[now];
                    }
                    if(next[now] != -1){
                        prev[next[now]] = prev[now];
                    }

                    // now 이동
                    if(next[now] != -1){
                        now = next[now];
                    }
                    else{
                        now = prev[now];
                    }
                }

                if(move.charAt(0) == 'Z'){
                    Node node = stack.pop();

                    int deleted = node.cur;

                    answer[deleted] = 'O';
                    if(node.prev != -1){
                        next[node.prev] = deleted;
                    }
                    if(node.next != -1){
                        prev[node.next] = deleted;
                    }

                }
            }

            return String.valueOf(answer);
        }
    }
}