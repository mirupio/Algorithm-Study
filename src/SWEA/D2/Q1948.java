package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1948 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        /*int[] sum = new int[12];
        sum[0] = days[0];
        for(int i=1;i<12;i++){
            sum[i] += sum[i-1] + days[i];
        }
*/
        for(int t=1;t<=T;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m_s = Integer.parseInt(st.nextToken());
            int d_s = Integer.parseInt(st.nextToken());
            int m_e = Integer.parseInt(st.nextToken());
            int d_e = Integer.parseInt(st.nextToken());

            int sum=0;
            for(int i=m_s;i<m_e;i++){
                sum += days[i-1];
            }
            int result = sum + d_e - d_s +1;
            System.out.println("#"+t+" "+result);
        }

    }
}
