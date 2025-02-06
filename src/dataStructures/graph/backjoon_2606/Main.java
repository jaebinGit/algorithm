package dataStructures.graph.backjoon_2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N];
        for(int i = 0; i < N; i++){
            nodes[i] = new Node(i + 1);
        }
        int M = Integer.parseInt(br.readLine());
        int tmp1;
        int tmp2;
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tmp1 = Integer.parseInt(st.nextToken())-1;
            tmp2 = Integer.parseInt(st.nextToken())-1;
            link(nodes[tmp1], nodes[tmp2]);
        }
        Solution solution = new Solution(nodes);
        solution.solve();
    }

    public static class Solution {
        private final Node[] nodes;

        public Solution(Node[] nodes) {
            this.nodes = nodes;
        }

        private void solve() {
            int answer = -1;
            Stack<Node> stack = new Stack<>();
            stack.push(nodes[0]);
            while(!stack.isEmpty()){
                Node node = stack.pop();
                if(!node.flag) {
                    node.flag = true;
                    answer++;
                }
                while(!node.child.isEmpty()){
                    Node tmp = node.child.pop();
                    if(!tmp.flag) stack.push(tmp);
                }
            }
            System.out.println(answer);
        }

    }

    public static class Node {
        private int data;
        LinkedList<Node> child;
        boolean flag;

        public Node(int data) {
            this.data = data;
            this.child = new LinkedList<>();
            this.flag = false;
        }

        private int getData() {
            return data;
        }
    }

    public static void link(Node a, Node b){
        if(!a.child.contains(b)) a.child.add(b);
        if(!b.child.contains(a)) b.child.add(a);
    }
}
