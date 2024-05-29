import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] tree = new int[n+1][n+1];
        int[][] pair = new int[m][2];

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree[a][b] = c;
            tree[b][a] = c;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pair[i][0] = a;
            pair[i][1] = b;
        }

        for (int[] ints : pair) {
            boolean[] visited = new boolean[n+1];
            System.out.println(solution(tree, visited, ints[0], ints[1], 0));
        }
    }

    public static int solution(int[][] tree, boolean[] visited, int cur, int goal, int sum) {
        if (cur == goal) return sum;
        else {
            visited[cur] = true;
            for (int i = 1; i < tree.length; i++) {
                if (!visited[i] && tree[cur][i] != 0) {
                    int result = solution(tree, visited, i, goal, sum + tree[cur][i]);
                    if (result != -1) return result;
                }
            }
            return -1;
        }
    }

}