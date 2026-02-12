package programmers.bruteforce;

class Q84512 {
    static int count = 0;
    static int answer = 0;
    static char[] vowel = {'A','E','I','O','U'};
    public int solution(String word) {
        dfs("",word);
        return answer;
    }

    static void dfs(String cur,String word){
        if(!cur.equals("")){
            count++;
            if(cur.equals(word)){
                answer = count;
                return;
            }
        }

        if(cur.length() == 5){
            return;
        }

        for(char c :vowel){
            String next = cur+c;
            dfs(next,word);
        }
        return;
    }
}

/*
A AA AAA AAAA
AAAAA AAAAE AAAAI AAAAO AAAAU
AAAE AAAEA AAAEE AAAEI AAAEO AAAEU
브루트포스(dfs)로 사전순으로 만들면서 index++
word랑 같으면 반환
*/