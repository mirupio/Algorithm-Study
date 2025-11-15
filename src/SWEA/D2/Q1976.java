package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1976 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int h_s = Integer.parseInt(st.nextToken());
            int m_s = Integer.parseInt(st.nextToken());
            int h_e = Integer.parseInt(st.nextToken());
            int m_e = Integer.parseInt(st.nextToken());

            int h_sum = 0;
            int m_sum = 0;

            m_sum = m_s+m_e;
            h_sum += m_sum/60;
            m_sum = m_sum%60;

            h_sum += h_s+h_e;
            if(h_sum >12){
                h_sum -= 12;
            }

            System.out.println("#"+t+" "+h_sum+" "+m_sum);
        }

    }
}
