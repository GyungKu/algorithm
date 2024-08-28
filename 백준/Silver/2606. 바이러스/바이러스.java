import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n, m, answer = 0;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n+1][n+1];
        visited = new boolean[n+1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        solution();
        System.out.println(answer);
    }


    static void solution() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && arr[cur][i] == 1) {
                    queue.offer(i);
                    visited[i] = true;
                    answer++;
                }
            }
        }
    }

}