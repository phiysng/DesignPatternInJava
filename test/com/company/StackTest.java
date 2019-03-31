package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void push() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        assertEquals(stack.peek(), 1);
        stack.push(10);
        assertEquals(stack.peek(), 10);
    }

    @Test
    void pop() {
        Stack<Integer> stack = new Stack<>();
        NoSuchElementException stackException = assertThrows(NoSuchElementException.class, stack::pop);
        assertEquals(stackException.getMessage(), "Stack is Empty.");

        stack.push(10);
        assertEquals(stack.pop(), 10);

        stackException = assertThrows(NoSuchElementException.class, stack::pop);
        assertEquals(stackException.getMessage(), "Stack is Empty.");
    }

    @Test
    void peek() {
        Stack<Integer> stack = new Stack<>();
        NoSuchElementException stackException = assertThrows(NoSuchElementException.class, stack::peek);
        assertEquals(stackException.getMessage(), "Stack is Empty.");
        stack.push(10);
        assertEquals(stack.peek(), 10);
    }

    @Test
    void empty() {
        Stack<Integer> stack = new Stack<>();
        assertTrue(stack.empty());
        stack.push(10);
        assertFalse(stack.empty());

    }

    @Test
    void size() {
        Stack<Integer> stack = new Stack<>();
        assertEquals(stack.size(), 0);
        stack.push(10);
        assertEquals(stack.size(), 1);
    }
}