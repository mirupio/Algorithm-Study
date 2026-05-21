package SWEA.D3;

import java.io.*;
import java.util.*;

public class Q1240 {
    static String[] strs = {"0001101","0011001","0010011","0111101","0100011",
            "0110001","0101111","0111011","0110111","0001011"};
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("src/ssafy/input (21).txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] num = new int[8];
            boolean stop = false;
            for(int i=0;i<N;i++) {
                String str = br.readLine();
                if(str.contains("1") && !stop){
                    int end = str.lastIndexOf('1');
                    String code = str.substring(end-55,end+1);
                    int idx = 0;
                    for(int j=0;j<56;j++) {
                        //System.out.println("j="+j);
                        String substr = code.substring(j,j+7);
                        for(int s=0;s<strs.length;s++) {
                            if(strs[s].equals(substr)) {
                                //System.out.println(substr);
                                num[idx++]=s;
                                j+=6;
                                break;
                            }
                        }
                    }
                    stop = true;
                }
            }
			/*
			for(int i=0;i<num.length;i++) {
				System.out.println(num[i]);
			}*/
            System.out.println("#"+test_case+" "+check(num));
        }
    }
    static int check(int[] num) {
        int sum_e = 0;
        int sum_o = 0;
        for(int i=0;i<8;i++) {
            if(i%2 == 0) {
                sum_e += num[i];
            }
            else {
                sum_o += num[i];
            }
        }
        //System.out.println("sum_o"+sum_o);
        //System.out.println("sum_e"+sum_e);

        if((sum_e*3+sum_o)%10 == 0) {

            return sum_o+sum_e;
        }
        else {
            return 0;
        }
    }
}
