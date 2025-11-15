package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1946 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            String str = "";
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                char alphabet = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                // str += String.valueOf(alphabet).repeat(num);
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<num;j++){
                    sb.append(alphabet);
                }
                str += sb.toString(); // 이어붙이기
            }

            System.out.println("#"+t);
            // 10개씩 출력하기
            for (int j = 0; j < str.length(); j += 10) {
                int end = Math.min(j+10, str.length());
                System.out.println(str.substring(j, end));
            }
        }
    }
}
