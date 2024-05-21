import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        System.out.println(solution(n, arr));
    }

    public static long solution(int n, int[] arr) {
        Arrays.sort(arr);
        long answer = 0, lt = 1;
        long rt = arr[arr.length-1];

        while (lt <= rt) {
            long mid = (lt+rt)/2;
            if (search(mid, n, arr)) {
                lt = mid+1;
                answer = mid;
            } else rt = mid-1;
        }

        return answer;
    }

    public static boolean search(long len, int n, int[] arr) {
        int cnt = 0;
        for (int i : arr) {
            cnt += i/len;
            if (cnt >= n) return true;
        }
        return false;
    }

}