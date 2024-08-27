import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n, m, v;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();
        arr = new int[n+1][n+1];
        visited = new boolean[n+1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        dfs(v);
        System.out.println();
        visited = new boolean[n+1];
        bfs(v);
    }


    static void dfs(int l) {
        if (l > n) return;
        System.out.print(l + " ");
        visited[l] = true;
        for (int i = 1; i <= n; i++)
            if (!visited[i] && arr[l][i] == 1) dfs(i);
    }

    static void bfs(int l) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(l);
        visited[l] = true;

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            System.out.print(cur + " ");

            for (int i = 1; i <= n; i++) {
                if (!visited[i] && arr[cur][i] == 1) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }


}