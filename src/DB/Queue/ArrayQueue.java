package DB.Queue;

/*先进先出
*
* 循环队列
* */
public class ArrayQueue {
    private Integer arr[];
    private Integer size;
    private Integer start;
    private Integer end;

    public ArrayQueue(int initSize) {
        arr = new Integer[initSize];
        size = 0;
        start = 0;
        end = 0;
    }

    //返回队头元素,只返回
    public Integer peek() {
        if (size == 0)
            return null;
        return arr[start];
    }

    //出队，弹出
    public Integer poll() {
        if (size == 0)
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        size--;
        int tmp = start;
        start = nextIndex(arr.length, start);
        return arr[tmp];
    }

    //入队
    public void push(int obj) {
        if (size == arr.length)
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        size++;
        arr[end] = obj;
        end = nextIndex(arr.length, end);
    }

    public int nextIndex(int size, int index) {
        return index == size ? 0 : index + 1;
    }
    public static void main(String[] args) {
        int arr[] = {1, 50, 33, 78, 29, 98, 45};
    }
}
