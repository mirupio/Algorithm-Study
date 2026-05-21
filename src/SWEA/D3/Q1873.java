package SWEA.D3;

import java.io.*;
import java.util.*;

public class Q1873 {
    static char[][] arr;
    static int H,W;
    static int row,col;
    static char status;
    public static void main(String[] args) throws IOException{
        // System.setIn(new FileInputStream("src/ssafy/input (20).txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            arr = new char[H][W];
            for(int r=0;r<H;r++) {
                arr[r] = br.readLine().toCharArray();
            }

            outer:
            for(int r=0;r<H;r++) {
                for(int c=0;c<W;c++) {
                    if(arr[r][c] == '^' || arr[r][c] == 'v'
                            || arr[r][c] == '<' || arr[r][c] == '>' ) {
                        row = r;
                        col = c;
                        status = arr[r][c];
                        break outer;
                    }
                }
            }

            int N = Integer.parseInt(br.readLine());
            char[] input = new char[N];
            input = br.readLine().toCharArray();

            for(char c:input) {
                act(c);
            }

            System.out.print("#"+test_case+" ");
            for(int r=0;r<H;r++) {
                for(int c=0;c<W;c++) {
                    System.out.print(arr[r][c]);
                }
                System.out.println();
            }
        }
    }

    static void act(char ch) {
        if(ch == 'U') {
            status = '^';
            if(row-1>=0 && arr[row-1][col]=='.') {
                arr[row][col] = '.';
                row = row-1;
            }
            arr[row][col] = '^';
        }

        else if(ch == 'D') {
            status = 'v';
            if(row+1<H && arr[row+1][col]=='.') {
                arr[row][col] = '.';
                row = row+1;
            }
            arr[row][col] = 'v';
        }
        else if(ch == 'L') {
            status = '<';
            if(col-1>=0 && arr[row][col-1]=='.') {
                arr[row][col] = '.';
                col = col-1;
            }
            arr[row][col] = '<';
        }
        else if(ch == 'R') {
            status = '>';
            if(col+1<W && arr[row][col+1]=='.') {
                arr[row][col] = '.';
                col = col+1;
            }
            arr[row][col] = '>';
        }
        else if(ch == 'S') {
            shoot();
        }
    }

    static void shoot() {
        if(status == '^') {
            for(int r=row;r>=0;r--) {
                if(arr[r][col]=='*') {
                    arr[r][col] = '.';
                    break;
                }
                else if (arr[r][col] == '#') {
                    break;
                }
            }
        }

        else if(status == 'v') {
            for(int r=row;r<H;r++) {
                if(arr[r][col]=='*') {
                    arr[r][col] = '.';
                    break;
                }
                else if (arr[r][col] == '#') {
                    break;
                }
            }
        }

        else if(status == '<') {
            for(int c=col;c>=0;c--) {
                if(arr[row][c]=='*') {
                    arr[row][c] = '.';
                    break;
                }
                else if (arr[row][c] == '#') {
                    break;
                }
            }
        }

        else if(status == '>') {
            for(int c=col;c<W;c++) {
                if(arr[row][c]=='*') {
                    arr[row][c] = '.';
                    break;
                }
                else if (arr[row][c] == '#') {
                    break;
                }
            }
        }
    }
}
