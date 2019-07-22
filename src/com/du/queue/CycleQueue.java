package com.du.queue;

/**
 * @author: djg
 * @date: 2019/7/23 00:04
 * @des: 循环队列
 */
public class CycleQueue<T> {
    private int front;
    private int rear;
    private Object[] data;
    private int maxSize;

    /**
     * 初始化一个容量为10的队列
     */
    public CycleQueue() {
        this(10);
    }

    public CycleQueue(int maxSize) {
        if (maxSize > 0) {
            this.maxSize = maxSize;
            data = new Object[maxSize];
            front = rear = 0;
        } else {
            throw new RuntimeException("初始化容量必须大于零!");
        }
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public Boolean isEmpty() {
        return front == rear;
    }

    /**
     * 判断队列是否已满
     *
     * @return
     */
    public Boolean isFull() {
        return (rear + 1) % maxSize == front;
    }


    /**
     * 添加数据
     *
     * @param t
     * @return
     */
    public Boolean add(T t) {
        if (isFull()) {
            throw new RuntimeException("queue is full，can't add");
        } else {
            data[rear] = t;
            rear = (rear + 1) % maxSize;
            return Boolean.TRUE;
        }
    }

    /**
     * 出队
     *
     * @return
     */
    public T poll() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        } else {
            T value = (T) data[front];
            front = (front + 1) % maxSize;
            return value;
        }
    }


    /**
     * 获取队列的长度
     *
     * @return
     */
    public int length() {
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 查看队顶元素
     *
     * @return
     */
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        } else {
            return (T) data[front];
        }
    }

}
















