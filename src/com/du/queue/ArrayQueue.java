package com.du.queue;

import javax.management.RuntimeMBeanException;
import java.util.Arrays;
import java.util.Collections;

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
            throw new RuntimeException("队列长度不能小于0");
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


    /**
     * 队列的添加
     * @param t
     * @return
     */
    public boolean add(T t){
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }else {
            data[rear++] = t;
            return true;
        }

    }

    /**
     * 查看队列中的头元素
     * @return
     */
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        } else {
            return (T) data[front];
        }
    }

    /**
     * 出队
     * @return
     */
    public T poll() {
        if (isEmpty()) {
            throw new RuntimeException("空队列异常");
        } else {
            T result = (T) data[front];
            data[front++] = null;
            return result;
        }
    }

    /**
     * 获取队列的长度
     * @return
     */
    public int length(){
        return front - rear;
    }

    public Object[] list(){
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        } else {
            return data;
        }

    }

    public static void main(String[] args) {
        ArrayQueue<String> queue = new ArrayQueue<>(4);
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");

        queue.poll();

        System.out.println(queue.peek());


        Object[] list = queue.list();
        System.out.println(Arrays.toString(list));

    }


}
