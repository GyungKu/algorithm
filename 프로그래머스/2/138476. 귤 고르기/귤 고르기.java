import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : tangerine) map.put(i, map.getOrDefault(i, 0) + 1);
        List<Integer> list = map.values()
            .stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());

        for (Integer i : list) {
            answer++;
            sum += i;
            if (sum >= k) break;
        }

        return answer;
    }
}