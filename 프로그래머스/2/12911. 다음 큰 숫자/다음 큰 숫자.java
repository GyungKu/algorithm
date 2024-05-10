class Solution {
    public int solution(int n) {
        int answer = n+1;
        int bitCount = Integer.bitCount(n);

        while (true) {
            if (bitCount == Integer.bitCount(answer)) break;
            answer++;
        }

        return answer;
    }
}