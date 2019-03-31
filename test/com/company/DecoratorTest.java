package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecoratorTest {

    @Test
    void decorate() {
        //简单的一个装饰器
        ChristmasTree tree = new BubbleLight(new RealChristmasTree());
        assertEquals(tree.decorate(), "Christmas Tree with Bubble Lights");
        //两个相同的装饰器
        ChristmasTree complex_tree = new BubbleLight(new BubbleLight(new RealChristmasTree()));
        assertEquals(complex_tree.decorate(), "Christmas Tree with Bubble Lights with Bubble Lights");
        //两个不同的装饰器
        ChristmasTree combine_tree = new BubbleLight(new GarLand(new RealChristmasTree()));
        assertEquals(combine_tree.decorate(), "Christmas Tree with GarLand with Bubble Lights");
    }
}