/**
 * 栈接口
 *
 *  * 栈是一种后进先出的数据结构
 *  * Last In First Out(LIFO)
 *  *
 *  * 应用：
 *  * 无处不在的Undo操作
 *  undo操作 - 编辑器
 *  系统调用栈-操作系统
 *  括号匹配-编译器
 *
 *  *
 *  * 函数调用压栈
 * @param <E>
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}