package programmers.gilbut.ch12_implementation;

class Q67256 {
    public String solution(int[] numbers, String hand) {
        String answer = "";

        int curL = 10;
        int curR = 12;
        for(int n : numbers){
            if(n == 0){
                n = 11;
            }
            if(n==1 || n==4 || n==7){
                answer += "L";
                curL = n;
            }

            else if(n==3 || n==6 || n==9){
                answer += "R";
                curR = n;
            }

            else{
                if(distance(curL,n) < distance(curR,n)){
                    answer += "L";
                    curL = n;
                }
                else if(distance(curL,n) > distance(curR,n)){
                    answer += "R";
                    curR = n;
                }
                else {
                    if(hand.equals("left")){
                        answer += "L";
                        curL = n;
                    }
                    else{
                        answer += "R";
                        curR = n;
                    }
                }
            }
        }


        return answer;
    }

    private int distance(int num1, int num2){
        int row1 = (num1-1)/3;
        int col1 = (num1-1)%3;

        int row2 = (num2-1)/3;
        int col2 = (num2-1)%3;

        return Math.abs(row1-row2) + Math.abs(col1-col2);
    }
}