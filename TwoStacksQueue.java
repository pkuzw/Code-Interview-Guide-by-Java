///@file    Implement a queue by two stacks.
///@author  Zhao Wei
///@date    October 16, 2018
///@version 1.0

import java.util.*;

public class TwoStacksQueue {
    private Stack<Integer> stackData;
    private Stack<Integer> stackTmp;

    ///@note    1. One stack is used for storing data permanently; the other one is used to store the data when popping
    //             elements.
    public TwoStacksQueue() {
        stackData = new Stack<Integer>();
        stackTmp = new Stack<Integer>();
    }

    public void push(int x) {
        stackData.push(x);
    }

    public int pop() {
        while (!stackData.empty())  stackTmp.push(stackData.pop());
        int rslt = stackTmp.pop();
        while (!stackTmp.empty())   stackData.push(stackTmp.pop());
        return rslt;
    }

    public boolean empty() {
        return stackData.empty();
    }

    public static void main(String args[]) {
        TwoStacksQueue tsqueue = new TwoStacksQueue();
        int[] input = {1, 2, 3, 4, 5, 6};
        for (int i: input)  tsqueue.push(i);
        while (tsqueue.empty() == false) {
            System.out.println("The head of the two-stacks queue is " + tsqueue.pop());
        }
        return;
    }
}
