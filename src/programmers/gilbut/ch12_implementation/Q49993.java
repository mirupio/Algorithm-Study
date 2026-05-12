package programmers.gilbut.ch12_implementation;

class Q49993 {
    public int solution(String skill, String[] skill_trees) {

        int count = 0;
        for(int i=0;i<skill_trees.length;i++){
            String s = skill_trees[i]; // AECB

            int num=0;
            char cur_skill = skill.charAt(num);
            boolean pass = true;
            for(int j=0;j<s.length();j++){
                if(skill.contains(s.substring(j,j+1))){
                    if(s.charAt(j)==cur_skill){
                        if(num+1<skill.length()){
                            num++;
                            cur_skill = skill.charAt(num);
                        }
                        else{
                            break;
                        }
                    }
                    else{
                        pass = false;
                        break;
                    }
                }
            }
            if(pass){
                count++;
            }
        }


        return count;
    }
}