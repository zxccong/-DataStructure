/**
 * 数组栈
 * @param <E>
 *
 *
 *     时间复杂度分析
 *
 *     void  push()     O(1)均摊
 *     E pop()          O(1)均摊
 *     E peek()         O（1）
 *     int getSize()    O(1)
 *     boolean isEmpty()O(1)
 *
 *
 */
public class ArrayStack<E> implements Stack<E> {
    Array3<E> array;

    public ArrayStack(int caoacity){
        array = new Array3<>(caoacity);
    }

    public ArrayStack(){
        array = new Array3<>(); //默认大小10
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
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i!=array.getSize()-1){
                res.append(",");

            }
        }
        res.append("] top");
        return res.toString();
    }
}
