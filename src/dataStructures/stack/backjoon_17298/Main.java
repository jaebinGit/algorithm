package dataStructures.stack.backjoon_17298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCnt = Integer.parseInt(br.readLine());
        int[] numArray = new int[numCnt];
        int[] answer = new int[numCnt];
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < numCnt; i++){
            numArray[i] = Integer.parseInt(st.nextToken());
        }

        Solution solution = new Solution(numArray, answer, stack);
        solution.solve();

    }

    public static class Solution {
        private int[] numArray;
        private int[] answer;
        Stack<Integer> stack;

        public Solution(int[] numArray, int[] answer, Stack<Integer> stack) {
            this.numArray = numArray;
            this.answer = answer;
            this.stack = stack;
        }
        public void solve() {
            for(int i = numArray.length - 1; i > -1; i--){
                if(stack.isEmpty()) {
                    stack.push(numArray[i]);
                    answer[i] = -1;
                }
                else {
                    if(stack.peek() > numArray[i]){
                        answer[i] = stack.peek();
                        stack.push(numArray[i]);
                    }
                    else {
                        while(!stack.isEmpty()){
                            if(stack.peek() <= numArray[i]) {
                                stack.pop();
                            }
                            else {
                                answer[i] = stack.peek();
                                stack.push(numArray[i]);
                                break;
                            }
                        }
                        if(stack.isEmpty()) {
                            answer[i] = -1;
                            stack.push(numArray[i]);
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int num : answer) {
                sb.append(num).append(" ");
            }
            System.out.println(sb.toString().trim());
        }

    }
}