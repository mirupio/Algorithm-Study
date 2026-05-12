package programmers.gilbut;

// 틀린 답안 -> 시간 초과
class Q42883 {
    public String solution(String number, int k) {
        String answer = "";

        // 4177252841
        while(k > 0){
            outer:
            for(int i=1;i<number.length();i++){
                for(int j=i-1;j>=0;j--){
                    if(number.charAt(i) != ' ' && number.charAt(j) != ' '){
                        if(number.charAt(i)>number.charAt(j)){ // 뒤 > 앞
                            // 앞 제거하고 다시 만들기
                            number = number.substring(0, j) + " " + number.substring(j + 1);
                            k--;
                            if(k==0){
                                break outer;
                            }
                        }
                    }
                }
            }

            if(k>0){
                number = number.substring(0,number.length()-k);
                k=0;
            }
        }

        answer = number.replace(" ","");

        return answer;
    }
}

/*
0123456789
-----------
4177252841
4 77252841
  77252841
  77 52841
*/