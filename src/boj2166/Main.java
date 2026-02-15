package boj2166;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Node>[] graph = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int c = sc.nextInt();
            graph[s].add(new Node(e,c));
            graph[e].add(new Node(s,c));
        }

        int[] dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        dijk(graph, dist);

        System.out.println(dist[N]);
    }

    private static class Node implements Comparable<Node> {
        int v;
        int cost;
        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    private static void dijk(List<Node>[] graph, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[1] = 0;
        pq.add(new Node(1,0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            int cv = now.v;
            int cx = now.cost;
            if(dist[cv] < cx) continue;

            for(Node next : graph[cv]) {
                if(cx+next.cost < dist[next.v]) {
                    dist[next.v] = cx+next.cost;
                    pq.add(new Node(next.v,dist[next.v]));
                }
            }
        }
    }
}
