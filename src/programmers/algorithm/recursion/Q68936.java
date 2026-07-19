package programmers.algorithm.recursion;

class Q68936 {
    static int count_0 = 0;
    static int count_1 = 0;
    static int[][] array;
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];

        array = arr;

        quad(array.length,0,0);

        answer[0] = count_0;
        answer[1] = count_1;

        return answer;
    }

    static void quad(int n,int r,int c){
        // System.out.println("quad "+"n="+n+" r="+r+" c="+c);

        if(n>=2){
            int num = array[r+n-1][c+n-1];
            boolean same = true;
            outer:
            for(int i=r;i<r+n;i++){
                for(int j=c;j<c+n;j++){
                    if(num != array[i][j]){
                        same = false;
                        break outer;
                    }
                }
            }

            // 압축 x = 자르기
            if(same == false){
                quad(n/2,r,c);
                quad(n/2,r+n/2,c);
                quad(n/2,r,c+n/2);
                quad(n/2,r+n/2,c+n/2);
            }
            // 압축 = 개수 확정
            else{
                if(num == 0){
                    count_0++;
                    // System.out.println("count_0++ "+count_0);
                }
                else{
                    count_1++;
                    // System.out.println("count_1++ "+count_1);
                }
            }
        }

        else{
            if(array[r][c] == 0){
                count_0++;
                // System.out.println("바깥count_0++ "+count_0);
            }
            else{
                count_1++;
                // System.out.println("바깥count_1++ "+count_1);
            }
        }
    }
}