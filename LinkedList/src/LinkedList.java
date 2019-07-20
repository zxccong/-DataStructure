/**
 * 链表
 * @param <E>
 */
public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }
        public Node(){
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node demmyHead;

    int size;

    /**
     * 构造函数
     */
    public LinkedList() {
        demmyHead = new Node(null,null);
        size = 0;
    }

    /**
     * 获得大小
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 判断是否未空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }



    public void add(int index,E e){
        if (index<0|| index>size){
            throw new IllegalArgumentException("Add failed . Illegal index");

        }


            Node pre = demmyHead;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }

//            Node node = new Node(e);
//            node.next = pre.next;
//            pre.next = node;


            pre.next=new Node(e, pre.next);
            size++;


    }

    //在链表头添加元素
    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;

//        head = new Node(e, head);
//        size++;

        add(0,e);

    }

    /**
     * 末尾添加元素
     * @param e
     */
    public void addLast(E e){
        add(size, e);
    }

    /**
     * 获取链表的的值
     * @param index
     * @return
     */
    public E get(int index){
        if (index<0|| index>size){
            throw new IllegalArgumentException("Get failed . Illegal index");
        }

        Node cur = demmyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获得第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获得最后一个元素
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 设置链表元素
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if (index<0|| index>size){
            throw new IllegalArgumentException("Set failed . Illegal index");
        }

        Node cur = demmyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e=e;
    }

    public boolean contains(E e ){
        Node cur = demmyHead.next;
        while (cur != null){
            if (cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

//        Node cur = demmyHead.next;
//        while (cur!=null){
//            res.append(cur + "->");
//            cur = cur.next;
//        }

        for(Node cur = demmyHead.next;cur !=null ; cur = cur.next){
            res.append(cur + "->");
        }
        res.append("NULL");

        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Object> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println("linkedList = " + linkedList);
        }

        //插入
        linkedList.add(2,666);
        System.out.println("linkedList = " + linkedList);



    }


}
