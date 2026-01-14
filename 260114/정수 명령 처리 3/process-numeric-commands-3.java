import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            String command = sc.next();
            int r;
            switch (command) {
                case "push_front" :
                    r = sc.nextInt();
                    dq.addFirst(r);
                    break;
                case "push_back" :
                    r = sc.nextInt();
                    dq.addLast(r);
                    break;
                case "pop_front" :
                    System.out.println(dq.pollFirst());
                    break;
                case "pop_back" :
                    System.out.println(dq.pollLast());
                    break;
                case "size" :
                    System.out.println(dq.size());
                    break;
                case "empty" :
                    if(dq.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "front" :
                    System.out.println(dq.peekFirst());
                    break;
                case "back" :
                    System.out.println(dq.peekLast());
            }
        }
    }
}