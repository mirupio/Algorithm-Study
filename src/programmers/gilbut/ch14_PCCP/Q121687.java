package programmers.gilbut.ch14_PCCP;

class Q121687 {
    // 위, 오, 아래, 왼
    static int[] dRow = {1,0,-1,0};
    static int[] dCol = {0,1,0,-1};
    public int[] solution(String command) {
        int[] answer = new int[2];

        int direct = 0;
        int x = 0;
        int y = 0;
        for(char c: command.toCharArray()){
            //System.out.println("direct="+direct+" x="+x+" y="+y);
            if(c=='R'){
                direct++;
                direct %= 4;
            }
            else if(c=='L'){
                direct--;
                direct += 4;
                direct %= 4;
            }
            else if(c=='G'){
                y += dRow[direct];
                x += dCol[direct];
            }
            else{
                y -= dRow[direct];
                x -= dCol[direct];
            }
        }

        answer[0] = x;
        answer[1] = y;

        return answer;
    }
}