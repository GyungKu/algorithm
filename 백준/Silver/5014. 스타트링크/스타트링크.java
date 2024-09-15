import java.io.IOException;
import java.util.*;

public class Main {

    static int F, S, G, U, D;
    static String answer = "use the stairs";
    static int[] dy = new int[2];
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        F = sc.nextInt(); // 총 층
        S = sc.nextInt(); // 현재 있는 층
        G = sc.nextInt(); // 목적지
        U = sc.nextInt(); // 위로
        D = sc.nextInt(); // 아래로
        dy[0] = U;
        dy[1] = -D;
        visited = new boolean[F+1];

        bfs();
        System.out.println(answer);
    }


    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {S, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cur = poll[0];
            int depth = poll[1];
            visited[cur] = true;

            if (cur == G) {
                answer = depth + "";
                break;
            }

            for (int i = 0; i < dy.length; i++) {
                int next = cur + dy[i];

                if (next > 0 && next <= F && !visited[next]) {
                    queue.offer(new int[] {next, depth+1});
                    visited[next] = true;
                }
            }
        }
    }

}