import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;
        int answer = 0;
        List<String> list = new LinkedList<>();

        for (int i = 0; i < cities.length; i++) {
            String s = cities[i].toLowerCase();
            if (list.contains(s)) {
                list.remove(s);
                list.add(s);
                answer++;
            } else {
                if (list.size() != cacheSize) list.add(s);
                else {
                    list.remove(0);
                    list.add(s);
                }
                answer += 5;
            }
        }

        return answer;
    }
}