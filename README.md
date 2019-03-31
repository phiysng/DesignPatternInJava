# 设计模式 Java语言实现

## 装饰器模式

下面我们实现了通过装饰器来位圣诞树实例增加新的描述的装饰器设计

- 圣诞树接口
```java
public interface ChristmasTree {
    /**
     * @return 圣诞树的描述
     */
    String decorate();
}
```
- 具体的圣诞树
```java
public class RealChristmasTree implements ChristmasTree{
    @Override
    public String decorate() {
        return "Christmas Tree";
    }
}
```
- 装饰类
```java
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
```

- 具体的装饰类 灯
```java
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
```
-  另一个具体装饰类
```java
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
```

```java
//JUnit 5
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

```

## 适配器模式
### LinkedList -> Stack
__LinkedList__
- getLast
- removeLast
- add
- size

__Stack__
- push
- pop
- peek
- size

PS:LinkedList中已经提供了这些接口，同样是LinkedList原有方法的封装

PPS: Java的Queue是一个接口，链表也实现了其所需的所有功能



```java
public interface Queue<E> extends Collection<E>
```



```java
import java.util.LinkedList;
import java.util.Queue;

Queue<Integer> queue = new LinkedList<>();
```

|             | *Throws exception*                                           | *Returns special value*                                      |
| ----------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| **Insert**  | [`add(e)`](https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html#add(E)) | [`offer(e)`](https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html#offer(E)) |
| **Remove**  | [`remove()`](https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html#remove()) | [`poll()`](https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html#poll()) |
| **Examine** | [`element()`](https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html#element()) | [`peek()`](https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html#peek()) |

[代码实现链接](src\com\company)

PPPS:`Java`中基础的的`Stack`与`Queue`的使用

```java
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
```




## 单例模式



### 惰性实现的单例模式

同步`getInstance()`方法
同步整个方法的开销比较大，多个进程

```java
/**
 * 利用同步来实现安全的多线程单例模式
 * 延迟加载
 */

public class Singleton {
    private static Singleton uniqueInstance;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
}
```

### 急切的创建实例

```java
//当创建单例的代价不太大时

public class Singleton {
    private static Singleton uniqueInstance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return uniqueInstance;
    }
}
```

### 双重检查加锁

```java

/**
 * 利用双重检查加锁来实现安全的多线程单例模式
 */

public class Singleton {
    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        //如果类还没有被创建
        if (uniqueInstance == null) {
            //在这里同步多个线程 同一时刻只有一个线程能够进入下面的代码
            synchronized (Singleton.class) {
                //进程申请进入这段代码时实例未创建 但是在其进入这段代码前可能其他进程已经进入
                //这段代码并创建了实例 所以这里进行第二次检查
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}

```