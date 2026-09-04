package programmers.algorithm.map_set;

import java.util.*;

// 오답
class Q17683 {
    public String solution(String m, String[] musicinfos) {
        String answer = "";

        String[][] Musicinfos = new String[musicinfos.length][3];
        for(int i=0;i<musicinfos.length;i++){
            String[] tokens = musicinfos[i].split(",");

            // 재생시간으로 바꿔서 저장
            int start = Integer.parseInt(tokens[0].substring(0,2))*60+Integer.parseInt(tokens[0].substring(3));
            int end = Integer.parseInt(tokens[1].substring(0,2))*60+Integer.parseInt(tokens[1].substring(3));
            int time = end-start;
            Musicinfos[i][0] = String.valueOf(time); // 재생시간
            Musicinfos[i][1] = tokens[2]; // 제목
            Musicinfos[i][2] = tokens[3]; // 악보
        }

        // 재생시간 긴 순으로 정렬
        Arrays.sort(Musicinfos, (a,b) -> Integer.parseInt(b[0])-Integer.parseInt(a[0]));

        for(int i=0;i<Musicinfos.length;i++){
            System.out.println("재생시간="+Musicinfos[i][0]+" 제목="+Musicinfos[i][1]+" 악보="+Musicinfos[i][2]);
        }


        outer:
        for(String[] Musicinfo: Musicinfos){
            String str = "";
            for(int i=0;i<Integer.parseInt(Musicinfo[0]);i++){ // 0~13
                // # 개수
                int count = 0;
                for(int j=0;j<Musicinfo[2].length();j++){
                    if(Musicinfo[2].charAt(j)=='#'){
                        count++;
                    }
                }

                String[] melody = new String[Musicinfo[2].length()-count];
                int k=0;
                for(int j=0;j<Musicinfo[2].length();j++){
                    if(Musicinfo[2].charAt(j)!='#'){
                        melody[k] = String.valueOf(Musicinfo[2].charAt(j));
                    }
                    else{
                        melody[k-1] += String.valueOf(Musicinfo[2].charAt(j));
                        k--;
                    }
                    k++;
                }

                str += melody[i%(Musicinfo[2].length()-count)];

            }
            System.out.println("str="+str);

            if(str.contains(m)){
                answer = Musicinfo[1];
                break outer;
            }
        }


        return answer;

    }
}