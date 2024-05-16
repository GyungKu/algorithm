import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Map<Integer, Integer> answer = new LinkedHashMap<>();
        Queue<Program> queue = new LinkedList();
        int day = 0;

        for (int i = 0; i < progresses.length; i++) {
            queue.offer(new Program(progresses[i], speeds[i]));
        }

        while (!queue.isEmpty()) {
            day++;
            int size = queue.size();
            boolean flag = true;
            for (int i = 0; i < size; i++) {
                Program program = queue.poll();
                if (program.updateProgress() < 100) flag = false;
                if (flag) answer.put(day, answer.getOrDefault(day, 0)+1);
                else queue.offer(program);
            }
        }

        return answer.values().stream().mapToInt(i -> i).toArray();
    }
}

class Program {
    private int progress;
    private int speed;

    public Program(int progress, int speed) {
        this.progress = progress;
        this.speed = speed;
    }

    public int updateProgress() {
        progress = progress + speed;
        return progress;
    }
}