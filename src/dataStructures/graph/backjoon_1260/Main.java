package dataStructures.graph.backjoon_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        int V = Integer.parseInt(st1.nextToken());
        HashMap<Integer, Node> graph = new HashMap<>();
        for(int i = 1; i <= N; i++){
            graph.put(i, new Node(i));
        }
        for(int i = 0; i < M; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int V1 = Integer.parseInt(st2.nextToken());
            int V2 = Integer.parseInt(st2.nextToken());
            link(graph.get(V1), graph.get(V2));
        }
        Solution solution = new Solution(graph);
        solution.solveDFS(V);
        System.out.println();
        resetFlags(graph);
        solution.solveBFS(V);

    }

    public static class Solution {
        private final HashMap<Integer, Node> graph;

        public Solution(HashMap<Integer, Node> graph) {
            this.graph = graph;
        }

        private void solveDFS(int V) {
            Stack<Node> stack = new Stack<>();
            stack.push(graph.get(V));
            while(!stack.isEmpty()){
                Node node = stack.pop();
                if(!node.getFlag()){
                    node.setFlag(true);
                    System.out.print(node.getData() + " ");
                }
                List<Node> children = new ArrayList<>(node.child);
                children.sort(Comparator.comparingInt(Node::getData));
                for (int i = children.size() - 1; i >= 0; i--) {
                    if (!children.get(i).getFlag()) {
                        stack.push(children.get(i));
                    }
                }
            }
        }

        private void solveBFS(int V) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(graph.get(V));
            while(!queue.isEmpty()){
                Node node = queue.poll();
                if(!node.getFlag()){
                    node.setFlag(true);
                    System.out.print(node.getData() + " ");
                }
                List<Node> children = new ArrayList<>(node.child);
                children.sort(Comparator.comparingInt(Node::getData));
                for (Node child : children) {
                    if (!child.getFlag()) {
                        queue.add(child);
                    }
                }
            }
        }

    }

    private static class Node {
        private final int data;
        private final LinkedList<Node> child;
        boolean flag;

        public Node(int data) {
            this.data = data;
            this.child = new LinkedList<>();
            this.flag = false;
        }

        private int getData() {
            return data;
        }
        private boolean getFlag() { return flag; }
        private void setFlag(boolean flag) { this.flag = flag; }
    }

    public static void link(Node a, Node b){
        if(!a.child.contains(b)) a.child.add(b);
        if(!b.child.contains(a)) b.child.add(a);
    }

    public static void resetFlags(HashMap<Integer, Node> graph) {
        for (Node node : graph.values()) {
            node.setFlag(false);
        }
    }
}