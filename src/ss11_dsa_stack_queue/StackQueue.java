package ss11_dsa_stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class StackQueue {
    public static boolean isPrime(int num){
        if (num < 2){
            return false;
        }
        int result = (int)Math.sqrt(num);
        for (int i = 2; i<= result; i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void stackPrime(int n){
        Stack<Integer> stack = new Stack<>();
        for (int i= 0; i <= n; i++){
            if (isPrime(i)){
                stack.push(i);
            }
        }
        System.out.println(stack);
    }

    public static void queuePrime(int n){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i<=n; i++){
            if (isPrime(i)){
                queue.add(i);
            }
        }
        System.out.println(queue);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập n: ");
        int n = scanner.nextInt();
        System.out.println("Đây là Stack: ");
        stackPrime(n);
        System.out.println("Đây là Queue: ");
        queuePrime(n);

    }
}
