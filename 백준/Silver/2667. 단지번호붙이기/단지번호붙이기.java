import java.io.IOException;
import java.util.*;

public class Main {

    static int n;
    static int[][] arr;
    static List<Integer> result = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] split = sc.next().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(split[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) bfs(i, j);
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (Integer i : result) {
            System.out.println(i);
        }
    }


    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        int cnt = 1;
        arr[x][y] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] == 1) {
                    queue.offer(new int[] {nx, ny});
                    arr[nx][ny] = 0;
                    cnt++;
                }
            }
        }
        result.add(cnt);
    }

}