package programmers.algorithm;

class Q68646 {
    public int solution(int[] a) {
        int answer = 2;

        // 0~i까지 원소 중 최소
        int[] arr = new int[a.length];
        int min = Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++){
            if(a[i] < min){
                min = a[i];
            }
            arr[i] = min;
        }
        /*
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        */

        // 맨 마지막~i까지 원소 중 최소
        int[] arrReverse = new int[a.length];
        min = Integer.MAX_VALUE;
        for(int i=a.length-1;i>=0;i--){
            if(a[i] < min){
                min = a[i];
            }
            arrReverse[i] = min;
        }
        /*
        for(int i:arrReverse){
            System.out.print(i+" ");
        }
        System.out.println();
        */

        for(int i=1;i<a.length-1;i++){
            if(arr[i-1]>a[i] || arrReverse[i+1]>a[i]){
                /*
                System.out.println("arr"+(i-1)+"="+arr[i-1]
                                   +" arr"+i+"="+arr[i]
                                   +" arrReverse"+(i+1)+"="+arrReverse[i+1]);
                                   */
                answer++;
            }
        }

        return answer;
    }

}