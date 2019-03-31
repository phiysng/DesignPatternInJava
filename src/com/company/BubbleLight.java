package com.company;

/**
 * @author WuYuanshou
 * BUbbleLight装饰器
 */
public class BubbleLight extends TreeDecorator {
    public BubbleLight(ChristmasTree tree) {
        super(tree);
    }

    @Override
    public String decorate() {
        return super.decorate() + decorateWithBubbleLights();
    }

    private String decorateWithBubbleLights() {
        return " with Bubble Lights";
    }
}
