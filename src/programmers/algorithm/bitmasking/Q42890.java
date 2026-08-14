package programmers.algorithm.bitmasking;

import java.util.*;

class Q42890 {
    static int row,col;
    static String[][] Relation;
    static Set<Integer> set;
    public int solution(String[][] relation) {
        row = relation.length;
        col = relation[0].length;
        Relation = relation;

        int candidateCount = 0;
        // 부분 집합 전체 구하기
        for(int mask=1;mask<(1<<col);mask++){
            // 후보키가 유일성 만족하면
            boolean isMin = true;
            if(isOnly(mask)){
                // System.out.println(mask+" 최소성 검사");
                // 최소성 만족하는지 확인
                // 후보키 1인 애들 중 하나씩 0으로 만들기
                /*
                for(int i=1;i<mask;i++){
                    if(!isOnly(i)){
                        System.out.println(i+" 최소성 만족 x");
                        isMin = false;
                        break;
                    }
                }
                */
                set = new HashSet<>();
                dfs(0,mask);
                set.remove(0);
                /*
                for(int i:set){
                    System.out.print(i+" ");
                }
                System.out.println();
                */
                for(int i:set){
                    if(isOnly(i)){
                        // System.out.println(i+ " 최소성 만족 x");
                        isMin = false;
                        break;
                    }
                }

            }
            else{
                isMin = false;
            }

            if(isMin){
                // System.out.println(mask+" 유일성 만족 o");
                candidateCount++;
            }
        }

        return candidateCount;
    }

    // 1인 애들 하나씩 끄는 부분집합 만들기
    static void dfs(int total, int masks){
        for(int i=0;i<col;i++){
            // 켜져 있으면 끄기
            if((masks & (1<<i)) != 0){
                masks &= ~(1<<i); // 끄기
                // System.out.println(i+ " 끔 -> "+masks);
                set.add(masks);
                dfs(total+1, masks);
                masks |= (1<<i); // 켜기
            }
        }
    }

    // 유일성 만족하는지
    static boolean isOnly(int masks){
        Set<String> set = new HashSet<>();
        for(int i=0;i<row;i++){
            String str = "";
            for(int j=0;j<col;j++){
                if((masks & (1<<j)) != 0){
                    str += Relation[i][j];
                }
            }
            set.add(str);
        }
        // 같은게 하나라도 나오면 유일성 만족 x
        if(set.size()!=row){
            // System.out.println("유일성 만족 x");
            return false;
        }
        return true;
    }
}