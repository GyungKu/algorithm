import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0, weights = 0;
        Queue<Integer> queue = new LinkedList();

        for (int truck : truck_weights) {
            if (queue.isEmpty()) {
                answer++;
                queue.offer(truck);
                weights += truck;
                continue;
            }
            while (!queue.isEmpty()) {
                if (queue.size() == bridge_length) {
                    weights -= queue.poll();
                } else if (weights + truck <= weight) {
                    answer++;
                    queue.offer(truck);
                    weights += truck;
                    break;
                } else {
                    queue.offer(0);
                    answer++;
                }
            }
        }

        return answer + bridge_length;
    }
}