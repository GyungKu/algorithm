import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        int lt = 0;
        int rt = distance;

        while (lt <= rt) {
            int mid = (lt+rt)/2;
            if (search(n, rocks, mid, distance)) {
                answer = mid;
                lt = mid+1;
            } else rt = mid-1;
        }

        return answer;
    }
    
    public static boolean search(int n, int[] rocks, int distance, int destination) {
        int tmp = 0;
        for (int rock : rocks) {
            if (rock - tmp < distance) n--;
            else tmp = rock;
            if (n < 0) return false;
        }
        if (destination - tmp < distance) n--;
        if (n < 0) return false;
        return true;
    }
}