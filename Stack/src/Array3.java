/**
 * 使用添加动态数组
 *
 *
 * 总结时间复杂度
 *
 * 增加 O(n)  （最坏的情况）
 *                  增加和删除的对最后一个元素的操作时间复杂度O(1) ,
 *                  但是考虑到有resize这个炒作，所以会导致了时间复杂度都为O（n）
 * 删除 O(n) （最坏的情况）
 *
 * 改变 已知索引O(1);未知索引O(n)
 *
 * 查找 已知索引O(1);未知索引O(n)
 *
 * 均摊复杂度和防止复杂度震荡（amortized time complexity）
 *
 * 假设当前capacity = 8 ,并且每一次添加操作都是用addList()
 *  1 1 1 1 1 1 1 1 1 8+1 （这里的8+1是指移动8个元素到resize后的新数组需要的操作）
 * 9次操作，触发一次resize,总共触发17次基本操作
 *
 * 假设capacity = n ,n +1次addList，触发resiez ,总共 2n+1次基本操作，
 * 平均每次addList操作进行2次基本操作
 *
 * 平均每次addList操作，进行2次基本操作
 * 这样均摊计算，时间复杂度是O(1)的
 * 在例子中，这样均摊计算，比计算最坏情况有意义
 *
 * 平均，每次addList操作，进行2次基本操作
 * 所以时间复杂度为O（1）
 *
 *
 * 复杂度震荡
 *
 * 刚好到容量大小中
 * 增加1次后删除一次2次都需要进行增容，缩容，导致每次 都要进行O(n)的时间复杂度运算
 *
 * 解决方法：
 * 删除的 时候size == capacity/4，才将capacity减半
 *
 *
 * */
public class Array3<E> {
    private E[] data;

    //指向最后一个数组为空的索引
    private int size;

    /**
     * 构造函数，传入数组的容量的capacity构造Array
     * @param capacity
     */
    public Array3(int capacity){
        data = (E[]) new Object[capacity];      //历史遗留问题，不支持直接new 一个泛型数组
        size = 0;
    }

    /**
     * 无参数的构造函数，默认数组容量capacity=10
     */
    public Array3(){
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
     * 添加元素到末尾      //时间复杂度O(1)无论数据再多，也是使用一次就能完成
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
     * 添加元素到数组前面 //时间复杂度O(n)于元素个数成线性关系，元素越多时间越长
     *
     * @param e
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 添加元素到自定未知    //index的概率可能是0-n之间，所以O（n/2）=O(n),平均是n/2也简单看为n 极端的情况下O（n）
     * @param index
     * @param e
     */
    public void add(int index,E e){

        if (index<0||index>size){
            throw new IllegalArgumentException("Add failed . Require index<0||index>size");
        }

        if (size == data.length){
//            throw new IllegalArgumentException("Add failed . Array is full");
            resize(2 * data.length);

        }

        for (int i = size -1;i>=index;i--){
            data[i+1] = data[i];
        }
        data[index]=e;
        size++;
    }

    /**
     * 重新分配动态的数组，时间复杂度O（n）  所以总结添加元素的时间复杂度是 O(n)
     * @param i
     */
    private void resize(int i) {
        E[] newData= (E[]) new Object[i];
        for (int j = 0; j < size; j++) {
            newData[j] = data[j];
        }
        data=newData;
    }

    /**
     * 通过index索引位置的元素为e     时间复杂度 O(1)
     * @param index
     * @return
     */
    E get(int index){
        if (index<0||index>=size){
            throw new IllegalArgumentException("Get Failed Index is illegal");
        }
        return data[index];
    }

    E getLast(){
        return get(size-1);

    }

    E getFirst(){
        return get(0);
    }

    /**\
     * 查找数组中是否有元素e      时间复杂度 O(n)
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
     * 查找数组中元素e所在的位置，如果不存在元素e,则返回-1         时间复杂度O(n)
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
     * 从数组中删除index位置的 元素，返回删除的元素    时间复杂度O(n/2)-> O(n)看成是O(n)
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

        if (size == data.length/4&&data.length/2!=0){
            resize(data.length/2);
        }
        return ret;
    }

    /**
     * 删除第一个元素      时间复杂度O（n）
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除最后一个元素     时间复杂度O(1) 总的来说删除的时间复杂度O(n)
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
     * 根据index索引位置设置元素e        时间复杂度O(1)
     * @param index
     * @param e
     */
    void set(int index , E e ){
        if (index<0||index>=size){
            throw new IllegalArgumentException("Set Failed Index is illegal");
        }
        data[index] = e ;
    }

    /**
     * 重写
     * @return
     */
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
