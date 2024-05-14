import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process> queue = new LinkedList();

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Process(i, priorities[i]));
        }

        while (!queue.isEmpty()) {
            Process process = queue.poll();
            for (Process process2 : queue) {
                if (process.getPriority() < process2.getPriority()) {
                    queue.offer(process);
                    process = null;
                    break;
                }
            }
            if (process != null) {
                answer++;
                if (process.getId() == location) break;
            }
        }

        return answer;
    }
}

class Process {
    private int id;
    private int priority;

    public Process(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }
}