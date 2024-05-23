class Solution {
    
    public int solution(int[] numbers, int target) {
        return dfs(0, numbers, 0, 0, target);
    }
    
    public static int dfs(int idx, int[] numbers, int cnt, int sum, int target) {
        if (idx == numbers.length) {
            if (sum == target) cnt++;
            return cnt;
        }
        cnt = dfs(idx+1, numbers, cnt, sum+numbers[idx], target);
        cnt = dfs(idx+1, numbers, cnt, sum-numbers[idx], target);
        return cnt;
    }
}