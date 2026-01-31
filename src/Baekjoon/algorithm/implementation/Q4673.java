package Baekjoon.algorithm.implementation;

import java.util.*;

public class Q4673 {
    public static void main(String[] args) {
        // 생성자가 없는 숫자 = 어떤 숫자로 본인이 만들어지지 않아야함
        // 전체 - 생성되면 없애기
        // 1 -> 1+1=2
        // 11 -> 11+1+1
        // 초기화
        Set<Integer> set = new TreeSet<>();
        for(int i=1;i<=10000;i++){
            set.add(i);
        }

        for(int i=1;i<10000;i++){
            int n = i;
            int num = n;
            while(n>0){
                num += n%10;
                n /= 10;
            }
            if(set.contains(num)){
                set.remove(num);
            }
        }

        for(Integer i:set){
            System.out.println(i);
        }
    }
}
