public class Array {
    private int[] data;

    private int size;

    /**
     * 构造函数，传入数组的容量的capacity构造Array
     * @param capacity
     */
    public Array(int capacity){
        data = new int[capacity];
        size = 0;
    }

    /**
     * 无参数的构造函数，默认数组容量capacity=10
     */
    public Array(){
        this(10);
    }

    /**
     * 获取数组中的元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return size==0;
    }

    public void addLast(int e){
        if (size == data.length){
            throw new IllegalArgumentException("AddLast failed . Array is full");

        }
        data[size] = e;
        size++;
    }
}
