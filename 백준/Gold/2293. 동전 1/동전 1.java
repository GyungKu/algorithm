import java.io.IOException;
import java.util.*;

public class Main {

    static int n, k;
    static int[] arr;
    static int[] dy;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n];
        dy = new int[k+1];

        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        dy[0] = 1;
        for (int i : arr) {
            dp(i);
        }
        System.out.println(dy[k]);
    }


    static void dp(int coin) {
        for (int i = coin; i <= k; i++) {
            dy[i] += dy[i - coin];
        }
    }

}