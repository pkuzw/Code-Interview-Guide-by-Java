///@author  Zhao Wei
///@date    October 22, 2018
///@file    Sort the existing stack with another stack data structure for extra storage.

import java.util.*;

public class SortStack {
    private Stack<Integer> helper;

    ///@brief   Sort the stack as the order of the greater one listing topper.
    ///@param   stk     the existing stack
    ///@return  the sorted stack. BE CAREFUL! There is no pass reference parameter in JAVA language!
    public Stack<Integer> sortStack(Stack<Integer> stk) {
        helper = new Stack<Integer>();
        while (stk.empty() == false) {
            int cur = stk.pop();
            while (helper.empty() == false && cur > helper.peek())
                stk.push(helper.pop());
            helper.push(cur);
        }
        while (helper.empty() == false)
            stk.push(helper.pop());
        return stk;
    }
    public static void main(String args[]) {
        System.out.println("Input the size of stack: ");
        Scanner scanner = new Scanner(System.in);
        int stackSize = scanner.nextInt();
        System.out.println("Input the stack elements: ");

        Stack<Integer> stk = new Stack<Integer>();
        SortStack ss = new SortStack();
        while (stackSize-- != 0) {
            int elem = scanner.nextInt();
            stk.push(elem);
        }
        Stack<Integer> s = ss.sortStack(stk);

        System.out.println("Print the stack after sorted: ");
        while (s.empty() == false) {
            System.out.println(s.pop());
        }
    }
}
