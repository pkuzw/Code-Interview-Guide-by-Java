///@file    Implement a stack with the function of getMin().
///@note    1. Use another stack to store the minimum element right now. When push down a new element, if the new
//             element is less or equal to the top element of the min stack, then push it into the min stack.
//             Else we should push the top element of the min stack into itself again.

///@author  Zhao Wei
///@date    October 15, 2018
///@version 1.0


import java.util.*;

public class StackWithGetMin {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public StackWithGetMin() {
        stackData = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }

    public void push(int x) {
        stackData.push(x);
        if (stackMin.empty()) stackMin.push(x);
        else {
            if (x <= stackMin.peek())   stackMin.push(x);
            else    stackMin.push(stackMin.peek());
        }
    }

    public int pop() {
        stackMin.pop();
        return stackData.pop();
    }

    public int getMin() {
        return stackMin.peek();
    }

    public boolean isEmpty() {
        return stackData.isEmpty();
    }

    public static void main(String args[]) {
        StackWithGetMin stkWGM = new StackWithGetMin();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the stack size: ");
        int stackSize = scanner.nextInt();

        System.out.println("Input the stack element: ");
        while (stackSize-- > 0) {
            int x = scanner.nextInt();
            stkWGM.push(x);

            int m = stkWGM.getMin();
            System.out.println("Now the min element of stack is " + m);
        }
        return;
    }
}
