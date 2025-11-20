package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q1244_2 {
    static int change;
    static int max;
    static String s;
    static HashSet<String>[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s = st.nextToken();
            change = Integer.parseInt(st.nextToken());

            // 초기화
            max = 0;
            visited = new HashSet[change];
            for(int i=0;i<change;i++) {
                visited[i] = new HashSet<String>();
            }
            dfs(s, 0);
            System.out.println("#"+t+" " +max);
        }
    }

    static void dfs(String num,int count){
        if (count == change) {
            max = Math.max(max,Integer.parseInt(num));
            return;
        }

        // Bruteforce
        for (int i = 0; i < s.length(); i++) {
            for(int j=i+1;j<s.length();j++) {
                // 바꾸기
                char[] str = num.toCharArray();
                char temp = str[i];
                str[i] = str[j];
                str[j] = temp;
                StringBuilder sb = new StringBuilder();
                for(char n:str){
                    sb.append(n);
                }
                String num2 = sb.toString();
                // System.out.println("num2 = " + num2);

                // set -> 중복 제거
                if(!visited[count].contains(num2)) {
                    visited[count].add(num2);
                    dfs(num2,count+1);
                }
            }
        }
    }
}
