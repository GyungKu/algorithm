class Solution {
    public int solution(int n) {
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;

        for (int i = 2; i < n; i++) answer[i] = (answer[i-2] + answer[i-1]) % 1234567;

        return answer[n-1];
    }
}