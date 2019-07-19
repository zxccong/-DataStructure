/**
 * 数组队列实现类
 *
 * 数据队列的复杂度分析
 *
 * void enqueue         O（1）均摊
 * E dequeue            O（n）
 * E front              O(1)
 * int getSize()        O（1）
 * boolean isEmpty()    O(1)
 *
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {

    private  Array3<E> array;

    public ArrayQueue(int capacity) {
        this.array = new Array3<>(capacity);
    }

    public ArrayQueue(){
        array = new Array3<>();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: "));
        res.append("front [");
        for (int i = 0 ;i <array.getSize() ; i++){
            res.append(array.get(i));
            if (i != array.getSize()-1){
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
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
