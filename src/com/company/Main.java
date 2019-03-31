package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> stack = new LinkedList<>();
        stack.push("1");
        System.out.println(stack.peek());
        System.out.println(stack.poll());
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());

        Queue<String> queue = new LinkedList<>();
        queue.add("str");
        System.out.println(queue.element());
        queue.remove(queue.remove());
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
    }
}
