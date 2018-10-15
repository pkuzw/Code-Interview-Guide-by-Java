import java.util.*;
import java.util.Scanner;
public class ReverseStack {
    ///@brief   get the bottom element of the stack and remove it.
    public static int getLastAndRemove(Stack<Integer> stk) {
        int result = stk.pop();
        if (stk.empty())   return result;
        int last = getLastAndRemove(stk);
        stk.push(result);
        return last;
    }

    ///@brief   reverse the stack.
    public static void reverse(Stack<Integer> stk) {
        if (stk.empty())    return;
        int tmp = getLastAndRemove(stk);
        reverse(stk);
        stk.push(tmp);
        return;
    }

    ///@brief   main function.
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack();
        Scanner scanner = new Scanner(System.in); //This is the input class.
        System.out.println("Input the size of the stack: ");
        int sizeOfStack = scanner.nextInt();

        System.out.println("Input the elements of the stack: ");
        for (int i = 0; i < sizeOfStack; i++) {
            int elemOfStack = scanner.nextInt();
            stack.push(elemOfStack);
        }

        reverse(stack);

        System.out.println("After reversing, the stack should be like this: ");

        System.out.println("This is stack top.");
        while (stack.empty() == false) {
            System.out.println(stack.pop());
        }
        System.out.println("This is stack bottom.");
    }
}
