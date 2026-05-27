package programmers.algorithm.dfsbfs;

// 틀린 답안 -> 시간 초과
class Q150365 {
    static int[][] arr;
    // 상, 하, 좌, 우
    static int[] dRow = {1,0,0,-1};
    static int[] dCol = {0,-1,1,0};
    static char[] dDir = {'u','d','l','r'};
    static int N,M,R,C,K;
    static String min;
    public String solution(int n, int m, int x, int y, int r, int c, int k)     {
        String answer = "";

        arr = new int[n][m];
        N = n;
        M = m;
        R = r;
        C = c;
        K = k;

        // 시작 : x,y -> 도착 : r,c
        min = "z";
        dfs(0,x-1,y-1,"");

        if(min.equals("z")){
            answer = "impossible";
        }
        else{
            answer = min;
        }

        return answer;
    }

    static void dfs(int dis, int row, int col, String dir){
        System.out.println("dis="+dis+" row="+row+" col="+col+" dir="+dir);

        if(dis == K){
            if(row == R-1 && col == C-1){
                min = dic(dir,min);
                System.out.println("add: "+row+","+col+" dis="+dis+" min="+min);
            }
            return;
        }

        for(int i=0;i<4;i++){
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];
            String nDir = dir + dDir[i];
            if(nRow>=0 && nRow<N && nCol>=0 && nCol<M
                    && (nDir.equals(dic(nDir,min)))){
                dfs(dis+1,nRow,nCol,nDir);
            }
        }
    }

    static String dic(String str, String str2){
        /*
        List<String> strs = new ArrayList<>();
        strs.add(min);
        strs.add(str);
        Collections.sort(strs);

        //System.out.println("사전순:"+strs.get(0));
        return strs.get(0);
        */
        for(int i=0;i<Math.min(str2.length(),str.length());i++){
            //System.out.println("i="+i);
            if(str2.charAt(i) > str.charAt(i)){
                return str;
            }
            else if (str2.charAt(i) < str.charAt(i)){
                return str2;
            }
        }
        return str2;
    }
}