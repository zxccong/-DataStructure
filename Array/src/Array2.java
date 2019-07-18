/**
 * 使用泛型
 */
public class Array2<E> {
    private E[] data;

    //指向最后一个数组为空的索引
    private int size;

    /**
     * 构造函数，传入数组的容量的capacity构造Array
     * @param capacity
     */
    public Array2(int capacity){
        data = (E[]) new Object[capacity];      //历史遗留问题，不支持直接new 一个泛型数组
        size = 0;
    }

    /**
     * 无参数的构造函数，默认数组容量capacity=10
     */
    public Array2(){
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

    /**
     * 添加元素到末尾
     * @param e
     */
    public void addLast(E e){
//        if (size == data.length){
//            throw new IllegalArgumentException("AddLast failed . Array is full");
//
//        }
//        data[size] = e;
//        size++;

        //重用size
        add(size,e);

    }

    /**
     * 添加元素到数组前面
     * @param e
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 添加元素到自定未知
     * @param index
     * @param e
     */
    public void add(int index,E e){
        if (size == data.length){
            throw new IllegalArgumentException("Add failed . Array is full");

        }
        if (index<0||index>size){
            throw new IllegalArgumentException("Add failed . Require index<0||index>size");
        }

        for (int i = size -1;i>=index;i--){
            data[i+1] = data[i];
        }
        data[index]=e;
        size++;
    }

    /**
     * 通过index索引位置的元素为e
     * @param index
     * @return
     */
    E get(int index){
        if (index<0||index>=size){
            throw new IllegalArgumentException("Get Failed Index is illegal");
        }
        return data[index];
    }

    /**\
     * 查找数组中是否有元素e
     * @param e
     * @return
     */
    public boolean contain(E e ){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                return true;
            }

        }
        return false;
    }

    /**
     * 查找数组中元素e所在的位置，如果不存在元素e,则返回-1
     * 只能查找一次可设计：查找出所有的位置
     * @param e
     * @return
     */
    public int find(E e ){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的 元素，返回删除的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if (index<0||index>=size){
            throw new IllegalArgumentException("Remove Failed Index is illegal");
        }

        E ret = data[index];
        for (int i = index +1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;      //不是必须的考虑java 虚拟机回收 loitering objects,手动的回收更好
        return ret;
    }

    /**
     * 删除第一个元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除最后一个元素
     * @return
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     *  删除指定的元素值一次 （可设计：删除所有，删除后返回值）
     * @param e
     */
    public void removeElement(E e){
        int index = find(e);
        if (index != -1){
            remove(index);
        }
    }

    /**
     * 根据index索引位置设置元素e
     * @param index
     * @param e
     */
    void set(int index , E e ){
        if (index<0||index>=size){
            throw new IllegalArgumentException("Set Failed Index is illegal");
        }
        data[index] = e ;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d \n", size, data.length));
        res.append('[');
        for (int i = 0 ;i <size ; i++){
            res.append(data[i]);
            if (i != size-1){
                res.append(",");
            }
        }
        res.append(']');
        return res.toString();
    }


}
