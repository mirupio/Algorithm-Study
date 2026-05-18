package SWEA.D3;

import java.io.*;

class Q3499
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());
            String[] tokens = br.readLine().split(" ");

            StringBuilder sb = new StringBuilder("#");
            sb.append(test_case);
            sb.append(" ");
            if(tokens.length%2 == 0){
                for(int i=0;i<tokens.length/2;i++){
                    sb.append(tokens[i]);
                    sb.append(" ");
                    sb.append(tokens[i+tokens.length/2]);
                    sb.append(" ");
                }
            }
            else{
                for(int i=0;i<tokens.length/2;i++){
                    sb.append(tokens[i]);
                    sb.append(" ");
                    sb.append(tokens[i+tokens.length/2+1]);
                    sb.append(" ");
                }
                sb.append(tokens[tokens.length/2]);
            }
            System.out.println(sb);
        }
    }
}