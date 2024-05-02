class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            boolean flag = true;
            int idx = Integer.MIN_VALUE;
            for (int j = 0; j < skill.length(); j++) {
                int tmp = skill_trees[i].indexOf(skill.charAt(j));
                if ((idx == -1 && tmp > -1) || (tmp != -1 && idx > tmp)) {
                    flag = false;
                    break;
                }
                idx = tmp;
            }
            if (flag) answer++;
        }

        return answer;
    }
}