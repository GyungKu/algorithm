import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> queue = new LinkedList<>();
        int idx = 0;

        for (int price : prices) {
            queue.offer(price);
        }

        while (!queue.isEmpty()) {
            Integer price = queue.poll();
            for (Integer i : queue) {
                answer[idx] += 1;
                if (price > i) break;
            }
            idx++;
        }

        return answer;
    }
}