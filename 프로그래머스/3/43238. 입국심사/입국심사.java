import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long lt = 0;
        long rt = Arrays.stream(times).max().getAsInt() * (long) n;

        while (lt <= rt) {
            long middle = (lt+rt) / 2;
            long sum = 0;
            for (int time : times) {
                sum += (middle / time);
            }
            if (sum >= n) {
                answer = middle;
                rt = middle-1;
            } else lt = middle+1;
        }

        return answer;
    }
}