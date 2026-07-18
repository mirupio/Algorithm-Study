package programmers.algorithm.stackqueue;

import java.util.*;

class Q131704 {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=order.length;i++){
            queue.add(i);
        }

        int count = 0;
        for(int i=0;i<order.length;i++){
            int o = order[i]; // 4
            // System.out.println("o="+o);
            if(!queue.isEmpty()){
                int q = queue.peek(); // 1
                // System.out.println("q="+q);
                while(o>q){
                    // System.out.print("o>q->");
                    stack.push(q); // 1 2 3
                    queue.poll();
                    q = queue.peek(); // 3
                    // System.out.println("q="+q);
                }
            }

            /*
            for(int n:stack){
                System.out.print(n+" ");
            }
            System.out.println();
            for(int n:queue){
                System.out.print(n+" ");
            }
            System.out.println();
            */

            if(!stack.isEmpty() && stack.peek()==o){
                count++;
                stack.pop();
                // System.out.println("count1");
            }
            else if(!queue.isEmpty() && queue.peek()==o){
                count++;
                queue.poll();
                // System.out.println("count2");
            }
            else{
                break;
            }
        }

        return count;
    }
}