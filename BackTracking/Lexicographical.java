import java.io.*;
import java.util.*;

public class Lexicographical {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= 0; i++) {
            dfs(i, n);
        }
    }

    public static void dfs(int i, int n) {
        if (i > n)
            return;

        System.out.println(i);
        for (int j = 0; j < 10; j++) {
            dfs(10 * i + j, n);
        }
    }
}
