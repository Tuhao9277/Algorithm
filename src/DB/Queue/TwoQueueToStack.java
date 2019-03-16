package DB.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueueToStack {
    private Queue<Integer> queue;
    private Queue<Integer> help;

    public TwoQueueToStack() {
        queue = new LinkedList<Integer>();
        help = new LinkedList<Integer>();
    }
    public void push(int pushInt){
        queue.add(pushInt); //直接向队列中压入元素
    }
    public int pop(){
        if (queue.isEmpty()) {
            throw new RuntimeException("The queue is empty");
        }
        while (queue.size() >1){
            help.add(queue.poll()); //取出queue中的值压入help中直到只剩一个元素
        }
        int res = queue.poll();     //获得者最后一个元素
        swap();
        return res;
    }
    public int peek(){
        if (queue.isEmpty()) {
            throw new RuntimeException("The queue is empty");
        }
        while (queue.size() != 1){
            help.add(queue.poll()); //取出queue中的值压入help中直到只剩一个元素
        }
        int res = queue.poll();     //获得者最后一个元素
        swap();
        return res;
    }
    public void swap(){
        Queue temp = queue;
        queue = help;
        help = temp;
    };
}
