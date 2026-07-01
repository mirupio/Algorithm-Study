package programmers.gilbut.ch14_PCCP;

class Q121685 {

    public String find(int n, int p){
        if(n == 1){
            return "Rr";
        }

        int parent = (p-1)/4 + 1;
        int child = (p-1)%4;

        String parentGene = find(n-1,parent);

        if(parentGene.equals("RR")){
            return "RR";
        }
        if(parentGene.equals("rr")){
            return "rr";
        }
        if(child == 0){
            return "RR";
        }
        if(child == 3){
            return "rr";
        }
        return "Rr";
    }
    public String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];

        for(int i=0;i<queries.length;i++){
            int n = queries[i][0]; //세대
            int p = queries[i][1]; //개체

            answer[i] = find(n,p);
        }

        return answer;
    }
}