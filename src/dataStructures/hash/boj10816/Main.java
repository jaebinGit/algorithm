package dataStructures.hash.boj10816;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input.txt"));
        int N = sc.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            int now = sc.nextInt();
            map.put(now,map.getOrDefault(now,0)+1);
        }
        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            int now = sc.nextInt();
            sb.append(map.getOrDefault(now,0)).append(" ");
        }

        System.out.print(sb.toString());
    }
}
