package programmers.algorithm.bruteforce;

class Q42842 {
    public int[] solution(int brown, int yellow) {
        for(int i=1;i<=yellow/i;i++){
            if(yellow%i == 0){
                int y_w = i;
                int y_h = yellow/i;

                int b = (y_w+2)*2+y_h*2;
                if(b==brown){
                    int b_w = Math.max(y_w+2,y_h+2);
                    int b_h = Math.min(y_w+2,y_h+2);
                    int[] answer = {b_w,b_h};

                    return answer;
                }
            }
        }
        return new int[2];
    }
}

/*
bbbb
byyb (2+2)*2+1*2=10
bbbb

bbb
byb (1+2)*2+1*2=8
bbb

bbbbbbbbbbbbbb
byyyyyyyyyyyyb (12+2)*2+2*2=32
byyyyyyyyyyyyb
bbbbbbbbbbbbbb

yyyyyyyy
yyyyyyyy (8+2)*2+3*2=26
yyyyyyyy

bbbbbbbb
byyyyyyb
byyyyyyb (6+2)*2+4*2=24
byyyyyyb
byyyyyyb
bbbbbbbb

bbbbbb
byyyyb
byyyyb
byyyyb (4+2)*2+6*2=24
byyyyb
byyyyb
byyyyb
bbbbbb

y -> 1,24 / 2,12 / 3,8 / 4,6
    i=1 ~ i<=y/i ; i++
*/
