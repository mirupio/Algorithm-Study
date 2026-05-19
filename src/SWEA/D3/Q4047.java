package SWEA.D3;

import java.io.*;
import java.util.*;

class Q4047
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            boolean isError = false;
            HashMap<Character,Set<Integer>> map = new HashMap<>();
            for(char c: new char[]{'S', 'D', 'H', 'C'}){
                map.putIfAbsent(c,new HashSet<>());
            }
            String S = br.readLine();
            for(int i=0;i<S.length();i+=3) {
                char c = S.charAt(i);
                int num = Integer.parseInt(S.substring(i + 1, i + 3));
                // System.out.println(num);
                if (map.get(c).contains(num)) {
                    isError = true;
                    break;
                } else {
                    map.get(c).add(num);
                }
            }
            System.out.print("#"+test_case+" ");
            if(isError){
                System.out.println("ERROR");
            }
            else{
                for(char c: new char[]{'S', 'D', 'H', 'C'}){
                    System.out.print(13-map.get(c).size()+" ");
                }
                System.out.println();
            }
        }
    }
}