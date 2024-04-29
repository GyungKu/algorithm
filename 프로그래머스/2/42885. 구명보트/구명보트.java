import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int p1 = 0, p2 = people.length - 1;
        Arrays.sort(people);
        
        while (p1 <= p2) {
            if (people[p1] + people[p2] <= limit) {
                p1++;
                p2--;
                answer++;
            } else {
                p2--;
                answer++;
            }
        }
        
        return answer;
    }
}