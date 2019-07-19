import java.util.Random;

/**
 * 队列Queue
 *
 * 队列食一种先进先出的数据结构（先到先得）
 *
 * First in First Out(FIFO) 先进先出
 *
 */
public class Main {

    private static double testQueue(Queue<Integer> q , int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int opCount=100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time = testQueue(arrayQueue, opCount);
        System.out.println("time = " + time);

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("time2 = " + time2);
    }
}
