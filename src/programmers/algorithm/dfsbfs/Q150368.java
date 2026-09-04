package programmers.algorithm.dfsbfs;

class Q150368 {
    static int[] discounts = {10,20,30,40};
    static int[] selected;

    static int maxCount = 0;
    static int maxPrice = 0;

    static int[][] Users;
    static int[] Emoticons;

    public int[] solution(int[][] users, int[] emoticons) {

        Users = users;
        Emoticons = emoticons;

        selected = new int[emoticons.length];

        dfs(0);

        return new int[]{maxCount,maxPrice};
    }

    static void dfs(int index){
        // 모든 이모티콘 할인율 결정
        if(index == Emoticons.length){
            calculate();
            return;
        }

        for(int discount: discounts){
            selected[index] = discount;
            dfs(index+1);
        }
    }

    static void calculate(){
        int count = 0;
        int totalPrice = 0;

        for(int[] user: Users){
            int percent = user[0];
            int limit = user[1];

            int price = 0;

            for(int i=0;i<Emoticons.length;i++){
                if(selected[i] >= percent){
                    price += Emoticons[i]*(100-selected[i])/100;
                }
            }

            if(price >= limit){
                count++;
            }
            else{
                totalPrice += price;
            }
        }

        if(count > maxCount){
            maxCount = count;
            maxPrice = totalPrice;
        }
        else if(count == maxCount && totalPrice > maxPrice){
            maxPrice = totalPrice;
        }
    }
}