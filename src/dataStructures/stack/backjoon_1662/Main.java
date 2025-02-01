package dataStructures.stack.backjoon_1662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Stack<Integer> rightStack = new Stack<>();
        Stack<Character> leftStack = new Stack<>();
        Solution solution = new Solution(line, leftStack, rightStack);
        solution.solve();

    }

    public static class Solution {

        private final String line;
        private Stack<Character> leftStack;
        private Stack<Integer> rightStack;

        public Solution(String line, Stack<Character> leftStack, Stack<Integer> rightStack) {
            this.line = line;
            this.leftStack = leftStack;
            this.rightStack = rightStack;
        }

        private void solve() {
            int answer = 0;
            for(int i = 0; i < line.length(); i++){

                char ch = line.charAt(i);

                if(ch == '('){
                    leftStack.push(ch);
                    rightStack.push(-1);
                }
                else if(ch == ')'){

                    // 현재 괄호 안에 모든 value 합하기
                    int value = 0;
                    while(!leftStack.isEmpty() && leftStack.peek() != '('){
                        value ++;
                        leftStack.pop();
                    }
                    rightStack.push(value);
                    if(!leftStack.isEmpty()) leftStack.pop();

                    // 괄호 안에 모든 value 합하기
                    int innerValue = 0;
                    while(!rightStack.isEmpty() && rightStack.peek() != -1){
                        innerValue += rightStack.pop();
                    }
                    if(!rightStack.isEmpty()) rightStack.pop();

                    // P(q) 실행
                    int p = 0;
                    if(!leftStack.isEmpty()){
                        p = Integer.parseInt(String.valueOf(leftStack.pop()));
                    }
                    rightStack.push(p*innerValue);
                }
                else{
                    leftStack.push(ch);
                }
            }
            // 정답 count
            while(!rightStack.isEmpty()){
                answer += rightStack.pop();
            }
            while(!leftStack.isEmpty()){
                answer++;
                leftStack.pop();
            }

            System.out.println(answer);
        }

    }
}