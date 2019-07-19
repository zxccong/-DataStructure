import sun.invoke.empty.Empty;

/**
 * 栈接口
 *
 *  *
 *  * 函数调用压栈
 * @param <E>
 */
public interface Queue<E> {

    void enqueue(E e);

    E dequeue();

    E getFront();

    int getSize();

    boolean isEmpty();


}