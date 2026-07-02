package programmers.gilbut.ch14_PCCP;

class Q121689 {
    public int solution(int[] menu, int[] order, int k) {
        int[] arr = new int[1000000];
        int before = 0;
        for(int i=0;i<order.length;i++){
            int start = k*i;
            int end = Math.max(before,start) + menu[order[i]];
            before = end;
            for(int j=start;j<end;j++){
                arr[j] += 1;
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i:arr){
            //System.out.print(i);
            max = Math.max(max,i);
        }
        return max;
    }
}