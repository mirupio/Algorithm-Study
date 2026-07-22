package programmers.algorithm.string;

import java.util.*;

class Q17686 {
    public String[] solution(String[] files) {

        // 나누기 : 문자~숫자가 나오기 전 / 숫자~문자 나오기 전 or 숫자5개 / 문자~끝 or 숫자~끝

        Arrays.sort(files,(a,b) -> {
            int[] aDivide = divide(a);
            int[] bDivide = divide(b);

            String aHead = a.substring(0,aDivide[0]).toLowerCase();
            int aNum = Integer.parseInt(a.substring(aDivide[0],aDivide[1]));

            String bHead = b.substring(0,bDivide[0]).toLowerCase();
            int bNum = Integer.parseInt(b.substring(bDivide[0],bDivide[1]));

            int cmp = aHead.compareTo(bHead);
            if(cmp != 0){
                return cmp;
            }

            cmp= aNum-bNum;
            return cmp;
        });

        return files;
    }

    static int[] divide(String s){
        int nStart = -1;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                nStart = i;
                break;
            }
        }

        int tStart = nStart;
        while(tStart<s.length()
                && tStart<nStart+5
                && Character.isDigit(s.charAt(tStart))){
            tStart++;
        }
        return new int[]{nStart,tStart};
    }
}