package dataStructures.greedy.boj13305;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dist = new int[n-1];
        for(int i = 0; i < n-1; i++) {
            dist[i] = sc.nextInt();
        }
        int[] cost = new int[n];
        for(int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        long sum = 0;

        for(int i = 0; i < n-1; i++) {
            min = Math.min(min,cost[i]);
            sum += (long) min *dist[i];
        }

        System.out.println(sum);
    }
}
