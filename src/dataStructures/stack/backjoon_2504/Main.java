package dataStructures.stack.backjoon_2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Stack<Character> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();
        Solution solution = new Solution(line, leftStack, rightStack);
        int answer = solution.solve();
        System.out.println(answer);

    }

    public static class Solution {

        private String line;
        private Stack<Character> leftStack;
        private Stack<Integer> rightStack;

        public Solution(String line, Stack<Character> leftStack, Stack<Integer> rightStack) {
            this.line = line;
            this.leftStack = leftStack;
            this.rightStack = rightStack;
        }

        public int solve() {
            if(line.charAt(0) == ')' || line.charAt(0) == ']')
                return 0;
            for(int i = 0; i < line.length(); i++){
                char ch = line.charAt(i);
                int innerValue = 0;
                if(ch == '(' || ch == '['){
                    rightStack.push(-1);
                    leftStack.push(ch);
                }
                else if(ch == ')'){
                    if (leftStack.isEmpty()) return 0;
                    char top = leftStack.pop();
                    if(top == '('){
                        while(!rightStack.isEmpty() && rightStack.peek() != -1){
                            innerValue += rightStack.pop();
                        }
                        rightStack.pop();
                        if (innerValue > 0) {
                            rightStack.push(2 * innerValue);
                        } else {
                            rightStack.push(2);
                        }
                    }
                    else if(top == ']'){
                        while(!rightStack.isEmpty() && rightStack.peek() != -1){
                            innerValue += rightStack.pop();
                        }
                        rightStack.pop();
                        rightStack.push(2*innerValue);
                    }
                }
                else if(ch == ']'){
                    if (leftStack.isEmpty()) return 0;
                    char top = leftStack.pop();
                    if(top == '[') {
                        while(!rightStack.isEmpty() && rightStack.peek() != -1){
                            innerValue += rightStack.pop();
                        }
                        rightStack.pop();
                        if (innerValue > 0) {
                            rightStack.push(3 * innerValue);
                        } else {
                            rightStack.push(3);
                        }
                    }
                    else if(top == ')'){
                        while(!rightStack.isEmpty() && rightStack.peek() != -1){
                            innerValue += rightStack.pop();
                        }
                        rightStack.pop();
                        rightStack.push(3*innerValue);
                    }
                }
            }
            while(!rightStack.isEmpty()){
                if(rightStack.peek() == -1)
                    return 0;
                answer += rightStack.pop();
            }
            return answer;
        }
    }
}
