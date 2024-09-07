import java.io.IOException;
import java.util.*;

public class Main {

    static int n, k, answer = Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 2};
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        visited = new boolean[100001];

        bfs();
        System.out.println(answer);
    }


    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{n, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curX = poll[0];
            int depth = poll[1];

            if (curX == k) {
                answer = depth;
                break;
            }

            for (int i = 0; i < dx.length; i++) {
                int next = curX + dx[i];
                if (i == dx.length-1) next = curX * dx[i];

                if (next >= 0 && next < visited.length && !visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, depth+1});
                }
            }
        }
    }

}