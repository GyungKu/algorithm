import java.io.IOException;
import java.util.*;

public class Main {

    static int n, x, y, m;
    static int[][] arr;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n+1][n+1];
        visited = new boolean[n+1];
        result = new int[n+1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        visited[x] = true;
        result[y] = -1;
        dfs(x);
        System.out.println(result[y]);

    }


    static void dfs(int cur) {
       for (int i = 1; i <= n; i++) {
           if (!visited[i] && arr[cur][i] == 1) {
               visited[i] = true;
               result[i] = result[cur] + 1;
               dfs(i);
           }
       }
    }

}