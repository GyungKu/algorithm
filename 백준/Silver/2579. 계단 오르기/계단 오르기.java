import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int n;
    static int[] arr;
    static int[] dy;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n+1];
        dy = new int[n+1];
        for (int i = 1; i <= n; i++) arr[i] = sc.nextInt();

        dy[1] = arr[1];
        if (n > 1) dy[2] = arr[1] + arr[2];
        solution();
        System.out.println(dy[n]);
    }


    static void solution() {
        for (int i = 3; i <= n; i++)
            dy[i] = Math.max(dy[i-2], arr[i-1] + dy[i-3]) + arr[i];
    }

}