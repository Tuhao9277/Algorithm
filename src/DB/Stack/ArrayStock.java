package DB.Stack;

public class ArrayStock {
    private Integer arr[];
    private Integer index;

    public ArrayStock(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("The initSize must be larger than 0");
        }
        arr = new Integer[initSize];
        index = 0;
    }

    //查看栈顶元素 ，不删除
    public Integer peek(int index) {
        if (index == 0)
            return null;
        return arr[index - 1];
    }

    //入栈
    public void push(int obj) {
        if (index == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The stock is full");
        }
        arr[index++] = obj;
    }

    //出栈
    public Integer pop() {
        if (index == 0) {
            throw new ArrayIndexOutOfBoundsException("The stock is empty");
        }
        return arr[--index];
    }
    public static void main(String[] args) {
        int arr[] = {1, 50, 33, 78, 29, 98, 45};
    }

}
