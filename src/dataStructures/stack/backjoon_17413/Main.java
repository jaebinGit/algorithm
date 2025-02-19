package dataStructures.stack.backjoon_17413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Solution solution = new Solution(line);
        solution.solve();


    }

    private static class Solution {

        private final String line;
        public Solution(String line) {
            this.line = line;
        }

        private void solve(){
            StringBuilder st = new StringBuilder();
            Stack<Character> stack = new Stack<>();
            boolean tag = false;
            for(int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if(ch == '<'){
                    tag = true;
                    while(!stack.isEmpty()) st.append(stack.pop());
                    st.append(ch);
                }
                else if(ch == '>'){
                    tag = false;
                    st.append(ch);
                }
                else if(tag){
                    st.append(ch);
                }
                else if(ch == ' '){
                    while(!stack.isEmpty()) st.append(stack.pop());
                    st.append(' ');
                }
                else{
                    stack.push(ch);
                }
            }
            while(!stack.isEmpty()) st.append(stack.pop());

            System.out.println(st);
        }
    }
}