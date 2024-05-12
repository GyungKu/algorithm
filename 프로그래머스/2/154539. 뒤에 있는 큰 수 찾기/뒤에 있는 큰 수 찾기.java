import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        answer[0] = -1;
        stack.push(0);
        for (int i = 1; i < numbers.length; i++) {
            answer[i] = -1;
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i])
                answer[stack.pop()] = numbers[i];
            stack.push(i);
        }

        return answer;
    }
}