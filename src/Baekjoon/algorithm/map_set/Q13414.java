package Baekjoon.algorithm.map_set;

import java.io.*;
import java.util.*;

public class Q13414 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int K = Integer.parseInt(tokens[0]);
        int L = Integer.parseInt(tokens[1]);

        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<L;i++){
            String s = br.readLine();
            map.put(s,i);
        }

        /*for(String s : map.keySet()){
            System.out.println(s+" "+map.get(s));
        }*/

        List<String> list = new ArrayList<>(map.keySet());
        list.sort((a,b) -> map.get(a) - map.get(b));

        /*System.out.println("this is list");
        for(String s : list){
            System.out.println(s+" "+map.get(s));
        }*/

        int count = 0;
        for(String str: list){
            System.out.println(str);
            count++;
            if(count == K){
                break;
            }
        }
    }
}
