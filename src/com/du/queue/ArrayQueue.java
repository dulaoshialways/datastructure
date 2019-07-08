package com.du.queue;

/**
 * @author djg
 * @date 2019/7/8 12:59
 * @des 数组实现一个简单的队列
 */
public class ArrayQueue<T> {
    /**
     * 队列容量
     */
    private int size;
    /**
     * 队列头指针，允许删除
     */
    private int front;
    /**
     * 队尾指针，允许插入
     */
    private int rear;
    /**
     * 队列中的数据
     */
    private Object[] data;

    /**
     * 空构造，用来初始化队列长度
     */
    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int initSize) {
        if (initSize >= 0) {
            this.size = initSize;
            front = rear = 0;
            data = new Object[initSize];
        } else {
            throw new RuntimeException("队列长度不能小于10");
        }
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 判断队列是否已满
     * @return
     */
    public boolean isFull() {
        return rear == size;
    }




}
