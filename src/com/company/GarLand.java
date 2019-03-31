package com.company;

/**
 * @author WuYuanshou
 * GarLand装饰器
 */
public class GarLand extends TreeDecorator {
    public GarLand(ChristmasTree tree) {
        super(tree);
    }

    @Override
    public String decorate() {
        return super.decorate() + decorateWithGarLand();
    }

    private String decorateWithGarLand() {
        return " with GarLand";
    }

}
