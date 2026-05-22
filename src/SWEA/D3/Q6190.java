package SWEA.D3;

import java.io.*;
import java.util.*;

public class Q6190 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            String[] tokens = br.readLine().split(" ");
            for(int i=0;i<N;i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            //TreeSet<Integer> set = new TreeSet<>();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<N;i++) {
                for(int j=i+1;j<N;j++) {
                    list.add(arr[i]*arr[j]);
                }
            }
            //Collections.sort(list,Collections.reverseOrder());
			/*for(int i:list) {
				System.out.print(i+" ");
			}*/
            // 단조 증가한다면
            int max = Integer.MIN_VALUE;
            for(int num:list) {
                if(isInc(num)) {
                    max = Math.max(max,num);
                    //System.out.print("num="+num);
                    //break;
                }
            }

            if(max == Integer.MIN_VALUE) {
                max = -1;
            }
            System.out.println("#"+test_case+" "+max);
        }
    }
    static boolean isInc(int num) {
        String str = String.valueOf(num);
        for(int i=0;i<str.length()-1;i++) {
            if(str.charAt(i)>str.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }
}
