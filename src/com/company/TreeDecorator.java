package com.company;

/**
 * @author WuYuanshou
 * 圣诞树装饰器抽象类
 */
public class TreeDecorator implements ChristmasTree {
    private ChristmasTree christmasTree;

    public TreeDecorator(ChristmasTree tree) {
        this.christmasTree = tree;
    }

    @Override
    public String decorate() {
        return christmasTree.decorate();
    }
}
