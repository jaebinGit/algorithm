import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;

        if(n == 1 || n == 2) System.out.println(dp[n]);
        else {
            System.out.println(solve(dp,n));
        }
    }

    private static int solve(int[] dp, int n) {

        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }

        return dp[n];
    }
}