package dataStructures.stack.backjoon_2493;
/**
 * O(n^2)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());

        String line = br.readLine();
        String[] numbers = line.split(" ");

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < cnt; i++) {
            stack.push(Integer.parseInt(numbers[i])); // 숫자를 스택에 넣기
        }

        int[] answer = new int[cnt];

        Solution solution = new Solution(stack, answer);
        solution.solve();

    }

    public static class Solution {

        private final Stack<Integer> stack;
        private final int[] answer;

        public Solution(Stack<Integer> stack, int[] answer) {
            this.stack = stack;
            this.answer = answer;
        }

        public void solve(){
            while(!stack.isEmpty()) {
                int size = stack.size();
                Integer top = stack.pop();
                for (int i = size - 1; i > 0; i--) {
                    if (stack.get(i - 1) > top) {
                        answer[size - 1] = i;
                        break;
                    }
                }
            }
            for(int j = 0; j < answer.length; j++)
                System.out.print(answer[j] + " ");
        }
    }
}
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());

        String line = br.readLine();
        String[] numbers = line.split(" ");

        Stack<Integer> top = new Stack<>();

        int[] value = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            value[i] = Integer.parseInt(numbers[i]); // 숫자를 스택에 넣기
        }

        int[] answer = new int[cnt];

        Solution solution = new Solution(top, value, answer);
        solution.solve();

    }

    public static class Solution {

        private final Stack<Integer> top;
        private final int[] value;
        private final int[] answer;

        public Solution(Stack<Integer> top, int[] value , int[] answer) {
            this.top= top;
            this.value = value;
            this.answer = answer;
        }

        public void solve(){
            for(int i = 0; i < value.length; i++){
                if(top.isEmpty()){
                    top.push(i);
                }
                else {
                    while(!top.isEmpty() && value[i] > value[top.peek()]){
                        top.pop();
                    }
                    if(top.isEmpty()) {
                        answer[i] = 0;
                        top.push(i);
                    }
                    else {
                        answer[i] = top.peek() + 1;
                        top.push(i);
                    }
                }
            }
            for(int j = 0; j < answer.length; j++)
                System.out.print(answer[j] + " ");
        }
    }
}