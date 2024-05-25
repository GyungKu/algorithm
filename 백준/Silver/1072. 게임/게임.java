import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        System.out.println(solution(x, y));
    }

    public static int solution(long x, long y) {
        int answer = -1;
        int per = (int) (y*100 / x);
        int lt = 0, rt = 1000000000;

        while (lt <= rt) {
            int mid = (lt+rt)/2;
            int curPer = (int) ((y+mid)*100 / (x+mid));

            if (curPer != per) {
                answer = mid;
                rt = mid-1;
            } else lt = mid+1;
        }

        return answer;
    }

}