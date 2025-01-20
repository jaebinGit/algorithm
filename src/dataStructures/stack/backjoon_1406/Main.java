package dataStructures.stack.backjoon_1406;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        Stack<Character> leftStack = new Stack<>();
        for(int i = 0; i < line.length(); i++){
            leftStack.push(line.charAt(i));
        }
        Stack<Character> rightStack = new Stack<>();

        Solution solution = new Solution(leftStack, rightStack);

        int commandCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < commandCount; i++) {
            String command = br.readLine();

            if (command.charAt(0) == 'L') {
                solution.leftMove();
            } else if (command.charAt(0) == 'D') {
                solution.rightMove();
            } else if (command.charAt(0) == 'B') {
                solution.deleteLeft();
            } else if (command.charAt(0) == 'P') {
                solution.addLeft(command.charAt(2));
            }
        }

        StringBuilder result = new StringBuilder();
        for (Character c : leftStack) {
            result.append(c);
        }
        while (!rightStack.isEmpty()) {
            result.append(rightStack.pop());
        }

        bw.write(result.toString());
        bw.flush();
    }
    public static class Solution {
        private Stack<Character> leftStack;
        private Stack<Character> rightStack;

        public Solution(Stack<Character> leftStack, Stack<Character> rightStack) {
            this.leftStack = leftStack;
            this.rightStack = rightStack;
        }

        private void leftMove(){
            if(!leftStack.isEmpty())
                rightStack.push(leftStack.pop());
        }

        private void rightMove(){
            if(!rightStack.isEmpty())
                leftStack.push(rightStack.pop());
        }

        private void deleteLeft(){
            if(!leftStack.isEmpty())
                leftStack.pop();
        }

        private void addLeft(Character c){
            leftStack.push(c);
        }
    }
}
