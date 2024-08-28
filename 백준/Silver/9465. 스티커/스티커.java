import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int t, n;
    static int[][] arr;
    static int[][] dy;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            arr = new int[2][n];
            dy = new int[2][n];

            for (int j = 0; j < n; j++) arr[0][j] = sc.nextInt();
            for (int j = 0; j < n; j++) arr[1][j] = sc.nextInt();
            solution();
        }

    }


    static void solution() {

        if (n == 1) {
            System.out.println(Math.max(arr[0][0], arr[1][0]));
            return;
        }
        
        dy[0][0] = arr[0][0];
        dy[1][0] = arr[1][0];
        dy[0][1] = arr[0][1] + dy[1][0];
        dy[1][1] = arr[1][1] + dy[0][0];
        int max = Math.max(dy[0][1], dy[1][1]);
        
        for (int i = 2; i < n; i++) {
            dy[0][i] = Math.max(dy[1][i-1], dy[1][i-2]) + arr[0][i];
            dy[1][i] = Math.max(dy[0][i-1], dy[0][i-2]) + arr[1][i];
            max = Math.max(dy[0][i], dy[1][i]);
        }
        System.out.println(max);
    }

}