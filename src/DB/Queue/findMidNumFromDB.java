package DB.Queue;
import java.util.PriorityQueue;

/**
 * @Classname findMidNumFromDB
 * @Description TODO
 * 主要思路：需要使数据流中的数字有序，
 * 解法1：加入数字后，进行排序
 *
 * 解法二：在数据流结构中设置大小根堆，向大根堆中添加数字，
 * 完成之后查看大小根堆元素差值，若大于1，则将大根堆堆顶元素放置到小根堆，
 * 直至小于等于1即可，若等于1，则大根堆堆顶为中位数，等于0，则二者堆顶的平均值为中位数
 * 使用priorityQueue来实现大小根堆
 * priorityQueue默认加入该队列的元素从小到大排序，为使得出现大根堆，需要使用比较器对其方法进行重写
 * @Date 2019-03-14 09:55
 * @Created by guo
 */
public class findMidNumFromDB {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);

    public void addNum(int num) {
        if (num < findMedian()) { //当前添加的数比中位数小，放入大根堆
            maxHeap.add(num);
        }
        else {  //当前添加的数比中位数大或相等，放入大根堆
            minHeap.add(num);
        }

        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        }


        if(minHeap.size()>maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
        else if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        }

    }

    public double findMedian() {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            return 0;
        }
        if (minHeap.size() == maxHeap.size()){
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }
        return maxHeap.peek();


    }
}
