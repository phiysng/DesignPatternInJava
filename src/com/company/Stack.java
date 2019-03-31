package com.company;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * @author WuYuanshou
 * List Implementation of Stack(LIFO) as an alter of deprecated Stack Container from JDK
 * 在这里我们用<code> Stack </code> 封装<code> LinkedList </code>提供的接口以使对外暴露出的
 * 接口符合常用的栈的使用习惯
 */
public class Stack<T> {
    private LinkedList<T> stack;

    Stack() {
        stack = new LinkedList<>();
    }

    public void push(T o) {
        stack.add(o);
    }

    public T pop() {
        if (size() <= 0) {
            throw new NoSuchElementException("Stack is Empty.");
        }
        return stack.removeLast();
    }

    public T peek() {
        if (size() <= 0) {
            throw new NoSuchElementException("Stack is Empty.");
        }
        return stack.getLast();
    }

    public boolean empty() {
        return stack.size() == 0;
    }

    public int size() {
        return stack.size();
    }
}
