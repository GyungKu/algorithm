import java.io.IOException;
import java.util.*;

public class Main {

    static int m, n, h, max = 0;
    static List<int[][]> box = new ArrayList<>();
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int[][][] days;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();
        days = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            int[][] arr = new int[n][m];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    int cur = sc.nextInt();
                    arr[j][k] = cur;
                    if (cur == 1) queue.offer(new Point(j, k, i));
                }
            }
            box.add(arr);
        }

        bfs();

        for (int[][] ints : box) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++)
                    if (ints[i][j] == 0) max = -1;
            }
        }

        System.out.println(max);
    }


    static void bfs() {

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nh = cur.h + dh[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && nh >= 0 && nh < h) {
                    int[][] next = box.get(nh);
                    if (next[nx][ny] == 0) {
                        next[nx][ny] = 1;
                        days[nh][nx][ny] = days[cur.h][cur.x][cur.y] + 1;
                        max = Math.max(max, days[nh][nx][ny]);
                        queue.offer(new Point(nx, ny, nh));
                    }
                }
            }
        }
    }

}

class Point {
    int x;
    int y;
    int h;

    public Point(int x, int y, int h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }
}