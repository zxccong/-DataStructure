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

    private Node head;
    int size;

    /**
     * 构造函数
     */
    public LinkedList() {
        head = null;
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

    //在链表头添加元素
    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;

        head = new Node(e, head);
        size++;

    }

    public void add(int index,E e){
        if (index<0|| index>size){
            throw new IllegalArgumentException("Add failed . Illegal index");

        }

        if (index==0){
            addFirst(e);
        }else {
            Node pre = head;
            for (int i = 0; i < index-1; i++) {
                pre = pre.next;
            }

//            Node node = new Node(e);
//            node.next = pre.next;
//            pre.next = node;


            pre.next=new Node(e, pre.next);
            size++;

        }
    }

    /**
     * 末尾添加元素
     * @param e
     */
    public void addList(E e){
        add(size, e);
    }



}
