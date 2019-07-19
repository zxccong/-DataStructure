/**
 * 循环队列
 *
 *  * void enqueue         O（1）均摊
 *  * E dequeue            O（1）均摊
 *  * E front              O(1)
 *  * int getSize()        O（1）
 *  * boolean isEmpty()    O(1)
 */
public class LoopQueue<E> implements Queue<E> {

    //不再重用数组，
    private E[] data;

    private int front, tail;

    private int size;

    /**
     * 有参构造方法
     *
     * @param capacity
     */
    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    /**
     * 无参构造方法
     */
    public LoopQueue() {
        this(10);
    }

    /**
     * 获得容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;

    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }

        E ret = data[front];

        data[front] = null;

        front = (front + 1) % data.length;
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d \n", size, getCapacity()));
        res.append("front [");
        for (int i = front ;i !=tail ; i=(i+1)%data.length){
            res.append(data[i]);
            if ((i+1)%data.length != tail){
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }
    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println("queue = " + queue);
            if (i%3==2){
                queue.dequeue();
                System.out.println("queue = " + queue);
            }
        }
    }
}
